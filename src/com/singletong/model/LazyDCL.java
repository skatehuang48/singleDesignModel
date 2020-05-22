package com.singletong.model;
/**
 * 懒汉模式的DCL（双重检查锁）实现单例  大多数并发情况下线程安全，但有小概率线程不安全
 将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，
 并创建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的，
 看下面的情况（线程不安全原因）：在Java指令中创建对象和赋值操作是分开进行的，
 也就是说LazyDclInstance = new LazyDCL();语句是分两步执行的
 。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，
 然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了，我们以A、B两个线程为例：
a>A、B线程同时进入了第一个if判断
b>A首先进入synchronized块，由于instance为null，所以它执行LazyDclInstance = new LazyDCL();
c>由于JVM内部的优化机制，JVM先画出了一些分配给LazyDclInstance实例的空白内存，并赋值给LazyDclInstance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
d>B进入synchronized块，由于LazyDclInstance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
e>此时B线程打算使用LazyDclInstance实例，却发现它没有被初始化，于是错误发生了。
 */
public class LazyDCL {
	private static LazyDCL LazyDclInstance;
	private LazyDCL(){}
	//DCL 双重检验锁模式
	public static LazyDCL getInstance(){
		if(LazyDclInstance == null){
			synchronized(LazyDCL.class){
				if(LazyDclInstance == null){
					//此处是分两步执行的，创建对象和赋值
					 //但是JVM并不保证这两个操作的先后顺序（即jvm会进行指令重排序），也就是说有可能JVM会为新的LazyDclInstance实例分配空间，
					 //然后直接赋值给LazyDclInstance成员，然后再去初始化这个LazyDclInstance实例。这样就可能出错了
					LazyDclInstance = new LazyDCL();
				}
			}
		}
		return LazyDclInstance;
	}
}
