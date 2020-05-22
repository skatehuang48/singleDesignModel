package com.singletong.model;
/**
 * ö�ٵ��� �̰߳�ȫ
 *ö��ʵ���Ĵ������̰߳�ȫ�ģ����Ҽ򵥡����㣬�������κ�����¶��ǵ���,��ֹ�����л������µĶ���,����ʧȥ��һЩ������ԣ�û���ӳټ��أ����ҿɶ��Խϲ�
 *�����Ǵ󲿷�Ӧ�ÿ���������ö�٣��ɶ��Բ����Ǻܸߣ�����ö�ٵ������ܱ��̳С����ء���д�����Բ��Ƽ�ʹ��
 */
public enum SingleTonEnum {
	SINGLEINSTANCE;
	private SingletonEnumClass singleton ;//���嵥������
	private SingleTonEnum(){
		//������˽�л���ö�����ʼ����ʱ���ʼ����������
		singleton = new SingletonEnumClass();
	}
	public SingletonEnumClass getInstance(){//�ṩ����ӿڻ�ȡö�ٵ���
		return singleton;
	}
	public static void main(String[] args) {
		SingletonEnumClass c1 = SingleTonEnum.SINGLEINSTANCE.getInstance();
		SingletonEnumClass c2 = SingleTonEnum.SINGLEINSTANCE.getInstance();
		System.out.println(c1==c2);
	}
}
