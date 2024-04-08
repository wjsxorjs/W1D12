package amBfClass;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	// 크기 객체 Dimension
	Dimension d = new Dimension(390, 590);
	
	// 필요한 각 이미지들 (배경, 주인공, 운석, 폭발 등)
	Image back_img, me_img, meteor_img, bullet_img;
	
	Me me = new Me();
	
	ArrayList<Meteor> m_list = new ArrayList<Meteor>();
	
	ArrayList<Bullet> b_list = new ArrayList<Bullet>();
	
	ArrayList<Explosion> e_list = new ArrayList<Explosion>();
	
	int score;
	
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// 배경 그리기
			g.drawImage(back_img, 0, 0, this);
			
			// 주인공 그리기
			g.drawImage(me_img, me.rect.x, me.rect.y, this);

			//운석 그리기
			for(int i=0;i<m_list.size();i++) {
				Meteor m = m_list.get(i);
				g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
			}
			
			//총알 그리기
			for(int i=0;i<b_list.size();i++) {
				Bullet b = b_list.get(i);
				g.drawImage(bullet_img, b.rect.x, b.rect.y, this);
			}
			
			// 폭발 그리기
			for(int i=0; i<e_list.size(); i++) {
				Explosion e = e_list.get(i);
				g.drawImage(e.explosion_img, e.x, e.y, this);
			}
			
			
		}
		
	};
	
	public void title() {
		String title = new StringBuffer("Score: ").append(score).toString();
		
		this.setTitle(title);

	}
	
	public Frame() {

		
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		meteor_img = new ImageIcon("src/images/meteor.png").getImage();
		bullet_img = new ImageIcon("src/images/bullet.png").getImage();
				
		// 게임 초기화
		init_game();
		
		// 주인공 이미지 초기화
		init_me_pos();
		
		
		this.setLocation(300, 100); // 창의 위치
		this.pack(); 				// 컴포넌트들의 크기에 맞게 사이즈 설정
									// 이 경우, 패널을 넣었으니 패널의 사이즈에 맞춤
		
		this.title();
		this.setResizable(false);
		this.setVisible(true);
		
		
		// 운석 생성기 시작
		init_meteor();
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_LEFT:
					me.rect.x -= me.rect.width/2;
					if(me.rect.x < 0) {
						me.rect.x = 0;
					}
//					if(me.pos.x < 0) {
//						me.pos.x = d.width-me.pos.width;
//					}
					break;
					
				case KeyEvent.VK_RIGHT:
					me.rect.x += me.rect.width/2;
					if(me.rect.x > d.width-me.rect.width) {
						me.rect.x = d.width-me.rect.width;
					}
//					if(me.pos.x > d.width-me.pos.width) {
//						me.pos.x = 0;
//					}
					break;
					
				case KeyEvent.VK_SPACE:
					Bullet b = new Bullet(me.rect.x+(me.rect.width/2), me.rect.y, Frame.this);
					b_list.add(b);
					b.start();
					break;
					
					
				}// switch의 끝
				p.repaint();
			}
			
			
		});
		
	}
	
	private void init_game() {
		// 크기객체(Dimension)을 가지고 JPanel의 크기를 예약한다
		
		p.setPreferredSize(d);
		
		// 크기가 예약된 JPanel을 현재 창 가운데에 추가
		this.add(p);
		
	}
	
	private void init_me_pos() {
		
		int meWidth = me_img.getWidth(this);	// 주인공 이미지의 너비
		int meHeight = me_img.getHeight(this);	// 주인공 이미지의 높이
		
		me.rect.x = (d.width - meWidth) / 2;
		me.rect.y = d.height - meHeight - 5;
		me.rect.width = meWidth;
		me.rect.height = meHeight;
		

	}
	
	private void init_meteor() {
		MeteorGen mg = new MeteorGen(this);
		mg.start();
		
	}
	
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame();

	}

}
