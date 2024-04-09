package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame_Ex3 extends JFrame {
	
	String pathStr;
	
	File[] fileArr;
	
	JTextField url_tf;
	
	JButton btn;
	
	JPanel north_p;
	
	JList<String> center_list;
	
	
	public Frame_Ex3() {
		
		north_p = new JPanel(new BorderLayout());
		//JPanel이 원해는 FlowLayout이었지만 BorderLayout으로 변경함
		
		north_p.add(new JLabel("URL: "),BorderLayout.WEST);
		north_p.add(url_tf = new JTextField());
		north_p.add(btn = new JButton("확인"),BorderLayout.EAST);
		
		this.add(north_p,BorderLayout.NORTH);
		this.add(new JScrollPane(center_list = new JList<String>()));
		
		this.setBounds(300, 100, 500, 600);
		this.setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String path = url_tf.getText().trim();
				
				if(path.length()==0) {
					// 경고창(메세지 창) 보여주기
					JOptionPane.showMessageDialog(Frame_Ex3.this, "입력된 값이 없습니다!");
				} else {
					File f = new File(path);
					if(f.exists()) {
						if(f.isDirectory()) {
							//하위 목록을 얻어낸다.
							String[] sub = f.list();
							
							//얻어낸 배열을 통해 JList 생성
							center_list.setListData(sub);
							center_list.revalidate();
							
							
						} else {
							// 경고창(메세지 창) 보여주기
							JOptionPane.showMessageDialog(Frame_Ex3.this, "디렉토리가 아닌\n파일입니다!");
						}
					} else {
					// 경고창(메세지 창) 보여주기
					JOptionPane.showMessageDialog(Frame_Ex3.this, "존재하지 않습니다!");
						
					}
				}
				
			}
		});
		
		
	}
	

	public static void main(String[] args) {
		new Frame_Ex3();

	}

}
