package JaVaProjectGameCaro.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;
import JaVaProjectGameCaro.XuLi.AddPictureToJpanel;
import JaVaProjectGameCaro.XuLi.LuaChon;
import JaVaProjectGameCaro.XuLi.QuanLiMenuPlayUI;
import JaVaProjectGameCaro.XuLi.Vars;

public class MenuPlayUI extends javax.swing.JFrame {
	
	private javax.swing.JButton btnBXH;
    private javax.swing.JButton btnChoiHaiNguoi;
    private javax.swing.JButton btnChoiOnline;
    private javax.swing.JButton btnChoiVoiMay;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongTinPM;
    private javax.swing.JLabel lblTenXepHang;
    private javax.swing.JLabel lblTenHienThi;
    private javax.swing.JLabel lblXepHang;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnThongTinNguoiChoi;
    private javax.swing.JPanel pnLogoXepHang;
    
    private  String tenDangNhap;
    private  int idXepHang;
    private String tenHienThi;
    private int thuTuXH;
    private LuaChon lc;
    
    public MenuPlayUI(String tenDangNhap,String tenHienThi,String tenXepHang,int thuTuXepHang, int idXepHang,LuaChon lc) throws IOException {
    	run();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.idXepHang=idXepHang;
        this.lblTenHienThi.setText(tenDangNhap);
        this.lblTenXepHang.setText("Rank: "+tenXepHang);
        this.lblXepHang.setText("Xếp hang: "+thuTuXepHang);
        this.thuTuXH=thuTuXepHang;
        this.tenDangNhap=tenDangNhap;
        this.tenHienThi=tenHienThi;
        this.lc=lc;
        addPicture();
        XuLiLoaiChoi(); 
    }
    
    
    
    private void XuLiLoaiChoi() {
    	if(lc==LuaChon.PLAYONLINE) {
    		new QuanLiMenuPlayUI(btnBXH, btnChoiHaiNguoi, btnChoiOnline, btnChoiVoiMay, btnDoiMatKhau, btnHuongDan, btnThoat, btnThongTinPM,tenDangNhap,tenHienThi,idXepHang,thuTuXH,this);
    		return;
    	}
    	
    	if(lc==LuaChon.PLAYOFFLINE) {
    		this.btnChoiOnline.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "Bạn Cần Đăng Nhập Để Thực Hiện Hành Động Này !");
				}
			});
    		
    		this.btnDoiMatKhau.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "Bạn Cần Đăng Nhập Để Thực Hiện Hành Động Này !");
				}
			});
    		
    		this.btnBXH.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "Bạn Cần Đăng Nhập Để Thực Hiện Hành Động Này !");
				}
			});
    		new QuanLiMenuPlayUI(btnChoiHaiNguoi, btnChoiVoiMay, btnHuongDan, btnThoat, btnThongTinPM,this);
    		return;
    		
    	}
    
    }
    
    
    private void addPicture() throws IOException {
    	
    	this.setTitle("GAMECARO");
    	
        AddPictureToJpanel backg=new AddPictureToJpanel("Image/backg.png", 0, 0, 900, 600);
        this.pnMain.add(backg);
        
        if(idXepHang==1) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/caothu.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
        
        if(idXepHang==2) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/kimcuong.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
        if(idXepHang==3) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/bachkim.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
        if(idXepHang==4) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/vang.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
        if(idXepHang==5) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/bac.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
        if(idXepHang==6) {
        	AddPictureToJpanel logoXepHang=new AddPictureToJpanel("Image/dong.png", 0, 0, 36, 36);
        	this.pnLogoXepHang.add(logoXepHang);
        }
    }


    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        btnChoiVoiMay = new javax.swing.JButton();
        btnChoiHaiNguoi = new javax.swing.JButton();
        btnChoiOnline = new javax.swing.JButton();
        btnHuongDan = new javax.swing.JButton();
        btnBXH = new javax.swing.JButton();
        btnThongTinPM = new javax.swing.JButton();
        pnThongTinNguoiChoi = new javax.swing.JPanel();
        lblTenHienThi = new javax.swing.JLabel();
        lblTenXepHang = new javax.swing.JLabel();
        lblXepHang = new javax.swing.JLabel();
        btnDoiMatKhau = new javax.swing.JButton();
        pnLogoXepHang = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));

        pnMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        btnThoat.setBackground(new java.awt.Color(0, 255, 102));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");

        btnChoiVoiMay.setBackground(new java.awt.Color(0, 153, 255));
        btnChoiVoiMay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChoiVoiMay.setForeground(new java.awt.Color(255, 255, 255));
        btnChoiVoiMay.setText("Chơi với máy");
        btnChoiHaiNguoi.setBackground(new java.awt.Color(0, 153, 255));
        btnChoiHaiNguoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChoiHaiNguoi.setForeground(new java.awt.Color(255, 255, 255));
        btnChoiHaiNguoi.setText("Chơi hai người");

        btnChoiOnline.setBackground(new java.awt.Color(0, 153, 255));
        btnChoiOnline.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChoiOnline.setForeground(new java.awt.Color(255, 255, 255));
        btnChoiOnline.setText("Chơi online");

        btnHuongDan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setToolTipText("");
        btnBXH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBXH.setText("Bảng xếp hạng");
        btnBXH.setToolTipText("");
        btnThongTinPM.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThongTinPM.setText("Thông tin phần mềm");
        btnThongTinPM.setToolTipText("");
        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBXH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuongDan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoiOnline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoiHaiNguoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChoiVoiMay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongTinPM, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnChoiVoiMay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChoiHaiNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChoiOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBXH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongTinPM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnThongTinNguoiChoi.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinNguoiChoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        lblTenHienThi.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTenHienThi.setText("");

        lblTenXepHang.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTenXepHang.setText(":");

        lblXepHang.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblXepHang.setText("");

        btnDoiMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");

        pnLogoXepHang.setBackground(new java.awt.Color(255, 255, 255));
        pnLogoXepHang.setPreferredSize(new java.awt.Dimension(36, 36));

        javax.swing.GroupLayout pnLogoXepHangLayout = new javax.swing.GroupLayout(pnLogoXepHang);
        pnLogoXepHang.setLayout(pnLogoXepHangLayout);
        pnLogoXepHangLayout.setHorizontalGroup(
            pnLogoXepHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        pnLogoXepHangLayout.setVerticalGroup(
            pnLogoXepHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnThongTinNguoiChoiLayout = new javax.swing.GroupLayout(pnThongTinNguoiChoi);
        pnThongTinNguoiChoi.setLayout(pnThongTinNguoiChoiLayout);
        pnThongTinNguoiChoiLayout.setHorizontalGroup(
            pnThongTinNguoiChoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinNguoiChoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                        .addComponent(lblTenHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                        .addComponent(lblTenXepHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnLogoXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnDoiMatKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblXepHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnThongTinNguoiChoiLayout.setVerticalGroup(
            pnThongTinNguoiChoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenHienThi)
                .addGroup(pnThongTinNguoiChoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblTenXepHang))
                    .addGroup(pnThongTinNguoiChoiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pnLogoXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblXepHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMatKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pnThongTinNguoiChoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(230, 230, 230))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnThongTinNguoiChoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//                    
    
    private void run() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPlayUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPlayUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPlayUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPlayUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

                 
}

