package com.singletong.model;

/**
 * ˫�ؼ�����̰߳�ȫģʽ���ӹؼ���volatile(jvm��ָֹ��������)����ʵ��������
 * ��lazyDCLSafeInstance����Ϊvoliate��������lazyDCLSafeInstance ʵ�����ĵ�һʱ���д��ϵͳ�ڴ棬
 * ��ֹ�߳�1ִ����ͬ��������û�м�ʱ��дlazyDCLSafeInstance�������߳�2�ж�lazyDCLSafeInstance==nullʱ����ȡ�����ݻ��Ǿɵ�����
 * �̰߳�ȫ
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
