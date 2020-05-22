package com.singletong.model;

/**
 * ��̬�ڲ��൥��ģʽ �̰߳�ȫ���Ƽ�ʹ�ã�ʵ��������ģʽ��
 * ��һ�μ���SingletonStatic��ʱ�������ʼ����
 * ֻ�е�һ�ε���getInstance����ʱ��������ؾ�̬�ڲ���SingletonFactory ����ʼ��singleInstance ��
 * ����������ȷ���̰߳�ȫҲ�ܱ�֤SingletonStatic���Ψһ�ԣ������Ƽ�ʹ�þ�̬�ڲ��൥��ģʽ��
 */
public class SingletonStatic {
	private SingletonStatic(){}
	
	//��̬�ڲ���
	private static class SingletonFactory{
		private static final SingletonStatic singleInstance = new SingletonStatic();
	}
	
	public static SingletonStatic getInstance(){
		return SingletonFactory.singleInstance;
	}
}
