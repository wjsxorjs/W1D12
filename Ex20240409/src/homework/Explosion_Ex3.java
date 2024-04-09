package homework;

import java.awt.Point;

public class Explosion_Ex3 {
	// 주인공과 운석이 충돌했을 때 폭발이 발생하는 의미의 클래스다.
	int size = 128;
	// 위치 객체 (x좌표, y좌표)
	Point pt = new Point();
	
	// 현재 객체가 하나 생성될 때는 운석이 주인공과 충돌했을 때
	// 이때 운석이 폭발하면서 사라져야 한다.
	
	// 폭발 이미지는 27개, 이들은 Frame 창에 배열로 미리 준비해둔다.
	// 배열에 접근하는 index값
	int index;
	int gap = 5; // 반복 수행이 gap만큼 돌 때 index증가
	int interval = gap+1;
	
	public boolean move_index() {
		if(interval == gap) {
			index++;
		}
		interval--;
		if(interval==0) {
			interval = gap;
		}
		
		// 인덱스 값은 27이 되면 현재 함수는
		// 폭발이미지 27개를 모두 표현한 경우가 된다.
		// 즉, 현재 객체의 폭발 역할이 끝나야한다.
		return index >= 27; // index가 27이 될 때 true가 반환된다.
	}
	
	
	
}
