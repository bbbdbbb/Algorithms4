package Dome.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * DateFormat ������/ʱ���ʽ������ĳ����࣬�����������޹صķ�ʽ��ʽ�����������ڻ�ʱ�䡣
 * ����/ʱ���ʽ�����ࣨ�� SimpleDateFormat��������и�ʽ����Ҳ�������� -> �ı������������ı�-> ���ڣ��ͱ�׼����  
 * 
 * DateFormat ֻ��һ�������࣬��Ҫʹ����������SimpleDateFormat ����������
 * 		y  �� 
 * 		M  ���е��·�  
 * 		w  ���е�����  
 * 		D  ���е�����  
 * 		d  �·��е����� 
 * 		E  �����е�����  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�dome03DateFormat   
* �������� java.text.DateFormat  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��22�� ����8:09:20   
* @version        
*/
public class dome03DateFormat {

	public static void main(String[] args) throws ParseException {

		dome01();
		
		dome02();
	}

	
	/*
	 * ʹ��DateFormat���еķ���parse�����ı� ��ʽת��Ϊ ����
	 * ʹ�ò��裺
	 * 	1.����SimpleDateFormat�����ڹ��췽���д���ָ����ģʽ
	 *  2.����SimpleDateFormat�����еķ���parse���ѷ��Ϲ��췽����ģʽ���ַ���  ����ΪDate����
	 *  ע�⣺
	 *  	parse����������һ���쳣-->ParseException,if�ַ��������Ϲ��췽����ģʽ�����׳��쳣
	 */
	private static void dome02() throws ParseException {
		System.out.println("dome02:����DateFormat���еķ���parse()");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��   HHʱmm��ss��");
	
		String dStr = "2020��03��22��   20ʱ21��20��";
		Date date = sdf.parse(dStr);
		System.out.println(date);
		System.out.println(dStr);
	}


	/*
	 * ʹ��DateFormat���еķ���format�������ڸ�ʽת��Ϊ�ı�
	 * ʹ�ò��裺
	 * 	1.����SimpleDateFormat�����ڹ��췽���д���ָ����ģʽ
	 *  2.����SimpleDateFormat�����еķ���format�����շ�����ָ����ģʽ����Date���ڸ�ʽ������ģʽ���ַ���
	 */
	private static void dome01() {

		System.out.println("dome01:����DateFormat���еķ���format()");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��   HHʱmm��ss��");
	
		Date date = new Date();
		String dStr = sdf.format(date);
		System.out.println(date);
		System.out.println(dStr);
	}

}
