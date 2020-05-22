package com.singletong.model;

/**
 * 静态内部类单例模式 线程安全，推荐使用（实现懒加载模式）
 * 第一次加载SingletonStatic类时并不会初始化，
 * 只有第一次调用getInstance方法时虚拟机加载静态内部类SingletonFactory 并初始化singleInstance ，
 * 这样不仅能确保线程安全也能保证SingletonStatic类的唯一性，所以推荐使用静态内部类单例模式。
 */
public class SingletonStatic {
	private SingletonStatic(){}
	
	//静态内部类
	private static class SingletonFactory{
		private static final SingletonStatic singleInstance = new SingletonStatic();
	}
	
	public static SingletonStatic getInstance(){
		return SingletonFactory.singleInstance;
	}
}
