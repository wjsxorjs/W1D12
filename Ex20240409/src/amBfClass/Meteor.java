package amBfClass;

import java.awt.Rectangle;

public class Meteor extends Thread {

	Rectangle rect = new Rectangle();
	int speed;
	
	boolean chk;
	
	Frame f;
	
	
	public Meteor(Frame f) {
		rect.x = (int)(Math.random()*(f.d.width - f.meteor_img.getWidth(f))+0);
		rect.y = -30;
		rect.width = f.meteor_img.getWidth(f);
		rect.height = f.meteor_img.getHeight(f);
		speed = (int)(Math.random()*20+20);
		
		this.f = f;
		
	}
	
	
	
	@Override
	public void run() {
		while(rect.y < f.d.height-rect.height) {
			rect.y += 5;
			f.p.repaint();
			
			if(rect.intersects(f.me.rect)) {
				f.score -= 1;
				f.title();
				Explosion e = new Explosion(f.me.rect.x+(f.me.rect.width/2), f.me.rect.y, f);
				f.e_list.add(e);
				e.start();
				break;
			}
			
			if(chk) break;
			
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
		}
		
		f.m_list.remove(this);
	}
	
}
