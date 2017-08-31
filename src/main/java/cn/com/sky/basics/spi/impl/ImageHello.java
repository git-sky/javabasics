package cn.com.sky.basics.spi.impl;

import cn.com.sky.basics.spi.HelloInterface;

public class ImageHello implements HelloInterface {

	@Override
	public void sayHello() {
		System.out.println("Image Hello...");
	}
	
}