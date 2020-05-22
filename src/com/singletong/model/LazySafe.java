package com.singletong.model;

/**
 * ����ģʽ ���� �̰߳�ȫ ��Ч�ʵ� �������ڷ����ϣ����߳�ÿ��ִ�ж��Ǵ��в��ǲ���������Ч�ʵ��£�
 * ����д���ܹ��ڶ��߳��кܺõĹ���������ÿ�ε���getInstance����ʱ����Ҫ����ͬ����
 * ��ɲ���Ҫ��ͬ�����������Ҵ󲿷�ʱ���������ò���ͬ���ģ����Բ�����������ģʽ��
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
