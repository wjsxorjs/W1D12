package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Buffered_Ex7 {

	public static void main(String[] args) {
		// 현재 파일 경로
		String inPath = "C:/My_Study/Java_Study/work/Ex20240409/src/pm/Buffered_Ex7.java";
		File inF = new File(inPath);
		
		
		//위의 파일의 내용을 읽어서 "C:/my_Study/io_test.txt"파일에 쓰기
		String outPath = "C:/My_Study/io_test.txt";
		File outF = new File(outPath);
		
		if(inF.exists() && inF.isFile()) {
			BufferedInputStream bis = null;
			
			if(!outF.exists()) {
				FileOutputStream fos = null;
				
				try {
					bis = new BufferedInputStream(new FileInputStream(inF));
					fos = new FileOutputStream(outF);
					
					int size = -1;
					byte[] buf = new byte[4096];
					
					while((size = bis.read(buf))!= -1) {
						fos.write(buf,0,size);
						fos.flush();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(bis != null) {
							bis.close();
						}
						if(fos != null) {
							fos.close();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "저장하려는 파일 이름을 가진 파일이\n 이미 저장하시려는 디렉토리에 존재합니다.");
			}
			
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "존재하지않은 파일이거나 디렉토리에 접근하셨습니다.");
		}

	}

}
