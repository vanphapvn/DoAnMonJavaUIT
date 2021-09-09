package JaVaProjectGameCaro.XuLi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import JaVaProjectGameCaro.Main.Main;
import JaVaProjectGameCaro.ServerAndClient.QuanLiPlayGameUIClient;
import JaVaProjectGameCaro.ServerAndClient.QuanLiPlayGameUIServer;
import JaVaProjectGameCaro.UI.DoiMatKhauUI;
import JaVaProjectGameCaro.UI.PlayGameUI;
import JaVaProjectGameCaro.UI.XepHangUI;

public class QuanLiMenuPlayUI {

	private JButton btnBXH;
	private JButton btnChoiHaiNguoi;
	private JButton btnChoiOnline;
	private JButton btnChoiVoiMay;
	private JButton btnDoiMatKhau;
	private JButton btnHuongDan;
	private JButton btnThoat;
	private JButton btnThongTinPM;
	
	private String tenDangNhap;
	private String tenHienThi;
	private int idXepHang;
	
	private int thuTuXH;

	private JFrame jfMenuNow;

	public QuanLiMenuPlayUI(JButton btnBXH, JButton btnChoiHaiNguoi, JButton btnChoiOnline, JButton btnChoiVoiMay,JButton btnDoiMatKhau, JButton btnHuongDan, JButton btnThoat, JButton btnThongTinPM,String tenDangNhap,String tenHienThi,int idXepHang,int thuTuXH,JFrame jfMenuNow ) {
		this.btnBXH = btnBXH;
		this.btnChoiHaiNguoi = btnChoiHaiNguoi;
		this.btnChoiOnline = btnChoiOnline;
		this.btnChoiVoiMay = btnChoiVoiMay; 
		this.btnDoiMatKhau = btnDoiMatKhau;
		this.btnHuongDan = btnHuongDan;
		this.btnThoat = btnThoat;
		this.btnThongTinPM = btnThongTinPM;
		this.tenHienThi=tenHienThi;
		this.tenDangNhap=tenDangNhap;
		this.idXepHang=idXepHang;
		this.jfMenuNow=jfMenuNow;
		this.thuTuXH=thuTuXH;
		addEventsChoiOffline();
		addEvenChoiOnline();
	}
	public QuanLiMenuPlayUI(JButton btnChoiHaiNguoi, JButton btnChoiVoiMay, JButton btnHuongDan, JButton btnThoat,JButton btnThongTinPM,JFrame jfMenuNow) {
		this.btnChoiHaiNguoi = btnChoiHaiNguoi;
		this.btnChoiVoiMay = btnChoiVoiMay;
		this.btnHuongDan = btnHuongDan;
		this.btnThoat = btnThoat;
		this.btnThongTinPM = btnThongTinPM;
		this.jfMenuNow=jfMenuNow;
		addEventsChoiOffline();

	}

	public void addEvenChoiOnline() {
		this.btnChoiOnline.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					xuLiChoiOnline();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.btnDoiMatKhau.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DoiMatKhauUI(tenDangNhap).setVisible(true);
			}
		});
		
		this.btnBXH.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new XepHangUI(thuTuXH, jfMenuNow).setVisible(true);
				jfMenuNow.setVisible(false);
			}
		});
	}

	private void xuLiChoiOnline() throws IOException {
		if(Main.isTCPPortAvailable(Vars.PORT)==false) {
			jfMenuNow.setVisible(false);
			new PlayGameUI(tenDangNhap,tenHienThi,idXepHang,LuaChon.CLIENT, jfMenuNow).setVisible(true);
		}else {
			jfMenuNow.setVisible(false);
			new PlayGameUI(tenDangNhap,tenHienThi,idXepHang,LuaChon.SERVER, jfMenuNow).setVisible(true);
		}
	}

	public void addEventsChoiOffline() {
		this.btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.btnChoiVoiMay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				try {
					xuLiChoiVoiMay();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		this.btnChoiHaiNguoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xuLiChoiHaiNguoi();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.btnHuongDan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Nhiệm vụ của mỗi người chơi cờ caro đó là đạt được một:\n "
						+ "đường thẳng, đường chéo, đường ngang với 5 ô nhanh nhất.\n "
						+ "Tuy nhiên, chỉ cần người chơi nào có thể đạt 4 nước mà\n"
						+ "bị chặn 1 đầu hoặc không bị chặn hai đầu là đã có thể chiến thắng.");
			}
		});
		
		this.btnThongTinPM.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Sản phầm thuộc sở hữu của sinh viên Trường ĐH Công nghệ thông tin (UIT).\n"
						+ "Vui lòng không sao chép nguyên gốc với mục đích cá nhân !.\n"
						+ "Nhóm phát triển : Huỳnh Văn Pháp (19521987), Nguyễn Thùy Linh(19521758), Hồ Huỳnh Tuấn Phát(19521991).\n"
						+ "Khoa : Hệ thông thông tin, lớp : HTCL2019.2, khóa : 2019");
			}
		});
	}
	private void xuLiChoiHaiNguoi() throws IOException {
		new PlayGameUI(null,null,0,LuaChon.TWOPLAYER, jfMenuNow).setVisible(true);
		jfMenuNow.setVisible(false);
	}
	private void xuLiChoiVoiMay() throws IOException {
		new PlayGameUI(null,null,0,LuaChon.PLAYWITHCOMPUTER,jfMenuNow).setVisible(true);
		jfMenuNow.setVisible(false);
	}
}
