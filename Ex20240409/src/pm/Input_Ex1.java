package pm;

import java.io.IOException;
import java.io.InputStream;

public class Input_Ex1 {

	public static void main(String[] args) {
		// 키보드(System.in)와 연결된 스트림 얻기
		InputStream key = System.in;
		
		System.out.print("입력: ");
		try {
			int code = key.read();
			System.out.println(code);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
