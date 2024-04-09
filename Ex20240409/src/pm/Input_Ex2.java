package pm;

import java.io.IOException;
import java.io.InputStream;

public class Input_Ex2 {

	public static void main(String[] args) {
		// 키보드(System.in)와 연결된 스트림 얻기
		InputStream key = System.in;
		
		System.out.print("입력: ");
		int i = 0;
		
		while(i<4) {
			try { // read()는 반드시 씌어야한다.
				int data = key.read(); // 해당 변수는 지역변수로 try문을 벗어나면 사용하지 못한다.
				System.out.println(data+":"+(char)data);
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		} // while문의 끝
		System.out.println("프로그램 끝");

	}

}
