package homework;

import java.awt.Rectangle;

public class Meteor_Ex2 extends Thread {
	// 운석을 의미하는 클래스
	Rectangle rect = new Rectangle();
	int speed;
	
	// 현재 운석객체는 Frame정보를 가지고 있어야 한다. 이유는
	// 그곳에 있는 ArrayList와 JPanel등을 접근해야 한다.
	Frame_Ex2 f;
	
	public Meteor_Ex2(Frame_Ex2 f, int w, int h) {
		this.f = f;
		
		//받은 너비와 높이를 Rectangle에 저장한다.
		rect.width = w;
		rect.height = h;
		
		speed = (int)(Math.random()*50+20);
	}

	@Override
	public void run() {
		// 무한반복을 통해 y값을 증가 시킨다.
		// 이때 화면 하단에 도달할 경우 무한반복을 탈출하자!
		while(true) {
			rect.y += 5;
			
			//화면 하단에 도달했는지? 확인!!
			if(f.p.getSize().height - rect.height <= rect.y)
				break;
			
			//주인공 객체와 충돌여부 확인
			if(rect.intersects(f.me.pos)) {
				
				break;//현재 운석객체 소멸
			}
			
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				// TODO: handle exception
			}
			f.p.repaint();//다시 그리기
		}
		f.m_list.remove(this);//현재 운석객체 삭제!
	}
}
