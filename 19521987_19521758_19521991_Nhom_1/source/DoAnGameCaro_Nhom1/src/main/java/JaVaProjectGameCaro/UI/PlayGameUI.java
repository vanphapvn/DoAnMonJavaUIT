package JaVaProjectGameCaro.UI;

import java.io.IOException;

import javax.swing.JFrame;

import JaVaProjectGameCaro.ServerAndClient.QuanLiPlayGameUIClient;
import JaVaProjectGameCaro.ServerAndClient.QuanLiPlayGameUIServer;
import JaVaProjectGameCaro.XuLi.AddPictureToJpanel;
import JaVaProjectGameCaro.XuLi.LuaChon;
import JaVaProjectGameCaro.XuLi.QuanLiPlayGameUI;

/**
 *
 * @author ThuyLinh(),VanPhap(),TuanPhat()
 */
public class PlayGameUI  extends javax.swing.JFrame {
	
    private javax.swing.JButton btnDauHang;
    private javax.swing.JButton btnGuiTinNhan;

    private javax.swing.JLabel lblQuanCo;
    private javax.swing.JLabel lbUserDenLuot;
    private javax.swing.JLabel lblXepHang;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblDemNguoc;
    private javax.swing.JLabel lblImageQuanCo;
    private javax.swing.JLabel lblThoiGian;
    
    private javax.swing.JPanel pnChatBox;
    private javax.swing.JPanel pnImageQuanCo;
    private javax.swing.JPanel pnDauHang;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JLabel pnXepHang;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel pnTime;
    private javax.swing.JPanel pnBanCo;
    private javax.swing.JPanel pnMain;
    
    private javax.swing.JScrollPane jscTinHienThi;
    private javax.swing.JTextArea txtTinNhanHienThi;
    private javax.swing.JTextField txtTinNhan;
    
    private LuaChon lc;
    private JFrame jfMenuNow;
    
    private String tenDangNhap;
    private String tenHienThi;
    private int idXepHang;
    
    public PlayGameUI(String tenDangNhap,String tenHienThi,int idXepHang,LuaChon lc,JFrame jfMenuNow) throws IOException {
    	run();
        initComponents();
        addPicture();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.tenDangNhap=tenDangNhap;
        this.tenHienThi=tenHienThi;
        this.idXepHang=idXepHang;
        this.lc=lc;
        this.jfMenuNow=jfMenuNow;
        ServerOrClientOrOffline();
    }
    
    public void ServerOrClientOrOffline() throws IOException {
    	if(lc==LuaChon.SERVER) {
    		new QuanLiPlayGameUIServer(pnBanCo, lblDemNguoc, txtTinNhan, btnDauHang, 
    				txtTinNhanHienThi, btnGuiTinNhan,lblUsername,tenDangNhap,tenHienThi,idXepHang,jfMenuNow,this,pnXepHang,pnImageQuanCo);
    		return;
    	}
    	if(lc==LuaChon.CLIENT) {
    		new QuanLiPlayGameUIClient(pnBanCo, lblDemNguoc, txtTinNhan, btnDauHang, 
    				txtTinNhanHienThi, btnGuiTinNhan,lblUsername,tenDangNhap
    				,tenHienThi,idXepHang,jfMenuNow,this,pnXepHang,pnImageQuanCo);
    		return;
    	}
    	if(lc==LuaChon.PLAYWITHCOMPUTER) {
    		AddPictureToJpanel QuanCo=new AddPictureToJpanel("Image/QuanCoX.png", 0, 0, 30, 30);
            this.pnImageQuanCo.add(QuanCo);
            this.lblUsername.setText("Người Chơi");
            this.pnChatBox.setVisible(false);
    		new  QuanLiPlayGameUI(pnBanCo, lblDemNguoc, btnDauHang,lblUsername,pnImageQuanCo,jfMenuNow,this,LuaChon.PLAYWITHCOMPUTER);
    		return;
    	}
    	if(lc==LuaChon.TWOPLAYER) {   
    		//this.pnChatBox.removeAll();
    		this.pnChatBox.setVisible(false);
    		new QuanLiPlayGameUI(pnBanCo, lblDemNguoc, btnDauHang,lblUsername,pnImageQuanCo, jfMenuNow, this, LuaChon.TWOPLAYER).quanLiPlayer();
    		return;
    	}
    }
    
    private void addPicture() throws IOException {
    	AddPictureToJpanel logo=new AddPictureToJpanel("Image/logo.gif", 0, 0, 328, 107);
        this.pnLogo.add(logo);
        AddPictureToJpanel backg=new AddPictureToJpanel("Image/backg.png", 0, 0, 900, 600);
        this.pnMain.add(backg);
        
    }
                    
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnBanCo = new javax.swing.JPanel();
        pnTime = new javax.swing.JPanel();
        lblThoiGian = new javax.swing.JLabel();
        lblDemNguoc = new javax.swing.JLabel();
        pnThongTin = new javax.swing.JPanel();
        lbUserDenLuot = new javax.swing.JLabel();
        lblQuanCo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        pnImageQuanCo = new javax.swing.JPanel();
        pnXepHang = new javax.swing.JLabel();
        pnChatBox = new javax.swing.JPanel();
        btnGuiTinNhan = new javax.swing.JButton();
        jscTinHienThi = new javax.swing.JScrollPane();
        txtTinNhanHienThi = new javax.swing.JTextArea();
        txtTinNhan = new javax.swing.JTextField();
        pnDauHang = new javax.swing.JPanel();
        btnDauHang = new javax.swing.JButton();
        pnLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setPreferredSize(new java.awt.Dimension(300, 200));

        pnBanCo.setBackground(new java.awt.Color(255, 255, 255));
        pnBanCo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));
        pnBanCo.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout pnBanCoLayout = new javax.swing.GroupLayout(pnBanCo);
        pnBanCo.setLayout(pnBanCoLayout);
        pnBanCoLayout.setHorizontalGroup(
            pnBanCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        pnBanCoLayout.setVerticalGroup(
            pnBanCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        pnTime.setBackground(new java.awt.Color(255, 255, 255));
        pnTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        lblThoiGian.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lblThoiGian.setText("Thời Gian");
        lblThoiGian.setToolTipText("");

        lblDemNguoc.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lblDemNguoc.setText("00");

        javax.swing.GroupLayout pnTimeLayout = new javax.swing.GroupLayout(pnTime);
        pnTime.setLayout(pnTimeLayout);
        pnTimeLayout.setHorizontalGroup(
            pnTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(pnTimeLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(lblDemNguoc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTimeLayout.setVerticalGroup(
            pnTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDemNguoc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pnThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        lbUserDenLuot.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbUserDenLuot.setText("Tên:");

        lblQuanCo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblQuanCo.setText("Lượt chơi:");

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsername.setText("username");

        pnImageQuanCo.setBackground(new java.awt.Color(255, 255, 255));
        pnImageQuanCo.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout pnImageQuanCoLayout = new javax.swing.GroupLayout(pnImageQuanCo);
        pnImageQuanCo.setLayout(pnImageQuanCoLayout);
        pnImageQuanCoLayout.setHorizontalGroup(
            pnImageQuanCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnImageQuanCoLayout.setVerticalGroup(
            pnImageQuanCoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnXepHang.setPreferredSize(new java.awt.Dimension(36, 36));

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(lbUserDenLuot, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(lblQuanCo)
                        .addGap(18, 18, 18)
                        .addComponent(pnImageQuanCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUserDenLuot)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblQuanCo)
                    .addComponent(pnImageQuanCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnChatBox.setBackground(new java.awt.Color(255, 255, 255));
        pnChatBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        btnGuiTinNhan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuiTinNhan.setText("Gửi");
   

        txtTinNhanHienThi.setColumns(20);
        txtTinNhanHienThi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTinNhanHienThi.setRows(5);
        jscTinHienThi.setViewportView(txtTinNhanHienThi);

        txtTinNhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTinNhan.setText("Nhập tin nhắn vào đây nhé!");
    
        javax.swing.GroupLayout pnChatBoxLayout = new javax.swing.GroupLayout(pnChatBox);
        pnChatBox.setLayout(pnChatBoxLayout);
        pnChatBoxLayout.setHorizontalGroup(
            pnChatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChatBoxLayout.createSequentialGroup()
                        .addComponent(txtTinNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuiTinNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jscTinHienThi))
                .addContainerGap())
        );
        pnChatBoxLayout.setVerticalGroup(
            pnChatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChatBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscTinHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuiTinNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnChatBoxLayout.createSequentialGroup()
                        .addComponent(txtTinNhan)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        pnDauHang.setBackground(new java.awt.Color(255, 255, 255));
        pnDauHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        btnDauHang.setBackground(new java.awt.Color(255, 255, 255));
        btnDauHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDauHang.setText("Đầu Hàng");

        javax.swing.GroupLayout pnDauHangLayout = new javax.swing.GroupLayout(pnDauHang);
        pnDauHang.setLayout(pnDauHangLayout);
        pnDauHangLayout.setHorizontalGroup(
            pnDauHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDauHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnDauHangLayout.setVerticalGroup(
            pnDauHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDauHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnLogo.setBackground(new java.awt.Color(255, 255, 255));
        pnLogo.setToolTipText("");

        javax.swing.GroupLayout pnLogoLayout = new javax.swing.GroupLayout(pnLogo);
        pnLogo.setLayout(pnLogoLayout);
        pnLogoLayout.setHorizontalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        pnLogoLayout.setVerticalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnChatBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDauHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnBanCo, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(pnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnDauHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnChatBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnBanCo, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }                      
    
    public void run() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
     
}

