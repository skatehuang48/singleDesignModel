package com.singletong.model;

/**
 * 懒汉模式，多线程并发时不安全，会产生多个实例
 * 在用户第一次调用时初始化，虽然节约了资源，但第一次加载时需要实例化，反映稍慢一些
 * @author Administrator
 *
 */
public class Lazy {

	private static Lazy lazyInstance;
	private Lazy(){
	}
	
	public static Lazy getInstance(){
		if(lazyInstance == null){
			lazyInstance = new Lazy();
		}
		return lazyInstance;
	}
}
