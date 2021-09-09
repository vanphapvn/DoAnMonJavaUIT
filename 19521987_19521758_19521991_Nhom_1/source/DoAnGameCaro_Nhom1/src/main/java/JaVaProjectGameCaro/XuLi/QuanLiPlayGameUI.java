package JaVaProjectGameCaro.XuLi;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class QuanLiPlayGameUI {
	private JPanel pnBanCo;
	private JButton btnDauHang;
	private JLabel lblDemNguoc;
	private JPanel pnTime;
	
	private JPanel pnImageQuanCo;
	private JLabel lblUsername;
	
	private ArrayList<Player> player;
	private  int PlayerNow;
	private DemGio countDown;
	private ArrayList<ArrayList<Oco>> banCo;
	private CheckThangThua endGame;
	private AIComputerCaro AI;
	private LuaChon lc;
	
	private JFrame jfPlayNow;
	private JFrame jfMenuNow;
	
	private Player playerPC;
	
	public QuanLiPlayGameUI(JPanel pnBanCo,JLabel lblDemNguoc, JButton btnDauHang,JLabel lblUsername,JPanel pnImageQuanCo,JFrame jfMenuNow,JFrame jfPlayNow, LuaChon lc) throws IOException {
		this.pnBanCo=pnBanCo;
		this.btnDauHang=btnDauHang;
		this.lblDemNguoc=lblDemNguoc;
		this.pnTime=pnTime;
		this.lc=lc;
		this.jfMenuNow=jfMenuNow;
		this.jfPlayNow=jfPlayNow;
		this.lblUsername=lblUsername;
		this.pnImageQuanCo=pnImageQuanCo;
		playerPC=new Player("Người chơi", null, null, null);
		this.pnBanCo.setLayout(new GridLayout(Vars.CHESSBROARD_HEIGHT, Vars.CHESSBOARD_WIDTH, 0, 0));
		VeBanCo();
		this.countDown=new DemGio(lblDemNguoc,playerPC,jfPlayNow,jfMenuNow);
		this.countDown.start();
		endGame=new CheckThangThua(banCo);
		addEvents();
		AI=new AIComputerCaro(banCo);
	}
	public void quanLiPlayer() throws IOException {
		
		this.player=new ArrayList<Player>();		
		this.player.add(new Player("Người Chơi 1", new ImageIcon(getClass().getResource("Image/khung1.png")),new AddPictureToJpanel("Image/QuanCoX.png", 0, 0, 30, 30), null));
		this.player.add(new Player("Người Chơi 2", new ImageIcon(getClass().getResource("Image/khung2.png")), new AddPictureToJpanel("Image/QuanCoO.png", 0, 0, 30, 30), null));
		PlayerNow=0;
		this.lblUsername.setText(player.get(0).getuserName());
		this.pnImageQuanCo.add(player.get(0).getImgQuanCo());
		countDown.setPlayerNow(this.player.get(0));
	}
	
	public void addEvents() {
		
		this.btnDauHang.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDauHang.setBackground(new java.awt.Color(255,255,255));
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDauHang.setBackground(new java.awt.Color(0,153,255));
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void VeBanCo() {
		
		banCo=new ArrayList<ArrayList<Oco>>();
		for(int i=0;i<Vars.CHESSBROARD_HEIGHT;i++) {
			banCo.add(new ArrayList<Oco>());
			for(int j=0;j<Vars.CHESSBOARD_WIDTH;j++) {
				final Oco btnOCo=new Oco(j,i,false);
				btnOCo.setoCo(-1);
				btnOCo.setBackground(new java.awt.Color(112,196,232));
				Border br = BorderFactory.createLineBorder(new java.awt.Color(112,196,232));
				btnOCo.setBorder(br);
				btnOCo.setIcon(new ImageIcon(getClass().getResource("Image/khung.png")));
				
				
				banCo.get(i).add(btnOCo);
				btnOCo.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						if(lc == LuaChon.PLAYWITHCOMPUTER) {
							playWithComputer(btnOCo);
							return;
						}
						
						if(lc==LuaChon.TWOPLAYER) {
							twoPlayer(btnOCo);
							return;
						}
						
					}
				});
				
			
				
				btnOCo.addMouseListener(new MouseListener() {
						
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
							
					}
						
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
							
					}
						
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						btnOCo.setBackground(new java.awt.Color(112,196,232));
					}
					
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						if(btnOCo.getDaDanh()==false) {
							if(PlayerNow==1) {
								btnOCo.setBackground(Color.red);
							}else btnOCo.setBackground(new java.awt.Color(0,51,247));
						}
					}
						
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
							
					}
				});
				
				this.pnBanCo.add(btnOCo);
				
				
			}
		}
	}
	
	private void twoPlayer(Oco btnOCo) {
		if(btnOCo.getDaDanh()==true) {
			return; 
		}
		
		countDown.setCountDown(31); 
		btnOCo.setIcon(player.get(PlayerNow).getImageKhung());
		btnOCo.setDaDanh(true);
		btnOCo.setoCo(PlayerNow);
		
		if(endGame.checkHoa()==true) {
			countDown.stop();
			JOptionPane.showMessageDialog(null, "Hai bạn hòa nhau !");
			jfMenuNow.setVisible(true);
			jfPlayNow.dispose();
			return;
		}
		
		if(endGame.endGame(btnOCo)==true) {
			countDown.stop();
			if(PlayerNow==1) {
				JOptionPane.showMessageDialog(null, "Chúc mừng người chơi 2 đã chiến thắng !");
				jfMenuNow.setVisible(true);
				jfPlayNow.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Chúc mừng người chơi 1 đã chiến thắng");
				jfMenuNow.setVisible(true);
				jfPlayNow.dispose();
			}
			return;
		}
		
		if(PlayerNow==1) {
			PlayerNow=0;
		}else PlayerNow=1;
		
		this.pnImageQuanCo.repaint();
		this.pnImageQuanCo.removeAll();
		countDown.setPlayerNow(this.player.get(PlayerNow));
		this.pnImageQuanCo.add(player.get(PlayerNow).getImgQuanCo());
		this.lblUsername.setText(player.get(PlayerNow).getuserName());
		
	}
	
	private void playWithComputer(Oco btnOCo) {
		
		
		
		if(btnOCo.getDaDanh()==true) {
			return; 
		}
		
		countDown.setCountDown(31); 
		btnOCo.setIcon(new ImageIcon(getClass().getResource("Image/khung1.png")));
		btnOCo.setDaDanh(true);
		btnOCo.setoCo(0);
		
		if(endGame.checkHoa()==true) {
			JOptionPane.showMessageDialog(null, "Hai bên hòa nhau !");
			jfMenuNow.setVisible(true);
			jfPlayNow.dispose();
			return;
		}
		
		if(endGame.endGame(btnOCo)==true) {
			countDown.stop();
			JOptionPane.showMessageDialog(null, "Chúc mừng bạn đã chiến thắng !");
			jfMenuNow.setVisible(true);
			jfPlayNow.dispose();
			return;
		}
		
		AI.StartCom();
		
		if(AI.kiemTraComWin()==true) {
			countDown.stop();
			JOptionPane.showMessageDialog(null, "Máy đã thắng bạn !");
			jfMenuNow.setVisible(true);
			jfPlayNow.dispose();
			return;
		}

	}
}
