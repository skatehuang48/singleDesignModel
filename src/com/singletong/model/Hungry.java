package com.singletong.model;

/**
 * ����ģʽ��
 * ���ַ�ʽ�������ʱ������˳�ʼ������������ؽ���������ȡ������ٶȿ졣
 *  ���ַ�ʽ��������ػ��Ʊ����˶��̵߳�ͬ�����⣬����ʼ��instanceû�дﵽ�����ص�Ч����
 * �̰߳�ȫ
 * @author Administrator
 *
 */
public class Hungry {

	private static Hungry hungryInstance = new Hungry();
	
	/**
	 * ������˽�л�����ֹ���������ʵ����
	 */
	private Hungry(){
		
	}
	
	public static Hungry getInstance(){
		return hungryInstance;
	}
}
