package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput_Ex5 {

	public static void main(String[] args) {
		// 연결하고자 하는 파일의 경로 준비
		String path = "C:/My_Study/io_test.txt";
		
		// 준비된 경로로 파일 객체 생성
		File f = new File(path);
		
		// 파일로부터 읽기를 하기 위해 스트림 준비
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(f));
			
			byte[] buf = new byte[2048];
			int size = -1;
			
			while((size=bis.read(buf))!= -1) {
				System.out.write(buf, 0, size);
			}
			
			
		} catch (Exception e) {}
		finally {
				try {
					if(bis != null) {
						bis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	

	}

