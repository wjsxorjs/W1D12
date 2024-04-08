package amBfClass;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Explosion extends Thread {
	int x, y, imgInd;
	Frame f;
	Image explosion_img;
	
	public Explosion(int x,int y, Frame f) {
		this.x = x;
		this.y = y;
		
		this.f = f;
		
		this.imgInd = 1;
	}
	
	@Override
	public void run() {
		while(imgInd<28) {
			
			String filePath = new StringBuffer("src/images/exp_enemy_1/exp_").append(imgInd).append(".png").toString();
			
			explosion_img = new ImageIcon(filePath).getImage();
			
			int tmpX = x;
			int tmpY = y;
			
			x = x - (explosion_img.getWidth(f)/2);
			y = y - (explosion_img.getHeight(f)/2);
			
			f.p.repaint();
			
			
			try {
				Thread.sleep(50);
				imgInd++;
				x = tmpX;
				y = tmpY;
			} catch (Exception e) {}
		}
		
		f.e_list.remove(this);
	}
	
}
