package com.singletong.model;

/**
 * 双重检查锁线程安全模式（加关键字volatile(jvm禁止指令重排序)修饰实例变量）
 * 将lazyDCLSafeInstance声明为voliate，可以在lazyDCLSafeInstance 实例化的第一时间回写到系统内存，
 * 防止线程1执行完同步代码块后，没有及时回写lazyDCLSafeInstance，导致线程2判断lazyDCLSafeInstance==null时，读取的数据还是旧的数据
 * 线程安全
 */
public class LazyDCLSafe {
	private volatile static LazyDCLSafe lazyDCLSafeInstance;
	private LazyDCLSafe(){}
	
	public static LazyDCLSafe getInstance(){
		if(lazyDCLSafeInstance == null){
			synchronized(LazyDCLSafe.class){
				if(lazyDCLSafeInstance == null){
					lazyDCLSafeInstance = new LazyDCLSafe();
				}
			}
		}
		return lazyDCLSafeInstance;
	}
}
