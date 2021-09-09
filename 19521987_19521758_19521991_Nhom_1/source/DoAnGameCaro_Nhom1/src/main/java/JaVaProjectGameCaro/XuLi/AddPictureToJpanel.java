package JaVaProjectGameCaro.XuLi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author VanNinh
 */
public class AddPictureToJpanel extends JPanel {

    /**
	 * 
	 */
	private int width;
    private int height;
    private Image myImage;

    public AddPictureToJpanel(String nameFile, int x, int y, int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        //String s = getClass().getResource(nameFile).toString();
        ImageIcon ii=new ImageIcon(this.getClass().getResource(nameFile));
        BufferedImage dc=ImageIO.read(this.getClass().getResource(nameFile));
        this.myImage = new ImageIcon(getClass().getResource(nameFile)).getImage(); 
       // this.myImage=ii.getImage();
                        // hình ảnh phải bỏ trong thư mục src của project
        setLayout(null);
        this.setBounds(x, y, width, height);
        repaint();
    }

    public void setPicture(String nameFile) {
        this.myImage = new ImageIcon(getClass().getResource(nameFile)).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(myImage, 0, 0, this);

    }

}

