package com.singletong.model;

/**
 * 饿汉模式，
 * 这种方式在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快。
 *  这种方式基于类加载机制避免了多线程的同步问题，但初始化instance没有达到懒加载的效果。
 * 线程安全
 * @author Administrator
 *
 */
public class Hungry {

	private static Hungry hungryInstance = new Hungry();
	
	/**
	 * 构造器私有化，防止其他类调用实例化
	 */
	private Hungry(){
		
	}
	
	public static Hungry getInstance(){
		return hungryInstance;
	}
}
