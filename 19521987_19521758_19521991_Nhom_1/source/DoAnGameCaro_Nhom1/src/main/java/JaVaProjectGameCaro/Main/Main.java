package JaVaProjectGameCaro.Main;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import JaVaProjectGameCaro.Model.LoaiXepHang;
import JaVaProjectGameCaro.Model.LoaiXepHangDAO;
import JaVaProjectGameCaro.Model.NguoiChoi;
import JaVaProjectGameCaro.Model.NguoiChoiDAO;
import JaVaProjectGameCaro.UI.DoiMatKhauUI;
import JaVaProjectGameCaro.UI.LoginUI;
import JaVaProjectGameCaro.UI.QuanLiUI;

public class Main {
	
	public static boolean isTCPPortAvailable(int hostPort) throws IOException {
	    ServerSocket tempSocket = null;
	    try {
	        tempSocket = new ServerSocket();
	        // Enable Reuse before binding
	        tempSocket.setReuseAddress(true);
	        tempSocket.bind(new InetSocketAddress(hostPort));
	        tempSocket.close();
	        return true;
	    }
	    catch (BindException ex) {
	        // Denotes that port is in use
	    }
	    return false;
	}

	public static void main(String[] args) throws IOException {
		new LoginUI().setVisible(true);
	}

}
