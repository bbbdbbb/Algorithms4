package recursion;

import java.util.Scanner;

/** 
 * �㷨ѵ�� ���ӷ�ƻ��
 * http://lx.lanqiao.cn/problem.page?gpid=T302  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_121   
* ��Ŀ������  ����
* 		���쵽�ˣ�nֻ���Ӳ�ժ��һ���ƻ���ŵ�ɽ���Լ���ڶ���ƽ�֡���Щ���Ӻܳ�ݺ�������գ����Զ��������һЩƻ����
* 		��һֻ������������ɽ������ƻ��ƽ���ֳ�n�ݣ���ʣ�µ�m��ƻ������,Ȼ�������һ�ݣ�����ʣ�µ�ƻ�����º���һ��
* 		��Щ����������������ɽ��������ͬ���Ĳ�����ǡ��ÿ�ζ�ʣ����m��ƻ�����ڶ��죬��Щ��������ɽ������ʣ�µ�ƻ���ֳ�n�֣�
* 		���ˣ�����ʣ����m�����ʣ�ԭ����Щ�������ٲ��˶��ٸ�ƻ���� 
** ����
*��������
	> 5 1
*�������
	> 15621	
* 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��27�� ����9:35:35   
* @version        
*/
public class ALGO_121 {
	/**
	 * ����һ�����������ڵ��ǵ����ӷ���������
	 * https://wenku.baidu.com/view/d0adc98f680203d8ce2f2455.html
	 * https://blog.csdn.net/Z_122113/article/details/104456530
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int sum = (int) (Math.pow(n, n+1) - (n-1)*m);
		
		System.out.print(sum);

	}
}
