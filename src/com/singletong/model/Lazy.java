package com.singletong.model;

/**
 * ����ģʽ�����̲߳���ʱ����ȫ����������ʵ��
 * ���û���һ�ε���ʱ��ʼ������Ȼ��Լ����Դ������һ�μ���ʱ��Ҫʵ��������ӳ����һЩ
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
