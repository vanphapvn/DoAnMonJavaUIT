package JaVaProjectGameCaro.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;

public class XepHangUI extends javax.swing.JFrame {
	
	private javax.swing.JButton btnThoat;
	private javax.swing.JLabel lblXepHang;
	private javax.swing.JPanel pnControls;
	private javax.swing.JPanel pnMain;
	private javax.swing.JPanel pnTableXepHang;
	private javax.swing.JPanel pnThoat;
	
	private JTable jtbBangXH;
    private DefaultTableModel dftBangXH;
    
    private JFrame jfMemuNow;
	
    public XepHangUI(int thuTuXH,JFrame jfMemuNow) {
    	run();
        initComponents();
        addControls();
        lblXepHang.setText(lblXepHang.getText()+thuTuXH);
        this.jfMemuNow=jfMemuNow;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addEvents();
        loadDanhSachXH();
    }
    
    private void loadDanhSachXH() {
    	List<NguoiChoi> ds=NguoiChoiDAO.getDSNguoiChoiTheoDiemXH();
    	for(int i=0;i<ds.size() && i<100;i++) {
    		Vector<Object> vec=new Vector<Object>();
    		vec.add(i+1);
    		vec.add(ds.get(i).getTenHienThi());
    		vec.add(ds.get(i).getDiemXepHang());
    	
    		dftBangXH.addRow(vec);
    	}
    }
    
    private void addControls() {
    	dftBangXH = new DefaultTableModel();
    	dftBangXH.addColumn("Top");
    	dftBangXH.addColumn("Tên");
    	dftBangXH.addColumn("Điểm");
    	
    	jtbBangXH=new JTable(dftBangXH);
        JScrollPane scTable1=new JScrollPane(jtbBangXH,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.pnTableXepHang.setLayout(new BorderLayout());
        pnTableXepHang.add(scTable1,BorderLayout.CENTER);
        pnTableXepHang.setPreferredSize(new Dimension(309,308));
    }
    
    private void addEvents() {
    	this.btnThoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLibtnThoat();
			}
		});
    }
    
    private void xuLibtnThoat() {
    	
    	jfMemuNow.setVisible(true);
    	this.dispose();
    }
                          
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnControls = new javax.swing.JPanel();
        lblXepHang = new javax.swing.JLabel();
        pnThoat = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        pnTableXepHang = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));

        pnControls.setBackground(new java.awt.Color(255, 255, 255));
        pnControls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 4));

        lblXepHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblXepHang.setText("Xếp hạng: ");

        btnThoat.setBackground(new java.awt.Color(0, 255, 102));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
    
        javax.swing.GroupLayout pnThoatLayout = new javax.swing.GroupLayout(pnThoat);
        pnThoat.setLayout(pnThoatLayout);
        pnThoatLayout.setHorizontalGroup(
            pnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        pnThoatLayout.setVerticalGroup(
            pnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThoatLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnTableXepHang.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnTableXepHangLayout = new javax.swing.GroupLayout(pnTableXepHang);
        pnTableXepHang.setLayout(pnTableXepHangLayout);
        pnTableXepHangLayout.setHorizontalGroup(
            pnTableXepHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        pnTableXepHangLayout.setVerticalGroup(
            pnTableXepHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnControlsLayout = new javax.swing.GroupLayout(pnControls);
        pnControls.setLayout(pnControlsLayout);
        pnControlsLayout.setHorizontalGroup(
            pnControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnControlsLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(pnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(pnControlsLayout.createSequentialGroup()
                .addGroup(pnControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnControlsLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(pnTableXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnControlsLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnControlsLayout.setVerticalGroup(
            pnControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnControlsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(pnTableXepHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblXepHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(pnControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(pnControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>       
    
    private void run() {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XepHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XepHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XepHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XepHangUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }




               
}
