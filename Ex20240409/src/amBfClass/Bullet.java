package amBfClass;

import java.awt.Rectangle;

public class Bullet extends Thread {
	
	Rectangle rect = new Rectangle();
	
	boolean chk;
	
	Frame f;
	
	public Bullet(int x, int y, Frame f) {
		
		
		rect.width = f.bullet_img.getWidth(f);
		rect.height = f.bullet_img.getHeight(f);
		
		rect.x = x - rect.width/2;
		rect.y = y - rect.height;
		
		this.f = f;
		
		
		
	}
	
	@Override
	public void run() {
		while(rect.y > 0) {
			
			rect.y -= 3;
			
			f.p.repaint();
			try {
				for(int i =0; i< f.m_list.size(); i++) {
				Meteor m = f.m_list.get(i);
				if(this.rect.intersects(m.rect)) {
					f.score++;
					f.title();
					m.chk = true;
					chk = true;
					break;
				}
			}
			} catch (Exception e) {}
			
			if(chk) {
				Explosion e = new Explosion(rect.x, rect.y, f);
				f.e_list.add(e);
				e.start();
				break;
			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
		
		f.b_list.remove(this);
		
	}

}
