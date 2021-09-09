package JaVaProjectGameCaro.XuLi;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AIComputerCaro {
	
	private ArrayList<ArrayList<Oco>> banCo;
	private Oco btnOCo;
	private CheckThangThua endGame;
	//private long diemMax1=0;
	//private long diemMax2=0;
	//private final long[] mangDiemPhongThu = {0, 64, 4096, 262144, 16777216, 1073741824 };
	//private final long[] mangDiemTanCong= { 0, 8, 512, 32768, 2097152, 134217728 };
	
	private long[] mangDiemPhongThu = { 0, 8, 512, 32768, 2097152, 134217728 }; // Mảng điểm phòng thủ
	private long[] mangDiemTanCong= {0, 64, 4096, 262144, 16777216, 1073741824 }; //Mảng điểm tấn công
	
	public AIComputerCaro(ArrayList<ArrayList<Oco>> banCo) {
		this.banCo=banCo;
		endGame=new CheckThangThua(banCo);
	}
	
	public void doiMangDiem() {
		for(int i=0;i<6;i++) {
			long temp;
			temp=mangDiemPhongThu[i];
			mangDiemPhongThu[i]=mangDiemTanCong[i];
			mangDiemTanCong[i]=temp;
		}
	}
	
	public boolean kiemTraComWin() {
		if(endGame.endGame(btnOCo)==true) {
			return true;
		}
		return false;
	}
	public boolean kiemTraComHoa() {
		if(endGame.checkHoa()==true) {
			return true;
		}
		return false;
	}
	public void StartCom() {
		
		Point point=timKiemNuocDi();
		
		banCo.get(point.x).get(point.y).setoCo(1);
		banCo.get(point.x).get(point.y).setDaDanh(true);
		banCo.get(point.x).get(point.y).setIcon(new ImageIcon(getClass().getResource("Image/khung2.png")));
		
		btnOCo=banCo.get(point.x).get(point.y);
	}
	
	public Point timKiemNuocDi() {
		long diemMax=0;
		Point chessPoint=new Point();
		
		for(int i=0;i<Vars.CHESSBROARD_HEIGHT;i++) {
			for(int j=0;j<Vars.CHESSBOARD_WIDTH;j++) {
				if(banCo.get(i).get(j).getoCo()==-1) {
					long diemTanCong=diemTanCong_DuyetCot(i, j)+diemTanCong_DuyetDong(i, j)+diemTanCong_DuyetCheoChinh(i, j)+diemTanCong_DuyetCheoPhu(i, j);
					long diemPhongNgu=diemPhongNgu_DuyetCot(i, j)+diemPhongNgu_DuyetDong(i, j)+diemPhongNgu_DuyetCheoChinh(i, j)+diemPhongNgu_DuyetCheoPhu(i, j);
					long diemTemp=0;
					if(diemTanCong>diemPhongNgu) {
						diemTemp=diemTanCong;
					}else diemTemp=diemPhongNgu;
					long diemTong=0;
					if(diemTanCong+diemPhongNgu>diemTemp) {
						diemTong=diemTanCong+diemPhongNgu;
					}else diemTong=diemTemp;
					
					if(diemMax<diemTong) {
						diemMax=diemTong;
						chessPoint=new Point(i,j);
					}
				}
			}
		}
		return chessPoint;
	}
	
	private long diemPhongNgu_DuyetCot(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && i+dong<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && j+dong<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(j+dong).get(cot).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		
		if(soQuanDich>=soQuanDich2) {
			diemTong -=1;
		}else diemTong-=2;
		
		if(soQuanDich==4) {
			diemTong *=2;
		}
		
		return diemTong;

	}
	
	private long diemPhongNgu_DuyetDong(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH;i++) 
		{
			if(banCo.get(dong).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH;j++) 
					{
						if(banCo.get(dong).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot-i>=0;i++) 
		{
			if(banCo.get(dong).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0;j++) 
					{
						if(banCo.get(dong).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		
		if(soQuanDich>=soQuanDich2) {
			diemTong -=1;
		}else diemTong-=2;
		
		if(soQuanDich==4) {
			diemTong *=2;
		}
		
		return diemTong;
	}
	
	private long diemPhongNgu_DuyetCheoChinh(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot-i>=0 && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0 && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH && dong+i<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH && dong+j<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong+j).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		
		if(soQuanDich>=soQuanDich2) {
			diemTong -=1;
		}else diemTong-=2;
		
		if(soQuanDich==4) {
			diemTong *=2;
		}
		
		return diemTong;
	}
	
	private long diemPhongNgu_DuyetCheoPhu(int dong, int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot-i>=0 && dong+i<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
				break;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0 && dong+j<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
							break;
						}
						else 
						{
							if(banCo.get(dong+j).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		
		if(soQuanDich>=soQuanDich2) {
			diemTong -=1;
		}else diemTong-=2;
		
		if(soQuanDich==4) {
			diemTong *=2;
		}
		
		return diemTong;
	}

	
	
	private long diemTanCong_DuyetCot(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && i+dong<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && j+dong<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(j+dong).get(cot).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanDich==0) {
			diemTong +=mangDiemTanCong[soQuanTa]*2;
		}else diemTong +=mangDiemTanCong[soQuanTa];
		
		if(soQuanDich2==0) {
			diemTong +=mangDiemTanCong[soQuanTa2]*2;
		}else diemTong += mangDiemTanCong[soQuanTa2];
		
		if(soQuanTa>=soQuanTa2) {
			diemTong -= 1;
		}else diemTong -=2;
		
		if(soQuanTa==4) {
			diemTong *=2;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		if(soQuanTa2==0) {
			diemTong += mangDiemPhongThu[soQuanDich2]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich2];
		
		return diemTong;
	}
	
	private long diemTanCong_DuyetDong(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH;i++) 
		{
			if(banCo.get(dong).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH;j++) 
					{
						if(banCo.get(dong).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot-i>=0;i++) 
		{
			if(banCo.get(dong).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0;j++) 
					{
						if(banCo.get(dong).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanDich==0) {
			diemTong +=mangDiemTanCong[soQuanTa]*2;
		}else diemTong +=mangDiemTanCong[soQuanTa];
		
		if(soQuanDich2==0) {
			diemTong +=mangDiemTanCong[soQuanTa2]*2;
		}else diemTong += mangDiemTanCong[soQuanTa2];
		
		if(soQuanTa>=soQuanTa2) {
			diemTong -= 1;
		}else diemTong -=2;
		
		if(soQuanTa==4) {
			diemTong *=2;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		if(soQuanTa2==0) {
			diemTong += mangDiemPhongThu[soQuanDich2]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich2];
		
		return diemTong;
	}
	
	private long diemTanCong_DuyetCheoChinh(int dong,int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot-i>=0 && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0 && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH && dong+i<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH && dong+j<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong+j).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanDich==0) {
			diemTong +=mangDiemTanCong[soQuanTa]*2;
		}else diemTong +=mangDiemTanCong[soQuanTa];
		
		if(soQuanDich2==0) {
			diemTong +=mangDiemTanCong[soQuanTa2]*2;
		}else diemTong += mangDiemTanCong[soQuanTa2];
		
		if(soQuanTa>=soQuanTa2) {
			diemTong -= 1;
		}else diemTong -=2;
		
		if(soQuanTa==4) {
			diemTong *=2;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		if(soQuanTa2==0) {
			diemTong += mangDiemPhongThu[soQuanDich2]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich2];
		
		return diemTong;
	}
	
	private long diemTanCong_DuyetCheoPhu(int dong, int cot) {
		long diemTong=0; 
		int soQuanTa=0;
		int soQuanDich=0;
		int soQuanTa2=0;
		int soQuanDich2=0;
		
		for(int i=1;i<6 && cot+i<Vars.CHESSBOARD_WIDTH && dong-i>=0;i++) 
		{
			if(banCo.get(dong-i).get(cot+i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong-i).get(cot+i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot+j<Vars.CHESSBOARD_WIDTH && dong-j>=0;j++) 
					{
						if(banCo.get(dong-j).get(cot+j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong-j).get(cot+j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		
		for(int i=1;i<6 && cot-i>=0 && dong+i<Vars.CHESSBROARD_HEIGHT;i++) 
		{
			if(banCo.get(dong+i).get(cot-i).getoCo()==1) 
			{
				soQuanTa++;
			}
			else 
			{
				if(banCo.get(dong+i).get(cot-i).getoCo()==0) 
				{
					soQuanDich++;
					break;
				}
				else 
				{
					for(int j=2;j<6 && cot-j>=0 && dong+j<Vars.CHESSBROARD_HEIGHT;j++) 
					{
						if(banCo.get(dong+j).get(cot-j).getoCo()==1) 
						{
							soQuanTa2++;
						}
						else 
						{
							if(banCo.get(dong+j).get(cot-j).getoCo()==0)
							{
								soQuanDich2++;
								break;
							}
							else break;
						}
					}
					break;
				}		
			}
		}
		if(soQuanTa==2) {
			return 0;
		}
		
		if(soQuanDich==0) {
			diemTong +=mangDiemTanCong[soQuanTa]*2;
		}else diemTong +=mangDiemTanCong[soQuanTa];
		
		if(soQuanDich2==0) {
			diemTong +=mangDiemTanCong[soQuanTa2]*2;
		}else diemTong += mangDiemTanCong[soQuanTa2];
		
		if(soQuanTa>=soQuanTa2) {
			diemTong -= 1;
		}else diemTong -=2;
		
		if(soQuanTa==4) {
			diemTong *=2;
		}
		
		if(soQuanTa==0) {
			diemTong += mangDiemPhongThu[soQuanDich]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich];
		
		if(soQuanTa2==0) {
			diemTong += mangDiemPhongThu[soQuanDich2]*2;
		}else diemTong += mangDiemPhongThu[soQuanDich2];
		
		return diemTong;
	}
	
}
