package JaVaProjectGameCaro.XuLi;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Player {
	private String userName;
	private ImageIcon imageKhung;
	private AddPictureToJpanel imgQuanCo;
	private ImageIcon imgXepHang;
	
	
	public Player(String userName, ImageIcon imageKhung, AddPictureToJpanel imgQuanCo,ImageIcon imgXepHang) {
		this.userName = userName;
		this.imageKhung = imageKhung;
		this.imgQuanCo = imgQuanCo;
		this.imgXepHang = imgXepHang;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}


	public ImageIcon getImageKhung() {
		return imageKhung;
	}

	public void setImageKhung(ImageIcon imageKhung) {
		this.imageKhung = imageKhung;
	}
	public AddPictureToJpanel getImgQuanCo() {
		return imgQuanCo;
	}
	public void setImgQuanCo(AddPictureToJpanel imgQuanCo) {
		this.imgQuanCo = imgQuanCo;
	}
	public ImageIcon getImgXepHang() {
		return imgXepHang;
	}
	public void setImgXepHang(ImageIcon imgXepHang) {
		this.imgXepHang = imgXepHang;
	}
	
	
}