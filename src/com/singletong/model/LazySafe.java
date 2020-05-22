package com.singletong.model;

/**
 * 懒汉模式 加锁 线程安全 但效率低 （锁加在方法上，多线程每次执行都是串行不是并发，所以效率低下）
 * 这种写法能够在多线程中很好的工作，但是每次调用getInstance方法时都需要进行同步，
 * 造成不必要的同步开销，而且大部分时候我们是用不到同步的，所以不建议用这种模式。
 */
public class LazySafe {
	private static LazySafe lazyInstance;
	private LazySafe(){}
	public static synchronized LazySafe getInstance(){
		if(lazyInstance == null){
			lazyInstance = new LazySafe();
		}
		return lazyInstance;
	}
}
