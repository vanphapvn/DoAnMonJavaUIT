package JaVaProjectGameCaro.XuLi;

import javax.swing.JButton;

public class Oco extends JButton {
	private int vtCot;
	private int vtDong;
	private boolean daDanh;
	private int oCo;
	public Oco(int vtCot, int vtDong, boolean daDanh) {
		super();
		this.vtCot = vtCot;
		this.vtDong = vtDong;
		this.daDanh = daDanh;
	}
	public int getVtCot() {
		return vtCot;
	}
	public void setVtCot(int vtCot) {
		this.vtCot = vtCot;
	}
	public int getVtDong() {
		return vtDong;
	}
	public void setVtDong(int vtDong) {
		this.vtDong = vtDong;
	}
	public boolean getDaDanh() {
		return daDanh;
	}
	public void setDaDanh(boolean daDanh) {
		this.daDanh = daDanh;
	}
	public int getoCo() {
		return oCo;
	}
	public void setoCo(int oCo) {
		this.oCo = oCo;
	}
	
}
