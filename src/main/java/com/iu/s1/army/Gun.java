package com.iu.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Gun {
	
	@Autowired
	private Bullet bullet;
	
	
	public Gun() {
		
	}
	
	//의존성 주입 만든 객체를 주입
	public Gun(Bullet bullet) {
		this.bullet = bullet;
	}
	public void trigger() {
		this.bullet.sound();
	}
}
