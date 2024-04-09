package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput_Ex3 {

	public static void main(String[] args) {
		// 파일 경로
		String path = "C:/My_Study/io_test.txt";

		File f = new File(path);
		
		
		// 파일 객체를 먼저 생성하여 해당 파일 객체의 존재여부 확인
		if(f.exists()) {
			FileInputStream fis = null; // null값이 기본값이다. 주소값을 저장하는데
										// 저장할 주소값이 없으므로 null을 기본값으로 갖는다.
			try {
				fis = new FileInputStream(f);
				int data = -1;
				
				// 파일로부터 더 이상 읽을 것이 없을 때까지 반복처리한다.
				
				while((data = fis.read()) != -1) { // EOF(End Of File)의 값이 -1이다.
					System.out.print((char)data);
				}
				
//				fis.close(); // 스트림 닫기 | 좋지 않은 방법
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {}
				}
			}
		}
		
		
	}

}
