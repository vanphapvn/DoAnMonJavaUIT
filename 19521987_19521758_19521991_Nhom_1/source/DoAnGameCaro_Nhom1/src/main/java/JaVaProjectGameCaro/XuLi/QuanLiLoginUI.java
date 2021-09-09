package JaVaProjectGameCaro.XuLi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;
import JaVaProjectGameCaro.UI.DangKiTaiKhoanUI;
import JaVaProjectGameCaro.UI.MenuPlayUI;
import JaVaProjectGameCaro.UI.PlayGameUI;
import JaVaProjectGameCaro.UI.QuanLiUI;

public class QuanLiLoginUI {
	private JButton btnDangNhap;
	private JButton btnDangKy;
	private JButton btnChoiOffline;
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JFrame JFLoginNow;
	
	private boolean isDaThuThucThi_UserName=false;
	private boolean isDaThuThucThi_PassWord=false;
	
	public QuanLiLoginUI(JButton btnDangNhap, JButton btnDangKy, JButton btnChoiOffline, JTextField txtUserName,JPasswordField txtPassWord,JFrame JFLoginNow) {
		this.btnDangNhap = btnDangNhap;
		this.btnDangKy = btnDangKy;
		this.btnChoiOffline = btnChoiOffline;
		this.txtUserName = txtUserName;
		this.txtPassWord = txtPassWord;
		this.JFLoginNow=JFLoginNow;
		AddEvents();
	}
	
	
	public void AddEvents() {
		


		this.txtUserName.addMouseListener(new MouseListener() {

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
				if(isDaThuThucThi_UserName==false) {
					txtUserName.setText(null);
					isDaThuThucThi_UserName=true;
				}
			}
		});


		this.txtPassWord.addMouseListener(new MouseListener() {

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
				if(isDaThuThucThi_PassWord==false) {
					txtPassWord.setText(null);
					isDaThuThucThi_PassWord=true;
				}
			}
		});
		
		
		this.btnDangNhap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					XuLiDangNhap();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.btnDangKy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					XuliDangKy();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.btnChoiOffline.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new MenuPlayUI("......",null, "......",0, 0, LuaChon.PLAYOFFLINE).setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFLoginNow.dispose();
			}
		});
	}

	protected void XuliDangKy() throws IOException {
		// TODO Auto-generated method stub
		JFLoginNow.setVisible(false);
		new DangKiTaiKhoanUI(JFLoginNow).setVisible(true);
	}


	private void XuLiDangNhap() throws IOException {
		// TODO Auto-generated method stub
		if(txtUserName.getText().isEmpty()==true&&txtPassWord.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Tên Tài Khoản Và Mật Khẩu !");
			return;
		}else {
			if(txtUserName.getText().isEmpty()==true&&txtPassWord.getText().isEmpty()==false) {
				
				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Tên Tài Khoản !");
				return;
				
			}
			if(txtPassWord.getText().isEmpty()==true&&txtUserName.getText().isEmpty()==false) {
				
				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Mật Khẩu !");
				return;
			}
		}
		
		if(txtUserName.getText().contentEquals("Admin")&&txtPassWord.getText().contentEquals("Admin")) {
			JFLoginNow.dispose();
			new QuanLiUI().setVisible(true);
			return;
		}

		if(NguoiChoiDAO.getNguoiChoi(txtUserName.getText())==null) {
			JOptionPane.showMessageDialog(null, "Tài Khoản Không Tồn Tại !");
			return;
		}else {
			if(NguoiChoiDAO.getNguoiChoi(txtUserName.getText()).getMatKhau().contentEquals(txtPassWord.getText())) {
				LoaiXepHang loaiXH=NguoiChoiDAO.getNguoiChoi(txtUserName.getText()).getLoaiXepHang();
				String tenDangNhap=NguoiChoiDAO.getNguoiChoi(txtUserName.getText()).getTenDangNhap();
				String tenHienThi=NguoiChoiDAO.getNguoiChoi(txtUserName.getText()).getTenHienThi();
				String tenXepHang=loaiXH.getTenXepHang();
				int thuTuXepHang=NguoiChoiDAO.getXHNguoiChoi(txtUserName.getText());
				int idXepHang=loaiXH.getIdXepHang();
				new MenuPlayUI(tenDangNhap, tenHienThi, tenXepHang, thuTuXepHang, idXepHang, LuaChon.PLAYONLINE).setVisible(true);;
				JFLoginNow.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Bạn Nhập Sai Mật Khẩu Vui Lòng Thử Lại !");
			}
		}
	}
	
}
