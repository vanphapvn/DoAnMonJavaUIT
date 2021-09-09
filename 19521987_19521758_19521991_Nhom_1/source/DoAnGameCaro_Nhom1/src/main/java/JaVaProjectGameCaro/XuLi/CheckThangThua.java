package JaVaProjectGameCaro.XuLi;

import java.util.ArrayList;

public class CheckThangThua {
	private ArrayList<ArrayList<Oco>> banCo;
	private int x;
	private int y;

	
	public CheckThangThua(ArrayList<ArrayList<Oco>> banCo) {
		
		this.banCo = banCo;
	}
	
	private void getToaDoOCo(Oco btnOCo ) {
		this.x=btnOCo.getVtDong();
		this.y=btnOCo.getVtCot();
	}
	
	public boolean checkHoa() {
		int soOCO=(Vars.CHESSBOARD_WIDTH-1)*(Vars.CHESSBROARD_HEIGHT-1);
		int temp=0;
		for(int i=0;i<Vars.CHESSBROARD_HEIGHT;i++) {
			for(int j=0;j<Vars.CHESSBOARD_WIDTH;j++) {
				if(banCo.get(i).get(j).getDaDanh()==true) {
					temp++;
				}
			}
		}
		if(temp==soOCO) {
			return true;
		}else return false;
	}
	
	public boolean endGame(Oco btnOCo ) {
		if(checkDong(btnOCo)==false&&checkCot(btnOCo)==false&&checkCheoChinh(btnOCo)==false&&checkCheoPhu(btnOCo)==false) {
			return false;
		}else return true;
	}
	
	private boolean checkDong(Oco btnOCo ) {
		getToaDoOCo(btnOCo);
		int valueDongTrai=0;
		int valueDongPhai=0;
		
		for(int i=y;i<Vars.CHESSBOARD_WIDTH;i++) {
			if(banCo.get(x).get(i).getoCo()==btnOCo.getoCo()) {
				valueDongPhai=valueDongPhai+1;
			}else {
				break;
			}
		}
		
		for(int i=y;i>=0;i--) {
			if(banCo.get(x).get(i).getoCo()==btnOCo.getoCo()) {
				valueDongTrai=valueDongTrai+1;
			}else {
				break;
			}
		}
		
		if(valueDongTrai+valueDongPhai>=6) {
			return true;
		}else return false;
	}
	
	private boolean checkCot(Oco btnOCo ) {
		getToaDoOCo(btnOCo);
		int cotTren=0;
		int cotDuoi=0;
		
		for(int i=x;i>=0;i--) {
			if(banCo.get(i).get(y).getoCo() == btnOCo.getoCo()) {
				cotTren=cotTren+1;
			}else {
				break;
			}
		}
		
		for(int i=x;i<Vars.CHESSBROARD_HEIGHT;i++) {
			if(banCo.get(i).get(y).getoCo() == btnOCo.getoCo()) {
				cotDuoi=cotDuoi+1;
			}else {
				break;
			}
		}
		
		
		if(cotTren+cotDuoi>=6) {
			return true;
		}else return false;
	}
	
	private boolean checkCheoChinh(Oco btnOCo ) {
		int cheoChinhTren=0;
		int cheoChinhDuoi=0;
		
		getToaDoOCo(btnOCo);
		int xT=x;
		int xD=x;
		
		for(int i=y;i>=0;i--) {
			
			
			if(xT!=0) {
			
				if(banCo.get(xT).get(i).getoCo() == btnOCo.getoCo()) {
					cheoChinhTren=cheoChinhTren+1;
				}else { 
					break; 
				}
				xT=xT-1;
			}else {
				if(banCo.get(xT).get(i).getoCo() == btnOCo.getoCo()) {
					cheoChinhTren=cheoChinhTren+1;
				}
				break;
			}
			
		}
		//int temp=Vars.CHESSBROARD_HEIGHT - xD;
		for(int i=y;i<Vars.CHESSBROARD_HEIGHT;i++) {
			if(xD != Vars.CHESSBROARD_HEIGHT-1) {
				if(banCo.get(xD).get(i).getoCo()==btnOCo.getoCo()) {
					cheoChinhDuoi=cheoChinhDuoi+1;
				}else {
					break;
				}
				xD=xD+1;
			}else {
				if(banCo.get(xD).get(i).getoCo() == btnOCo.getoCo()) {
					cheoChinhDuoi++;
				}

				break;
			}
		}
		
		//System.out.println(cheoChinhTren+","+cheoChinhDuoi+","+(cheoChinhDuoi+cheoChinhTren)+",");
		
		if(cheoChinhDuoi+cheoChinhTren>=6) {
			return true;
		}else return false;
	}
	
	private boolean checkCheoPhu(Oco btnOCo ) {
		int cheoPhuTren=0;
		int cheoPhuDuoi=0;
		
		getToaDoOCo(btnOCo);
		int xT=x;
		int xD=x;
		
		for(int i=y;i<Vars.CHESSBOARD_WIDTH;i++) {
			if(xT>=0) {
				if(banCo.get(xT).get(i).getoCo()==btnOCo.getoCo()) {
					cheoPhuTren++;
				}else {
					break;
				}
				xT--;
			}else break;
		}
		
		for(int i=y;i>=0;i--) {
			if(xD<Vars.CHESSBROARD_HEIGHT) {
				if(banCo.get(xD).get(i).getoCo()==btnOCo.getoCo()) {
					cheoPhuDuoi++;
				}else {
					break;
				}
				xD++;
			}else break;
		}
		
		
		if(cheoPhuTren+cheoPhuDuoi>=6) {
			return true;
		}else return false;
	}
}
