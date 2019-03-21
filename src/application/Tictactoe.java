package application;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public enum Tictactoe {

	CIRCLE("O","o.png"),
	CROSS("X", "x.png");
	private String pion = "";
	private final BufferedImage image;
	
	Tictactoe(String a, String filename) {
			this.pion = a;
	        BufferedImage tempImage = null;
	        try {
	             tempImage = ImageIO.read(new File(filename));
	        } catch (Exception e) {
	             tempImage = null;
	        }
	        image = tempImage;
	   }
	public String toString() {
		return this.pion;
	}
	public BufferedImage getImage() {
		return this.image;
	}
}
