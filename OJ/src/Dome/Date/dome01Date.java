package Dome.Date;

import java.util.Date;
/**
 * Java���ֱ����������ʱ���йص��ࣺ
 * ��1�����ڱ�ʾʱ����Date��
 * ��2�����ڱ�ʾ������LocalDate��
*    
*   ��1��java.util.Date
*   		�� Date ��ʾ�ض���˲�䣬��ȷ�����롣 
*   		1 �� = 24 �� 60 �� 60 = 86400 �� 
*   		1��  = 1000����
*   		1��  = 86400000����
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�dome01Date   
* ��������Date���dome   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��22�� ����7:41:29   
* @version
 */
public class dome01Date {

	public static void main(String[] args) {

		//dome01();
		dome02();
		dome03();
	}

	
	/*
	 * Date��� getTime()����
	 * ����ǰData����ת���ɺ���ֵ����1970��1��1��Ϊԭ�㣩
	 */
	private static void dome03() {

		System.out.println("dome03:");
		
		Date date = new Date();
		System.out.println(date.getTime());
	}

	/*
	 * Date����вι��췽��������һ��long���͵ĺ���ֵ
	 * Date��Ὣ����ĺ���ֵ ��1970��1��1�տ�ʼ���㣬ת������Ӧ������
	 */
	private static void dome02() {

		System.out.println("dome02:");
		
		Date someday = new Date(0L);
		System.out.println(someday);
	}

	/*
	 * Date����޲������췽�����Ե�ǰʱ��㴴��һ���¶���
	 */
	private static void dome01() {
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());

	}

}
