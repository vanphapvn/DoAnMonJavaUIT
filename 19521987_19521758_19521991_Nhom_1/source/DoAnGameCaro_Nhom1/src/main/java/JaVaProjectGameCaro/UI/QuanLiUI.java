package JaVaProjectGameCaro.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.mysql.jdbc.Driver;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.LoaiXepHangDAO;
import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class QuanLiUI extends JFrame {
	
	private JTextField txtTenDangNhap;
	private JTextField txtIDXepHang;
	private JTextField txtTenXH;
	private JTextField txtDiemTu;
	private JTextField txtDiemCongThang;
	private JTextField txtDiemTruThua;
	
	private JButton btnTimKiem;
	private JButton btnAll;
	private JButton btnXoa;
	private JButton btnBieuDo;
	private JButton btnThoat;
	private JButton btnThoat1;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnXuatBaoCao;
	
	private JTable jtbDanhSachTK;
    private DefaultTableModel dftDanhSachTK;
    
    private List<NguoiChoi> dsTaiKhoan;
    
    private JList<LoaiXepHang> dsLoaiXepHang;
    
    private List<LoaiXepHang> dsLoaiXH;
    
    private LoaiXepHang xhSelect;
    
    private double PT0_50=0;
    private double PT50_100=0;
    private double PT100_300=0;
    private double PT300_500=0;
    private double PT500_800=0;
    private double PT800_1000=0;
    private double PTt1000=0;
    
    private Connection conn=null;
    
	public QuanLiUI() {
		addControls();
		addEvents();
		showWindown();
		loadDSXH();
	}
	public void showWindown() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void addControls() {
		Container con=getContentPane();
		JTabbedPane tab=new JTabbedPane();
		con.add(tab);
		
		JPanel pnQLTK=new JPanel();
		JPanel pnQLXH=new JPanel();
		tab.add(pnQLTK,"Quản lí tài khoản");
		tab.add(pnQLXH,"Quản lí xếp hạng");
		
		pnQLTK.setLayout(new BoxLayout(pnQLTK, BoxLayout.Y_AXIS));
		
		JPanel pnTKTaiKhoan=new JPanel();
		pnTKTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTenDangNhap=new JLabel("Tên đăng nhập");
		txtTenDangNhap=new JTextField(15);
		btnTimKiem=new JButton("Tìm kiếm");
		btnAll=new JButton("All");
		pnTKTaiKhoan.add(lblTenDangNhap);
		pnTKTaiKhoan.add(txtTenDangNhap);
		pnTKTaiKhoan.add(btnTimKiem);
		pnTKTaiKhoan.add(btnAll);
		pnQLTK.add(pnTKTaiKhoan);
		
		JPanel pnDS=new JPanel();
		pnDS.setLayout(new BorderLayout());
		Border borderDanhSach=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDanhSach=new TitledBorder(borderDanhSach,"Danh sách tài khoản");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnDS.setBorder(titleBorderDanhSach);
		pnQLTK.add(pnDS);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnXoa=new JButton("Xóa tài khoản");
		btnBieuDo=new JButton("Xem biểu đồ điểm xếp hạng");
		btnXuatBaoCao=new JButton("Xuất báo cáo xếp hạng");
		btnThoat=new JButton("Thoát");
		pnButton.add(btnXoa);
		pnButton.add(btnBieuDo);
		pnButton.add(btnXuatBaoCao);
		pnButton.add(btnThoat);
		pnQLTK.add(pnButton);
		
		dftDanhSachTK=new DefaultTableModel();
        dftDanhSachTK.addColumn("Tên đăng nhập"); 
        dftDanhSachTK.addColumn("Mật khẩu");
        dftDanhSachTK.addColumn("Tên hiển thị");
        dftDanhSachTK.addColumn("ID xếp hạng");
        dftDanhSachTK.addColumn("Điểm xếp hạng");
        dftDanhSachTK.addColumn("Số trận thắng");
        dftDanhSachTK.addColumn("Số trận thua");
        jtbDanhSachTK=new JTable(dftDanhSachTK);
        
        JScrollPane scTable1=new JScrollPane(jtbDanhSachTK,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnDS.add(scTable1,BorderLayout.CENTER);
        
        pnQLXH.setLayout(new BoxLayout(pnQLXH, BoxLayout.Y_AXIS));
        JPanel pnDSvaChiTiet=new JPanel();
        pnQLXH.add(pnDSvaChiTiet);
        pnDSvaChiTiet.setLayout(new GridLayout(1,2));
        
        JPanel pnDSXepHang=new JPanel();
        pnDSvaChiTiet.add(pnDSXepHang);
        pnDSXepHang.setLayout(new BorderLayout());
        
        Border borderDSXepHang=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleborderDSXepHang=new TitledBorder(borderDanhSach,"Danh sách loại xếp hạng");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnDSXepHang.setBorder(titleborderDSXepHang);
		
		dsLoaiXepHang=new JList<LoaiXepHang>();
		JScrollPane sc=new JScrollPane(dsLoaiXepHang,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDSXepHang.add(sc,BorderLayout.CENTER);
		
		JPanel pnChiTiet=new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		
		Border borderChiTiet=BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderChiTiet=new TitledBorder(borderChiTiet,"Thông tin chi tiết");
		titleBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titleBorderChiTiet.setTitleColor(Color.RED);
		pnChiTiet.setBorder(titleBorderChiTiet);
		
		pnDSvaChiTiet.add(pnChiTiet);
		
		JPanel pnIDXepHang=new JPanel();
		pnIDXepHang.setLayout(new FlowLayout());
		pnChiTiet.add(pnIDXepHang);
		JLabel lblIDXepHang=new JLabel("ID xếp hạng");
		pnIDXepHang.add(lblIDXepHang);
		txtIDXepHang=new JTextField(15);
		txtIDXepHang.setEditable(false);
		pnIDXepHang.add(txtIDXepHang);
		
		JPanel pnTenXH=new JPanel();
		pnTenXH.setLayout(new FlowLayout());
		pnChiTiet.add(pnTenXH);
		JLabel lblTenXH=new JLabel("Tên xếp hạng");
		txtTenXH=new JTextField(15);
		pnTenXH.add(lblTenXH);
		pnTenXH.add(txtTenXH);
		
		JPanel pnDiemTu=new JPanel();
		pnDiemTu.setLayout(new FlowLayout());
		pnChiTiet.add(pnDiemTu);
		JLabel lblDiemTu=new JLabel("Điểm từ");
		txtDiemTu=new JTextField(15);
		pnDiemTu.add(lblDiemTu);
		pnDiemTu.add(txtDiemTu);
		
		JPanel pnDiemCongThang=new JPanel();
		pnDiemCongThang.setLayout(new FlowLayout());
		pnChiTiet.add(pnDiemCongThang);
		JLabel lblDiemCongThang=new JLabel("Điểm cộng thắng");
		txtDiemCongThang=new JTextField(15);
		pnDiemCongThang.add(lblDiemCongThang);
		pnDiemCongThang.add(txtDiemCongThang);
		
		JPanel pnDiemTruThua=new JPanel();
		pnDiemTruThua.setLayout(new FlowLayout());
		pnChiTiet.add(pnDiemTruThua);
		JLabel lblDiemTruThua=new JLabel("Điểm trừ thua");
		txtDiemTruThua=new JTextField(15);
		pnDiemTruThua.add(lblDiemTruThua);
		pnDiemTruThua.add(txtDiemTruThua);
		
		lblIDXepHang.setPreferredSize(lblDiemCongThang.getPreferredSize());
		lblTenXH.setPreferredSize(lblDiemCongThang.getPreferredSize());
		lblDiemTu.setPreferredSize(lblDiemCongThang.getPreferredSize());
		lblDiemTruThua.setPreferredSize(lblDiemCongThang.getPreferredSize());
		
		JPanel pnChucNang=new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnChiTiet.add(pnChucNang);
		btnSua=new JButton("Cập nhật");
		btnLamMoi=new JButton("Làm mới");
		btnThoat1=new JButton("Thoát");
		pnChucNang.add(btnSua);
		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnThoat1);
	}
	
	private void loadDSXH() {
		dsLoaiXH=LoaiXepHangDAO.getDSLoaiXH();
		Vector<LoaiXepHang> ds=new Vector<LoaiXepHang>();
		for(int i=0;i<dsLoaiXH.size();i++) {
			ds.add(dsLoaiXH.get(i));
		}
		dsLoaiXepHang.setListData(ds);
	}
	
	public void addEvents() {
		this.btnBieuDo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tinhPhanTramBieuDo();
				showBieuDo();
			}
		});
		this.btnAll.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dsTaiKhoan=NguoiChoiDAO.getDSNguoiChoi(); 
				int temp=jtbDanhSachTK.getRowCount();
				if(jtbDanhSachTK.getRowCount()>0) {
					for(int i=0;i<temp;i++) {
						dftDanhSachTK.removeRow(0);
					}
					for(int i=0;i<dsTaiKhoan.size();i++) {
						Vector<Object> vec=new Vector<Object>();
						LoaiXepHang xh=dsTaiKhoan.get(i).getLoaiXepHang();
						vec.add(dsTaiKhoan.get(i).getTenDangNhap());
						vec.add(dsTaiKhoan.get(i).getMatKhau());
						vec.add(dsTaiKhoan.get(i).getTenHienThi());
						vec.add(xh.getIdXepHang());
						vec.add(dsTaiKhoan.get(i).getDiemXepHang());
						vec.add(dsTaiKhoan.get(i).getSoLanThang());
						vec.add(dsTaiKhoan.get(i).getSoLanThua());
						dftDanhSachTK.addRow(vec);
					}
				}else {
					for(int i=0;i<dsTaiKhoan.size();i++) {
						Vector<Object> vec=new Vector<Object>();
						LoaiXepHang xh=dsTaiKhoan.get(i).getLoaiXepHang();
						vec.add(dsTaiKhoan.get(i).getTenDangNhap());
						vec.add(dsTaiKhoan.get(i).getMatKhau());
						vec.add(dsTaiKhoan.get(i).getTenHienThi());
						vec.add(xh.getIdXepHang());
						vec.add(dsTaiKhoan.get(i).getDiemXepHang());
						vec.add(dsTaiKhoan.get(i).getSoLanThang());
						vec.add(dsTaiKhoan.get(i).getSoLanThua());
						dftDanhSachTK.addRow(vec);
					}
				}
				
			}
		});
		
		this.txtTenDangNhap.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(txtTenDangNhap.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập !");
						return;
					}
					if(NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText())==null) {
						JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại !");
						return;
					}
					int temp=jtbDanhSachTK.getRowCount();
					if(jtbDanhSachTK.getRowCount()>0) {
						for(int i=0;i<temp;i++) {
							dftDanhSachTK.removeRow(0);
						}
						NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText());
						LoaiXepHang xh=nc.getLoaiXepHang();
						Vector<Object> vec=new Vector<Object>();
						vec.add(nc.getTenDangNhap());
						vec.add(nc.getMatKhau());
						vec.add(nc.getTenHienThi());
						vec.add(xh.getIdXepHang());
						vec.add(nc.getDiemXepHang());
						vec.add(nc.getSoLanThang());
						vec.add(nc.getSoLanThua());
						dftDanhSachTK.addRow(vec);
					}else {
						NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText());
						LoaiXepHang xh=nc.getLoaiXepHang();
						Vector<Object> vec=new Vector<Object>();
						vec.add(nc.getTenDangNhap());
						vec.add(nc.getMatKhau());
						vec.add(nc.getTenHienThi());
						vec.add(xh.getIdXepHang());
						vec.add(nc.getDiemXepHang());
						vec.add(nc.getSoLanThang());
						vec.add(nc.getSoLanThua());
						dftDanhSachTK.addRow(vec);
					}
				}
			}
		} );
		
		this.btnTimKiem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtTenDangNhap.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập !");
					return;
				}
				if(NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText())==null) {
					JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại !");
					return;
				}
				int temp=jtbDanhSachTK.getRowCount();
				if(jtbDanhSachTK.getRowCount()>0) {
					for(int i=0;i<temp;i++) {
						dftDanhSachTK.removeRow(0);
					}
					NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText());
					LoaiXepHang xh=nc.getLoaiXepHang();
					Vector<Object> vec=new Vector<Object>();
					vec.add(nc.getTenDangNhap());
					vec.add(nc.getMatKhau());
					vec.add(nc.getTenHienThi());
					vec.add(xh.getIdXepHang());
					vec.add(nc.getDiemXepHang());
					vec.add(nc.getSoLanThang());
					vec.add(nc.getSoLanThua());
					dftDanhSachTK.addRow(vec);
				}else {
					NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(txtTenDangNhap.getText());
					LoaiXepHang xh=nc.getLoaiXepHang();
					Vector<Object> vec=new Vector<Object>();
					vec.add(nc.getTenDangNhap());
					vec.add(nc.getMatKhau());
					vec.add(nc.getTenHienThi());
					vec.add(xh.getIdXepHang());
					vec.add(nc.getDiemXepHang());
					vec.add(nc.getSoLanThang());
					vec.add(nc.getSoLanThua());
					dftDanhSachTK.addRow(vec);
				}
			}
		});
		
		this.btnXoa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=jtbDanhSachTK.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa !");
					return;
				}
				NguoiChoi nc=NguoiChoiDAO.getNguoiChoi((String)jtbDanhSachTK.getValueAt(row, 0));
				NguoiChoiDAO.xoaNguoiChoi(nc);
				dftDanhSachTK.removeRow(row);
				JOptionPane.showMessageDialog(null, "Xóa thành công !");
			}
		});
		
		this.btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		this.btnThoat1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		this.dsLoaiXepHang.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(dsLoaiXepHang.getSelectedIndex()==-1) return;
				xhSelect=dsLoaiXepHang.getSelectedValue();
				
				txtIDXepHang.setText(String.valueOf(xhSelect.getIdXepHang()));
				txtTenXH.setText(xhSelect.getTenXepHang());
				txtDiemTu.setText(String.valueOf(xhSelect.getDiemTu()));
				txtDiemCongThang.setText(String.valueOf(xhSelect.getDiemCongThang()));
				txtDiemTruThua.setText(String.valueOf(xhSelect.getDiemTruThua()));
			}
		});
		
		this.btnSua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoaiXepHang xh=new LoaiXepHang();
				xh.setIdXepHang(Integer.parseInt(txtIDXepHang.getText()));
				xh.setTenXepHang(txtTenXH.getText());
				xh.setDiemTu(Integer.parseInt(txtDiemTu.getText()));
				xh.setDiemCongThang(Integer.parseInt(txtDiemCongThang.getText()));
				xh.setDiemTruThua(Integer.parseInt(txtDiemTruThua.getText()));
				
				LoaiXepHangDAO.suaLoaXH(xh);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				
				loadDSXH();
			}
		});
		
		this.btnLamMoi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtIDXepHang.setText(null);
				txtTenXH.setText(null);
				txtDiemTu.setText(null);
				txtDiemCongThang.setText(null);
				txtDiemTruThua.setText(null);
				
				loadDSXH();
			}
		});
		
		this.btnXuatBaoCao.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuatBC();
			}
		});
	}
	
	private void xuatBC() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dbsgamecaro?useUnicode=true&characterEncoding=utf-8", "root", "");
			JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/report/ReportXH.jrxml"));
			JasperPrint jp = JasperFillManager.fillReport(report, null, conn);
			JasperViewer.viewReport(jp, false);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	private void tinhPhanTramBieuDo() {
		dsTaiKhoan=NguoiChoiDAO.getDSNguoiChoi();
		for(int i=0;i<dsTaiKhoan.size();i++) {
			if(dsTaiKhoan.get(i).getDiemXepHang()>=0&&dsTaiKhoan.get(i).getDiemXepHang()<50) {
				PT0_50=PT0_50+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=50&&dsTaiKhoan.get(i).getDiemXepHang()<100) {
				PT50_100=PT50_100+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=100&&dsTaiKhoan.get(i).getDiemXepHang()<300) {
				PT100_300=PT100_300+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=300&&dsTaiKhoan.get(i).getDiemXepHang()<500) {
				PT300_500=PT300_500+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=500&&dsTaiKhoan.get(i).getDiemXepHang()<800) {
				PT500_800=PT500_800+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=800&&dsTaiKhoan.get(i).getDiemXepHang()<1000) {
				PT800_1000=PT800_1000+1;
			}
			if(dsTaiKhoan.get(i).getDiemXepHang()>=1000) {
				PTt1000=PTt1000+1;
			}
		}
		
		PT0_50=(PT0_50/dsTaiKhoan.size())*100;
		PT50_100=(PT50_100/dsTaiKhoan.size())*100;
		PT100_300=(PT100_300/dsTaiKhoan.size())*100;
		PT300_500=(PT300_500/dsTaiKhoan.size())*100;
		PT500_800=(PT500_800/dsTaiKhoan.size())*100;
		PT800_1000=(PT800_1000/dsTaiKhoan.size())*100;
		PTt1000=(PTt1000/dsTaiKhoan.size())*100;
	}
	
	private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "BIỂU ĐỒ CƠ CẤU NGƯỜI CHƠI THEO ĐIỂM XẾP HẠNG", dataset, true, true, true);
        return chart;
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Điểm 0 - 50", new Double(PT0_50));
        dataset.setValue("Điểm 50 - 100", new Double(PT50_100));
        dataset.setValue("Điểm 100 - 300", new Double(PT100_300));
        dataset.setValue("Điểm 300 - 500", new Double(PT300_500));
        dataset.setValue("Điểm 500 - 800", new Double(PT500_800));
        dataset.setValue("Điểm 800 - 1000", new Double(PT800_1000));
        dataset.setValue("Điểm trên 1000", new Double(PTt1000));
        return dataset;
    }
    
    public void showBieuDo() {
    	JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
