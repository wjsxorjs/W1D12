package pm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Buffered_Ex7_Ans {

	public static void main(String[] args) {
		// 현재 파일 경로
		String path = "C:/My_Study/Java_Study/work/Ex20240409/src/pm/Buffered_Ex7.java";
		

		//위의 파일의 내용을 읽어서 "C:/my_Study/io_test.txt"파일에 쓰기
		String save_path = "C:/My_Study/io_test.txt";
		
		File f = new File(path);
		
		if(f.exists()) {
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			
			try {
				bis = new BufferedInputStream(new FileInputStream(f));
				bos = new BufferedOutputStream(new FileOutputStream(save_path));
				
				byte[] buf = new byte[2048];
				int size = -1;
				while((size = bis.read(buf))!=-1) {
					bos.write(buf,0,size);
					bos.flush();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if(bis != null) {
						bis.close();
					}
					if(bos != null) {
						bos.close();
					}
				} catch(Exception e) {
					
				}
			}
		}
		System.out.println("프로그램 종료");
	}

}
