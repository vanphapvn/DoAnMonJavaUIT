package JaVaProjectGameCaro.XuLi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;

public class QuanLiDangKiTaiKhoanUI {
	private JButton btnDangKy;
	private JButton btnThoat;
    
    private JPasswordField txtNhapLaiPass;
    private JPasswordField txtPassword;
    private JTextField txtTenHienThi;
    private JTextField txtUsername;
    
    private JFrame JFLoginNow;
    private JFrame JFDangKiNow;
    
    private boolean isThuThitxtUsername=false;
    private boolean isThuThitxtTenHienThi=false;
    private boolean isThuThitxtPassword=false;
    private boolean isThuThitxtNhapLaiPass=false;
 

	public QuanLiDangKiTaiKhoanUI(JButton btnDangKy, JButton btnThoat, JTextField txtUsername,JTextField txtTenHienThi, JPasswordField txtPassword, JPasswordField txtNhapLaiPass, JFrame jFLoginNow,JFrame JFDangKiNow) {
		this.btnDangKy = btnDangKy;
		this.btnThoat = btnThoat;
		this.txtNhapLaiPass = txtNhapLaiPass;
		this.txtPassword = txtPassword;
		this.txtTenHienThi = txtTenHienThi;
		this.txtUsername = txtUsername;
		JFLoginNow = jFLoginNow;
		this.JFDangKiNow=JFDangKiNow;
		addEvents();
	}
	private void addEvents() {
		
		this.txtUsername.addMouseListener(new MouseListener() {
			
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
				if(isThuThitxtUsername==false) {
					txtUsername.setText(null);
					isThuThitxtUsername=true;
				}
			}
		});
		
		this.txtTenHienThi.addMouseListener(new MouseListener() {
			
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
				if(isThuThitxtTenHienThi==false) {
					txtTenHienThi.setText(null);
					isThuThitxtTenHienThi=true;
				}
			}
		});
		
		
		this.txtPassword.addMouseListener(new MouseListener() {
			
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
				if(isThuThitxtPassword==false) {
					txtPassword.setText(null);
					isThuThitxtPassword=true;
				}
			}
		});
		
		
		this.txtNhapLaiPass.addMouseListener(new MouseListener() {
			
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
				if(isThuThitxtNhapLaiPass==false) {
					txtNhapLaiPass.setText(null);
					isThuThitxtNhapLaiPass=true;
				}
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFDangKiNow.dispose();
				JFLoginNow.setVisible(true);
				
			}
		});
		
		this.btnDangKy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLinutDangKi();
			}
		});
	}
	private void xuLinutDangKi() {
		// TODO Auto-generated method stub
		if(this.txtUsername.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản không được để trống !");
			return;
		}
		
		Pattern patternUserName=Pattern.compile("[a-z0-9_-]{6,20}$");
		if(patternUserName.matcher(txtUsername.getText()).matches()==false) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản có độ tài từ 6 đến 20 ký tự, không có khoảng trắng, "
					+ "\r\n"
					+ "không dấu không chữa chữ in hoa và kí tự đặc biêt\r\n");
			return;
		}
		
	
		Pattern patternPassWord=Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
		if(patternPassWord.matcher(txtPassword.getText()).matches()==false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu có độ dài từ 8 đến 20 kí tự và :"
					+ "\r\n"
					+ "          + Phải chứa ít nhất 1 ký tự số từ 0 – 9\r\n"
					+ "\r\n"
					+ "          + Phải chứa ít nhất 1 ký tự chữ thường\r\n"
					+ "\r\n"
					+ "          + Phải chứa ít nhất 1 ký tự chữ hoa\r\n"
					+ "\r\n"
					+ "          + Không được chứa kí tự tiếng việt\r\n"
					+ "\r\n"
					+ "          + Phải chứa ít nhất 1 ký tự trong tập các ký tự [@ # $ %]");
			
			txtPassword.setText(null);
			
			return;
		}
		
		if(txtPassword.getText().contentEquals(txtNhapLaiPass.getText())==false) {
			JOptionPane.showMessageDialog(null, "Mật Khẩu Không Khớp Với Nhau Vui Lòng Nhập Lại ! ");
			txtNhapLaiPass.setText(null);
			return;
		}
		
		
		NguoiChoi ncDK=new NguoiChoi();
		ncDK.setTenDangNhap(txtUsername.getText());
		ncDK.setMatKhau(txtPassword.getText());
		ncDK.setTenHienThi(txtTenHienThi.getText());
		ncDK.setDiemXepHang(0);
		ncDK.setSoLanThang(0);
		ncDK.setSoLanThua(0);
		LoaiXepHang ncXH=new LoaiXepHang();
		ncXH.setIdXepHang(7);
		ncDK.setLoaiXepHang(ncXH);
		
		Boolean DK=NguoiChoiDAO.themNguoiChoi(ncDK);
		if(DK=false) {
			JOptionPane.showMessageDialog(null, "Tài Khoản Đã Tồn Tại Vui Lòng Thử Lại");
			return;
		}else {
			JOptionPane.showMessageDialog(null, "Đăng Kí Tài Khoản Thành Công !");
			JFDangKiNow.dispose();
			JFLoginNow.setVisible(true);
		}
	}
	

}
