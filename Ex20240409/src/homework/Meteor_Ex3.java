package homework;

import java.awt.Rectangle;

public class Meteor_Ex3 extends Thread {
	// 운석을 의미하는 클래스
	Rectangle rect = new Rectangle();
	int speed;
	
	// 현재 운석객체는 Frame정보를 가지고 있어야 한다. 이유는
	// 그곳에 있는 ArrayList와 JPanel등을 접근해야 한다.
	Frame_Ex3 f;
	
	public Meteor_Ex3(Frame_Ex3 f, int w, int h) {
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
				//폭발 객체 생성
				Explosion_Ex3 exp = new Explosion_Ex3();
				//충돌한 위치값(x,y)를 폭발객체에 저장
				exp.pt.x = (int)rect.getCenterX() - exp.size/2;
				exp.pt.y = (int)rect.getCenterY() - exp.size/2;
				
				// Frame창의 멤버변수인 ex_list에
				// 폭발객체 저장!!
				f.ex_list.add(exp);
				
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
