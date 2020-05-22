package com.singletong.model;
/**
 * 枚举单例 线程安全
 *枚举实例的创建是线程安全的，而且简单、方便，并且在任何情况下都是单例,防止反序列化创建新的对象,但是失去了一些类的特性，没有延迟加载，而且可读性较差
 *，但是大部分应用开发很少用枚举，可读性并不是很高，而且枚举单例不能被继承、重载、重写，所以不推荐使用
 */
public enum SingleTonEnum {
	SINGLEINSTANCE;
	private SingletonEnumClass singleton ;//定义单例对象
	private SingleTonEnum(){
		//构造器私有化，枚举类初始化的时候初始化单例对象
		singleton = new SingletonEnumClass();
	}
	public SingletonEnumClass getInstance(){//提供对外接口获取枚举单例
		return singleton;
	}
	public static void main(String[] args) {
		SingletonEnumClass c1 = SingleTonEnum.SINGLEINSTANCE.getInstance();
		SingletonEnumClass c2 = SingleTonEnum.SINGLEINSTANCE.getInstance();
		System.out.println(c1==c2);
	}
}
