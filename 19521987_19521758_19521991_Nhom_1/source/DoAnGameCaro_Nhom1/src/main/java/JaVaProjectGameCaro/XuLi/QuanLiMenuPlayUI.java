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
				JOptionPane.showMessageDialog(null, "Nhi???m v??? c???a m???i ng?????i ch??i c??? caro ???? l?? ?????t ???????c m???t:\n "
						+ "???????ng th???ng, ???????ng ch??o, ???????ng ngang v???i 5 ?? nhanh nh???t.\n "
						+ "Tuy nhi??n, ch??? c???n ng?????i ch??i n??o c?? th??? ?????t 4 n?????c m??\n"
						+ "b??? ch???n 1 ?????u ho???c kh??ng b??? ch???n hai ?????u l?? ???? c?? th??? chi???n th???ng.");
			}
		});
		
		this.btnThongTinPM.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "S???n ph???m thu???c s??? h???u c???a sinh vi??n Tr?????ng ??H C??ng ngh??? th??ng tin (UIT).\n"
						+ "Vui l??ng kh??ng sao ch??p nguy??n g???c v???i m???c ????ch c?? nh??n !.\n"
						+ "Nh??m ph??t tri???n : Hu???nh V??n Ph??p (19521987), Nguy???n Th??y Linh(19521758), H??? Hu???nh Tu???n Ph??t(19521991).\n"
						+ "Khoa : H??? th??ng th??ng tin, l???p : HTCL2019.2, kh??a : 2019");
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
