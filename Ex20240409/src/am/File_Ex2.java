package am;

import java.io.File;

public class File_Ex2 {

	public static void main(String[] args) {
		// 폴더를 가지고 File 객체를 생성한다면
		// 하위 폴더 및 파일들의 목록을 얻어낼 수 있다.
		
		// 파일들은 모두 경로(위치)를 가지고 있다.
		String path_1 = "C:/My_Study";
		String path_2 = "C:/My_Study/Java_Study";
		String path_3 = "C:/My_Study/Java_Study/work";
		
		// 준비된 경로를 가지고 File객체 생성
		File f = new File(path_3);
		
		// f가 폴더(디렉토리)일 경우에만 수행하도록 비교한다.
		if(f.exists() && f.isDirectory()) {
			// 실제 존재하면서 디렉토리인 경우에만 수행하는 곳.
			
			// 디렉토리는 내부에 서브폴더 및 파일들이 존재하므로
			// 이 모두를 얻어낼 수 있다.
			String[] sub_1 = f.list(); // String으로 받기에 파일인지 폴더인지는 구분하지 못한다.
			
			// 하위 목록을 반복문을 이용하여 출력
			for(int i=0; i< sub_1.length; i++) {
				System.out.println(sub_1[i]);
			}
			
			System.out.println("---------------------------");
			
			// File[] 배열로 받는 이유는 하위의 요소가
			// 파일인지 디렉토리인지 판단할 수 있기 때문
			File[] sub_2 = f.listFiles();
			
			// 하위 목록을 반복문을 이용하여 출력
			for(int i=0; i< sub_2.length; i++) {
				
				if(sub_2[i].isDirectory()) {
					System.out.print("[디렉토리]"); 	// .length() 용량 사용해도 0으로 나온다. 즉, 용량을 구하지 못한다.
				} else if(sub_2[i].isFile()) {
					System.out.print("[파일]"); 		// .length() 용량 사용하면 Byte로 나온다.
				}
				System.out.println(sub_2[i].getName());
			}
		}
		
	}
	
}
