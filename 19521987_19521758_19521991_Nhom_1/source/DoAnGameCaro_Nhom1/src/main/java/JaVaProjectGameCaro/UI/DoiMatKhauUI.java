package JaVaProjectGameCaro.UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;

public class DoiMatKhauUI extends JFrame {
	private JPasswordField txtMauKhauCu;
	private JPasswordField txtMauKhauMoi;
	private JPasswordField txtNhapLaiMauKhauMoi;
	
	private String tenDangNhap;
	
	private JButton btnOK;
	
	public DoiMatKhauUI(String tenDangNhap) {
		this.tenDangNhap=tenDangNhap;
		addControls();
		addEvents();
		ShowWindown();
	}
	public void ShowWindown() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void addControls() {
		Container con=getContentPane();
		
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnMatKhauCu=new JPanel();
		pnMatKhauCu.setLayout(new FlowLayout());
		JLabel lblMatKhauCu=new JLabel("Nhập mật khẩu cũ");
		this.txtMauKhauCu=new JPasswordField(15);
		pnMatKhauCu.add(lblMatKhauCu);
		pnMatKhauCu.add(this.txtMauKhauCu);
		pnMain.add(pnMatKhauCu);
		
		JPanel pnMatKhauMoi=new JPanel();
		pnMatKhauCu.setLayout(new FlowLayout());
		JLabel lblMatKhauMoi=new JLabel("Nhập mật khẩu mới");
		this.txtMauKhauMoi=new JPasswordField(15);
		pnMatKhauMoi.add(lblMatKhauMoi);
		pnMatKhauMoi.add(this.txtMauKhauMoi);
		pnMain.add(pnMatKhauMoi);
		
		JPanel pnNhapLaiMatKhauMoi=new JPanel();
		pnMatKhauCu.setLayout(new FlowLayout());
		JLabel lblNhapLaiMatKhauMoi=new JLabel("Nhập lại mật khẩu mới");
		this.txtNhapLaiMauKhauMoi=new JPasswordField(15);
		pnNhapLaiMatKhauMoi.add(lblNhapLaiMatKhauMoi);
		pnNhapLaiMatKhauMoi.add(this.txtNhapLaiMauKhauMoi);
		pnMain.add(pnNhapLaiMatKhauMoi);
		
		JPanel pnOK=new JPanel();
		pnOK.setLayout(new FlowLayout());
		btnOK=new JButton("OK");
		pnOK.add(btnOK);
		pnMain.add(pnOK);
		
		lblMatKhauCu.setPreferredSize(lblNhapLaiMatKhauMoi.getPreferredSize());
		lblMatKhauMoi.setPreferredSize(lblNhapLaiMatKhauMoi.getPreferredSize());
		
	}
	public void addEvents() {
		this.btnOK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLiOK();
			}
		});
	}
	
	private void xuLiOK() {
		NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(tenDangNhap);
		if(txtMauKhauCu.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu cũ !");
			return;
		}
		if(txtMauKhauCu.getText().contentEquals(nc.getMatKhau())==false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác !");
			return;
		}
		
		if(txtMauKhauMoi.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới !");
			return;
		}
		Pattern patternPassWord=Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
		if(patternPassWord.matcher(txtMauKhauMoi.getText()).matches()==false) {
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
			
			txtMauKhauMoi.setText(null);
			
			return;
		}
		
		if(txtMauKhauMoi.getText().contentEquals(txtNhapLaiMauKhauMoi.getText())==false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không khớp với nhau vui lòng nhập lại !");
			txtNhapLaiMauKhauMoi.setText(null);
			return;
		}
		
		nc.setMatKhau(txtMauKhauMoi.getText());
		Boolean xacnhan=NguoiChoiDAO.suaNguoiChoi(nc);
		if(xacnhan==true) {
			JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công !");
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại !");
			this.dispose();
		}
		
	}
}
