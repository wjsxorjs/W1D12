package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput_Ex4 {

	
	
	public static void main(String[] args) {
		// 연결할 파일의 경로 준비
		String path = "C:/My_Study/io_test.txt";
		
		File f = new File(path);
		
		if(f.exists()) {
			FileInputStream fis = null;
			try {
				// 파일의 내용을 읽기 위해 스트림 준비
				fis = new FileInputStream(f);
				
				byte[] buf = new byte[4096]; // 바구니와 같은 역할 (4KB)
				
				int size = -1; // read함수가 읽은 수를 저장하는 변수
				
				int count = 0;
				
				while((size = fis.read(buf)) != -1) {
					// 실제 읽은 자원들은 buf라는 byte[]에 저장된 상태
					System.out.write(buf, 0, size); // buf의 0번지부터 size만큼 가지고 와서 write()해라
					
					// buf의 0번지부터 size가 기억하는 길이만큼 가져와서
					// 문자기반의 출력을 한다. (한글이 깨지지않는다.)
					count++;
				}// while문의 끝
				
				System.out.println();
				System.out.println(count+"회 반복");
				
			} catch (Exception e) {}
			finally {
				try {
					if(fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

	
	
}
