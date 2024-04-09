package am;

import java.io.File;

public class File_Ex1 {

	public static void main(String[] args) {
		// JAVA에서 File 객체는
		// 파일뿐만 아니라 폴더(디렉토리)를 객체화 시키는 클래스다.
		// 실제 존재하지 않아도 File 객체로 생성이 가능하다.
		
		String path = "C:/My_Study";
		File f1 = new File(path);
		
		//생성된 객체가 파일인지 디렉토리인지 판단
		if(f1.isDirectory()) {
			System.out.println("폴더입니다.");
			
		} else if(f1.isFile()) {
			System.out.println("파일입니다.");
		}
		
		if(f1.exists()) {
			System.out.println("실존합니다.");
		} else {
			System.out.println("존재하지 않습니다.");
		}
		
		

	}

}
