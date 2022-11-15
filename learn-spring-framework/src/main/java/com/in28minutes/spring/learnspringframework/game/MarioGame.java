package com.in28minutes.spring.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("MarioGame up");
	}

	public void down() {
		System.out.println("MarioGame down");
	}

	public void left() {
		System.out.println("MarioGame left");
	}

	public void right() {
		System.out.println("MarioGame right");
	}
}
