package JaVaProjectGameCaro.UI;

import java.io.IOException;

import javax.swing.JFrame;

import JaVaProjectGameCaro.XuLi.AddPictureToJpanel;
import JaVaProjectGameCaro.XuLi.QuanLiDangKiTaiKhoanUI;

public class DangKiTaiKhoanUI extends javax.swing.JFrame {
	private javax.swing.JButton btnDangKy;
	private javax.swing.JButton btnThoat;
    private javax.swing.JLabel lblNhapLaiPass;
    private javax.swing.JPanel pnButtonDangKy;
    private javax.swing.JPanel pnDangKy;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPasswordField txtNhapLaiPass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTenHienThi;
    private javax.swing.JTextField txtUsername;
    
    private JFrame JFLoginNow;

    public DangKiTaiKhoanUI(JFrame JFLoginNow) throws IOException {
    	run();
        initComponents();
        addPicture();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.JFLoginNow=JFLoginNow;
        new QuanLiDangKiTaiKhoanUI(btnDangKy, btnThoat, txtUsername, txtTenHienThi, txtPassword, txtNhapLaiPass, JFLoginNow,this);
    }
    
    public void addPicture() throws IOException {
    	AddPictureToJpanel logo=new AddPictureToJpanel("Image/logologin.gif", 0, 0, 400, 140);
        this.pnLogo.add(logo);
        AddPictureToJpanel backg=new AddPictureToJpanel("Image/backg.png", 0, 0, 900, 600);
        this.pnMain.add(backg);
        
    }
                          
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnDangKy = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtTenHienThi = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtNhapLaiPass = new javax.swing.JPasswordField();
        lblNhapLaiPass = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        pnLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));

        pnDangKy.setBackground(new java.awt.Color(255, 255, 255));
        pnDangKy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtUsername.setText("Tên đăng nhập");

        txtTenHienThi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenHienThi.setText("Tên hiển thị");
      

        txtPassword.setText("Mật khẩu");
    
        txtNhapLaiPass.setText("Mật khẩu");
      
        lblNhapLaiPass.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblNhapLaiPass.setText("Nhập lại mật khẩu");

        btnThoat.setBackground(new java.awt.Color(0, 153, 255));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
     

        btnDangKy.setBackground(new java.awt.Color(0, 153, 255));
        btnDangKy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Đăng Ký");
     
        javax.swing.GroupLayout pnDangKyLayout = new javax.swing.GroupLayout(pnDangKy);
        pnDangKy.setLayout(pnDangKyLayout);
        pnDangKyLayout.setHorizontalGroup(
            pnDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangKyLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenHienThi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNhapLaiPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDangKyLayout.createSequentialGroup()
                        .addGroup(pnDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNhapLaiPass, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDangKyLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDangKyLayout.setVerticalGroup(
            pnDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangKyLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNhapLaiPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhapLaiPass)
                .addGap(18, 18, 18)
                .addGroup(pnDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnLogo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnLogoLayout = new javax.swing.GroupLayout(pnLogo);
        pnLogo.setLayout(pnLogoLayout);
        pnLogoLayout.setHorizontalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnLogoLayout.setVerticalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(250, 250, 250))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(pnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }                       


    private void run() {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangKiTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKiTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKiTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKiTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
                
}


