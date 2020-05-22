package com.singletong.model;
/**
 * ����ģʽ��DCL��˫�ؼ������ʵ�ֵ���  ���������������̰߳�ȫ������С�����̲߳���ȫ
 ��synchronized�ؼ��ּ������ڲ���Ҳ����˵�����õ�ʱ���ǲ���Ҫ�����ģ�ֻ����instanceΪnull��
 �����������ʱ�����Ҫ������������һ�������������ǣ�����������������п���������ģ�
 �������������̲߳���ȫԭ�򣩣���Javaָ���д�������͸�ֵ�����Ƿֿ����еģ�
 Ҳ����˵LazyDclInstance = new LazyDCL();����Ƿ�����ִ�е�
 ������JVM������֤�������������Ⱥ�˳��Ҳ����˵�п���JVM��Ϊ�µ�Singletonʵ������ռ䣬
 Ȼ��ֱ�Ӹ�ֵ��instance��Ա��Ȼ����ȥ��ʼ�����Singletonʵ���������Ϳ��ܳ����ˣ�������A��B�����߳�Ϊ����
a>A��B�߳�ͬʱ�����˵�һ��if�ж�
b>A���Ƚ���synchronized�飬����instanceΪnull��������ִ��LazyDclInstance = new LazyDCL();
c>����JVM�ڲ����Ż����ƣ�JVM�Ȼ�����һЩ�����LazyDclInstanceʵ���Ŀհ��ڴ棬����ֵ��LazyDclInstance��Ա��ע���ʱJVMû�п�ʼ��ʼ�����ʵ������Ȼ��A�뿪��synchronized�顣
d>B����synchronized�飬����LazyDclInstance��ʱ����null������������뿪��synchronized�鲢��������ظ����ø÷����ĳ���
e>��ʱB�̴߳���ʹ��LazyDclInstanceʵ����ȴ������û�б���ʼ�������Ǵ������ˡ�
 */
public class LazyDCL {
	private static LazyDCL LazyDclInstance;
	private LazyDCL(){}
	//DCL ˫�ؼ�����ģʽ
	public static LazyDCL getInstance(){
		if(LazyDclInstance == null){
			synchronized(LazyDCL.class){
				if(LazyDclInstance == null){
					//�˴��Ƿ�����ִ�еģ���������͸�ֵ
					 //����JVM������֤�������������Ⱥ�˳�򣨼�jvm�����ָ�������򣩣�Ҳ����˵�п���JVM��Ϊ�µ�LazyDclInstanceʵ������ռ䣬
					 //Ȼ��ֱ�Ӹ�ֵ��LazyDclInstance��Ա��Ȼ����ȥ��ʼ�����LazyDclInstanceʵ���������Ϳ��ܳ�����
					LazyDclInstance = new LazyDCL();
				}
			}
		}
		return LazyDclInstance;
	}
}
