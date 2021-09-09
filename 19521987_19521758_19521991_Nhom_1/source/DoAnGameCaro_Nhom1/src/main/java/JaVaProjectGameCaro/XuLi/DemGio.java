package JaVaProjectGameCaro.XuLi;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DemGio extends Thread{
	 private JLabel lblDemNguoc;
	 private int countDown;
	 private Player playerNow;
	 private JFrame jfPlayNow;
	 private JFrame jfMenuNow;
	 

	 
    public DemGio(JLabel lblDemNguoc,Player playerNow,JFrame jfPlayNow,JFrame jfMenuNow)  {
		this.lblDemNguoc = lblDemNguoc;
		this.countDown=Vars.COUNTDOWNTIME;
		this.playerNow=playerNow;
		this.jfPlayNow=jfPlayNow;
		this.jfMenuNow=jfMenuNow;
		
		
	}
	@Override
    public void run() {

        
        while(this.countDown>=0) {
        	this.countDown--;
        	
        	try {
        		String demNguoc=String.valueOf(this.countDown);
        		if(countDown>9) {
        			this.lblDemNguoc.setText(demNguoc);
        		}else {
        			this.lblDemNguoc.setText("0"+demNguoc);
        		}
        		Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        	if(this.countDown==0) {
        		JOptionPane.showMessageDialog(null,playerNow.getuserName()+" đã bị xử thua do hết giờ !");
        		jfMenuNow.setVisible(true);
    			jfPlayNow.dispose();
        	}
        }
    }
	public int getCountDown() {
		return countDown;
	}
	public void setCountDown(int count) {
		this.countDown = count;
	}
	public Player getPlayerNow() {
		return playerNow;
	}
	public void setPlayerNow(Player playerNow) {
		this.playerNow = playerNow;
	}

	
	
}

	


