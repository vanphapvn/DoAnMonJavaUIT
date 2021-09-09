package JaVaProjectGameCaro.ServerAndClient;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.LoaiXepHangDAO;
import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;
import JaVaProjectGameCaro.XuLi.AIComputerCaro;
import JaVaProjectGameCaro.XuLi.AddPictureToJpanel;
import JaVaProjectGameCaro.XuLi.CheckThangThua;
import JaVaProjectGameCaro.XuLi.DemGio;
import JaVaProjectGameCaro.XuLi.Oco;
import JaVaProjectGameCaro.XuLi.Player;
import JaVaProjectGameCaro.XuLi.Vars;

public class QuanLiPlayGameUIClient {
	private JPanel pnBanCo;
	private JButton btnDauHang;
	private JButton btnGuiTinNhan;
	private JLabel lblDemNguoc;
	private JLabel lblUsername;
	private JTextField txtfTinNhan;
	private JTextArea txtTinNhanHienThi;
	private JPanel pnTime;
	
	private JLabel pnXepHang;
	private JPanel pnImageQuanCo;
	
	private ArrayList<Player> player;
	private  int PlayerNow;
	private DemGio countDown;
	private ArrayList<ArrayList<Oco>> banCo;
	private CheckThangThua endGame;
	Player playerTemp;
	private JFrame jfPlayNow;
	private JFrame jfMenuNow;


	
	private Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Thread startClient;
	private Thread demgio;
	
	private String tenDangNhapServer;
	private String tenHienThiServer;
	private int idXepHangServer;
	
	private String tenDangNhapClient;
	private String tenHienThiClient;
	private int idXepHangClient;
	
	private int countdown=31;
	
	public QuanLiPlayGameUIClient(JPanel pnBanCo,JLabel lblDemNguoc,JTextField txtfTinNhan, JButton btnDauHang,
			JTextArea txtTinNhanHienThi,JButton btnGuiTinNhan,JLabel lblUsername,String tenDangNhap,String tenHienThi,int idXepHang,JFrame jfMenuNow,
			JFrame jfPlayNow,JLabel pnXepHang,JPanel pnImageQuanCo) throws IOException {
		this.pnBanCo=pnBanCo;
		this.btnDauHang=btnDauHang;
		this.btnGuiTinNhan=btnGuiTinNhan;
		this.lblDemNguoc=lblDemNguoc;
		this.lblUsername=lblUsername;
		this.txtfTinNhan=txtfTinNhan;
		this.txtTinNhanHienThi=txtTinNhanHienThi;
		this.pnTime=pnTime;
		
		this.pnXepHang=pnXepHang; 
		this.pnImageQuanCo=pnImageQuanCo;
	
		this.tenDangNhapClient=tenDangNhap;
		this.tenHienThiClient=tenHienThi;
		this.lblUsername.setText(tenHienThi);
		this.idXepHangClient=idXepHang;
		
		this.jfMenuNow=jfMenuNow;
		this.jfPlayNow=jfPlayNow;
		this.pnBanCo.setLayout(new GridLayout(Vars.CHESSBROARD_HEIGHT, Vars.CHESSBOARD_WIDTH, 0, 0));
		VeBanCo();
		this.countDown=new DemGio(lblDemNguoc,playerTemp,jfPlayNow,jfMenuNow);
		quanLiPlayer();
		endGame=new CheckThangThua(banCo);
		addEvents();
		createClient();
	}
	
	private void demGio() {
		class DemGio extends Thread{
			public void run() {
		        while(countdown>=0) {
		        	countdown--;
		        	
		        	try {
		        		String demNguoc=String.valueOf(countdown);
		        		if(countdown>9) {
		        			lblDemNguoc.setText(demNguoc);
		        		}else {
		        			lblDemNguoc.setText("0"+demNguoc);
		        		}
		        		Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
		        	if(countdown==0) {
		        		try {
		        			PlayerNow=-1;
							socket.close();
							oos.close();
							ois.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						startClient.stop();
						if(PlayerNow==1) {
							JOptionPane.showMessageDialog(null,tenHienThiClient + " đã bị xử thua do hết giờ ! "+xuLiThua());
						}else {
							JOptionPane.showMessageDialog(null,tenHienThiServer + " đã bị xử thua do hết giờ ! "+xuLiThang());
						}
		        	    
		        		jfMenuNow.setVisible(true);
		    			jfPlayNow.dispose();
							// TODO Auto-generated catch block
							
			
		        	}
		        }
		    }
			
		}
		
		demgio=new DemGio();
		demgio.start();
	}
	
	public void createClient() throws IOException {
    	class listen extends Thread{
    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			listenServer();
    		}
    	}
    	startClient= new listen();
    	startClient.start();
  
    }
	public void listenServer() {
    	try {
			socket=new Socket("localhost",Vars.PORT);
			OutputStream os=socket.getOutputStream();
			oos=new ObjectOutputStream(os);
			InputStream is=socket.getInputStream();
			ois = new ObjectInputStream(is);
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.exit(0);
			e.printStackTrace();
		}
    	//this.countDown.start();
    	demGio();
    	
    	try {
    		Vector sendServer=new Vector();
    		sendServer.add(tenDangNhapClient);
    		sendServer.add(tenHienThiClient);
    		sendServer.add(idXepHangClient);
			oos.writeObject(sendServer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	while(true) {
    		try {
    			Vector str=null;
				try {
					str=(Vector) ois.readObject();
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(str.size()==3) {
					tenDangNhapServer=(String) str.get(0);
					tenHienThiServer=(String) str.get(1);
					idXepHangServer=(Integer) str.get(2); 
					this.player.get(0).setuserName(tenHienThiServer);
					this.player.get(0).setImgXepHang(getImageIDXepHang(idXepHangServer));
					countDown.setPlayerNow(player.get(0));
					pnXepHang.setIcon(getImageIDXepHang(idXepHangServer));
			
					pnImageQuanCo.repaint();
					pnImageQuanCo.removeAll();
					pnImageQuanCo.add(player.get(0).getImgQuanCo());
				
					this.lblUsername.setText(tenHienThiServer);
	
				}
				if(str.size()==2) {
					//countDown.setCountDown(31); 
					countdown=31;
					banCo.get((Integer) str.get(0)).get((Integer) str.get(1)).setDaDanh(true);
					banCo.get((Integer) str.get(0)).get((Integer) str.get(1)).setIcon(player.get(0).getImageKhung());
					banCo.get((Integer) str.get(0)).get((Integer) str.get(1)).setoCo(0);
					if(endGame.checkHoa()==true) {
						//countDown.stop();
						demgio.stop();
						PlayerNow=-1;
						JOptionPane.showMessageDialog(null, "Hai bạn đã hòa nhau "+ tenHienThiClient);
						
				
						
						jfMenuNow.setVisible(true);
						jfPlayNow.dispose();
						
						startClient.stop();
						socket.close();
						oos.close();
						ois.close();
						
						return;
					}
					if(endGame.endGame(banCo.get((Integer) str.get(0)).get((Integer) str.get(1)))==true) {
						//countDown.stop();
						demgio.stop();
						PlayerNow=-1;
						JOptionPane.showMessageDialog(null, "Bạn đã thua "+ tenHienThiServer+" "+xuLiThua());
						
												
						jfMenuNow.setVisible(true);
						jfPlayNow.dispose();
						
						startClient.stop();
						socket.close();
						oos.close();
						ois.close();
						
						return;
					}
					PlayerNow=1;
					
					countDown.setPlayerNow(player.get(PlayerNow));
					lblUsername.setText(tenHienThiClient);
					
					pnImageQuanCo.repaint();
					pnImageQuanCo.removeAll();
					pnImageQuanCo.add(player.get(PlayerNow).getImgQuanCo());
					pnXepHang.setIcon(getImageIDXepHang(idXepHangClient));
				}
				
				if(str.size()==1) {
					txtTinNhanHienThi.setText(txtTinNhanHienThi.getText() + tenHienThiServer+ ": " + str.get(0).toString() + "\n");
				}
				
				if(str.size()==4) {
					demgio.stop();
					JOptionPane.showMessageDialog(null,tenHienThiServer +" Đã đầu hàng "+ xuLiThang());
					
					
					jfMenuNow.setVisible(true);
					jfPlayNow.dispose();
					try {
						socket.close();
						oos.close();
						ois.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				//JOptionPane.showMessageDialog(null, "Client Ngat Ket Noi Dot Ngot !");
			}
    	}
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
						
						if(btnOCo.getDaDanh()==true) {
							return; 
						}
						
						if(PlayerNow==0) {
							JOptionPane.showMessageDialog(null, "Chưa đến lượt của bạn !");
							return;
						}
						
						
						//countDown.setCountDown(31); 
						countdown=31;
					
						btnOCo.setIcon(player.get(1).getImageKhung());
						btnOCo.setDaDanh(true);
						btnOCo.setoCo(1);
					
						
				
						
						Vector str=new Vector();
						str.add(btnOCo.getVtDong());
						str.add(btnOCo.getVtCot());
						
						try {
							oos.writeObject(str);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//JOptionPane.showMessageDialog(null, "Client Ngắt Kết Nối Rồi !");
							//e1.printStackTrace();
						}
						
						if(endGame.checkHoa()==true) {
							//countDown.stop();
							demgio.stop();
							JOptionPane.showMessageDialog(null, "Hai bạn đã hòa nhau !");
							
							jfMenuNow.setVisible(true);
							jfPlayNow.dispose();
							
					
							startClient.stop();
							try {
								socket.close();
								oos.close();
								ois.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
							return;
						}
						
						if(endGame.endGame(btnOCo)==true) {
							//countDown.stop();
							demgio.stop();
							PlayerNow=-1;
							JOptionPane.showMessageDialog(null, "Bạn đã chiến thắng "+ tenHienThiServer+" "+xuLiThang());
							
							jfMenuNow.setVisible(true);
							jfPlayNow.dispose();
							
							startClient.stop();
							try {
								socket.close();
								oos.close();
								ois.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							return;
						}
					
						PlayerNow=0;
						countDown.setPlayerNow(player.get(0));
						lblUsername.setText(tenHienThiServer);
						pnImageQuanCo.repaint();
						pnImageQuanCo.removeAll();
						pnImageQuanCo.add(player.get(PlayerNow).getImgQuanCo());
						
					
						pnXepHang.setIcon(player.get(PlayerNow).getImgXepHang());
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
	
	private String xuLiThang() {
		
		NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(tenDangNhapClient);
		LoaiXepHang xh=nc.getLoaiXepHang();
		nc.setSoLanThang(nc.getSoLanThang()+1);
		if(xh.getIdXepHang()==1) {
			nc.setDiemXepHang(nc.getDiemXepHang()+xh.getDiemCongThang());
		}else {
			nc.setDiemXepHang(nc.getDiemXepHang()+xh.getDiemCongThang());
			LoaiXepHang xhSoSanh=LoaiXepHangDAO.getLoaiXepHang(xh.getIdXepHang()-1);
			if(nc.getDiemXepHang()>xhSoSanh.getDiemTu()) {
				nc.setLoaiXepHang(xhSoSanh);
			}
		}
		NguoiChoiDAO.suaNguoiChoi(nc);
		return "Bạn được cộng "+xh.getDiemCongThang()+" điểm vào điểm xếp hạng ";
	}
	private String xuLiThua() {
		
		NguoiChoi nc=NguoiChoiDAO.getNguoiChoi(tenDangNhapClient);
		LoaiXepHang xh=nc.getLoaiXepHang();
		nc.setSoLanThua(nc.getSoLanThua()+1);
		nc.setDiemXepHang(nc.getDiemXepHang()-xh.getDiemTruThua());
		LoaiXepHang xhSoSanh=LoaiXepHangDAO.getLoaiXepHang(xh.getIdXepHang()+1);
		if(nc.getDiemXepHang()<xh.getDiemTu()) {
			nc.setLoaiXepHang(xhSoSanh);
		}
		NguoiChoiDAO.suaNguoiChoi(nc);
		return "Bạn bị trừ "+xh.getDiemTruThua()+" điểm vào điểm xếp hạng ";
	}
	
	public ImageIcon getImageIDXepHang(int idXepHang) throws IOException {
		if(idXepHang==1) {
        	return new ImageIcon(getClass().getResource("Image/caothu.png"));
        }
        
        if(idXepHang==2) {
        	return new ImageIcon(getClass().getResource("Image/kimcuong.png"));
        }
        if(idXepHang==3) {
        	return new ImageIcon(getClass().getResource("Image/bachkim.png"));
        }
        if(idXepHang==4) {
        	return new ImageIcon(getClass().getResource("Image/vang.png"));
        }
        if(idXepHang==5) {
        	return new ImageIcon(getClass().getResource("Image/bac.png"));
        }
        if(idXepHang==6) {
        	return new ImageIcon(getClass().getResource("Image/dong.png"));
        }
		return null;
	}
	
	public void quanLiPlayer() throws IOException {
		
		this.player=new ArrayList<Player>();		
		this.player.add(new Player(null, new ImageIcon(getClass().getResource("Image/khung1.png")), new AddPictureToJpanel("Image/QuanCoX.png", 0, 0, 30, 30), null));
		this.player.add(new Player(tenHienThiClient, new ImageIcon(getClass().getResource("Image/khung2.png")), new AddPictureToJpanel("Image/QuanCoO.png", 0, 0, 30, 30), getImageIDXepHang(idXepHangClient)));
		PlayerNow=0;
		this.lblUsername.setText(tenHienThiClient);
		this.pnImageQuanCo.add(player.get(1).getImgQuanCo());
		//this.pnXepHang.add(player.get(1).getImgXepHang());
	}
	
	public void addEvents() {
		this.btnGuiTinNhan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtfTinNhan.getText().isEmpty()) {
					return;
				}
				try {
					Vector str=new Vector();
					str.add(txtfTinNhan.getText());
					oos.writeObject(str);
					txtTinNhanHienThi.setText(txtTinNhanHienThi.getText() + tenHienThiClient+ ": " + str.get(0).toString() + "\n");
					txtfTinNhan.setText(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.txtfTinNhan.addMouseListener(new MouseListener() {
			
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
				txtfTinNhan.setText(null);
			}
		});
		
		this.txtfTinNhan.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					if(txtfTinNhan.getText().isEmpty()) {
						return;
					}
					try {
						Vector str=new Vector();
						str.add(txtfTinNhan.getText());
						oos.writeObject(str);
						txtTinNhanHienThi.setText(txtTinNhanHienThi.getText() + tenHienThiClient+ ": " + str.get(0).toString() + "\n");
						txtfTinNhan.setText(null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		this.btnDauHang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				demgio.stop();
				JOptionPane.showMessageDialog(null, "Bạn đã đầu hàng "+ tenHienThiServer+" "+xuLiThua());
				try {
					Vector str=new Vector();
					str.add(1);
					str.add(1);
					str.add(1);
					str.add(1);
					oos.writeObject(str);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				jfMenuNow.setVisible(true);
				jfPlayNow.dispose();
				
				startClient.stop();
				try {
					socket.close();
					oos.close();
					ois.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}

