package JaVaProjectGameCaro.Model;

import java.util.HashSet;
import java.util.Set;

public class LoaiXepHang {
	private int idXepHang;
	private String tenXepHang;
	private int diemTu;
	private int diemCongThang;
	private int diemTruThua;
	private Set<NguoiChoi> dsNguoiChoi=new HashSet<NguoiChoi>(0);
	
	public LoaiXepHang() {
	}
	
	public LoaiXepHang(int idXepHang, String tenXepHang, int diemTu, int diemCongThang, int diemTruThua) {
		this.idXepHang = idXepHang;
		this.tenXepHang = tenXepHang;
		this.diemTu = diemTu;
		this.diemCongThang = diemCongThang;
		this.diemTruThua = diemTruThua;
	}

	public int getIdXepHang() {
		return idXepHang;
	}
	public void setIdXepHang(int idXepHang) {
		this.idXepHang = idXepHang;
	}
	public String getTenXepHang() {
		return tenXepHang;
	}
	public void setTenXepHang(String tenXepHang) {
		this.tenXepHang = tenXepHang;
	}
	public int getDiemTu() {
		return diemTu;
	}
	public void setDiemTu(int diemTu) {
		this.diemTu = diemTu;
	}
	public int getDiemCongThang() {
		return diemCongThang;
	}
	public void setDiemCongThang(int diemCongThang) {
		this.diemCongThang = diemCongThang;
	}
	public int getDiemTruThua() {
		return diemTruThua;
	}
	public void setDiemTruThua(int diemTruThua) {
		this.diemTruThua = diemTruThua;
	}

	public Set<NguoiChoi> getDsNguoiChoi() {
		return dsNguoiChoi;
	}

	public void setDsNguoiChoi(Set<NguoiChoi> dsNguoiChoi) {
		this.dsNguoiChoi = dsNguoiChoi;
	}

	@Override
	public String toString() {
		return tenXepHang;
	}
	
}
