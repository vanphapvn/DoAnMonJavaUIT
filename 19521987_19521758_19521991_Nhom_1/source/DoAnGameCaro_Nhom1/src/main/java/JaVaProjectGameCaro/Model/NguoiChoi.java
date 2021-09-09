package JaVaProjectGameCaro.Model;

public class NguoiChoi {
	private String tenDangNhap;
	private String matKhau;
	private String tenHienThi;
	private LoaiXepHang loaiXepHang;
	private int diemXepHang;
	private int soLanThang;
	private int soLanThua;
	public NguoiChoi() {
	}
	
	public NguoiChoi(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	
	public NguoiChoi(String tenDangNhap, String matKhau, String tenHienThi, LoaiXepHang loaiXepHang, int diemXepHang,int soLanThang, int soLanThua) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.tenHienThi = tenHienThi;
		this.loaiXepHang = loaiXepHang;
		this.diemXepHang = diemXepHang;
		this.soLanThang = soLanThang;
		this.soLanThua = soLanThua;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenHienThi() {
		return tenHienThi;
	}
	public void setTenHienThi(String tenHienThi) {
		this.tenHienThi = tenHienThi;
	}

	public LoaiXepHang getLoaiXepHang() {
		return loaiXepHang;
	}

	public void setLoaiXepHang(LoaiXepHang loaiXepHang) {
		this.loaiXepHang = loaiXepHang;
	}

	public int getDiemXepHang() {
		return diemXepHang;
	}

	public void setDiemXepHang(int diemXepHang) {
		this.diemXepHang = diemXepHang;
	}

	public int getSoLanThang() {
		return soLanThang;
	}

	public void setSoLanThang(int soLanThang) {
		this.soLanThang = soLanThang;
	}

	public int getSoLanThua() {
		return soLanThua;
	}

	public void setSoLanThua(int soLanThua) {
		this.soLanThua = soLanThua;
	}

	
}

