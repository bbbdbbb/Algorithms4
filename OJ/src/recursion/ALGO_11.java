package recursion;

import java.util.Scanner;

/**   
 * �㷨ѵ�� ��ש�̷�
 * http://lx.lanqiao.cn/problem.page?gpid=T55
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_11   
* ��������һ���򵥵ĵݹ���
* 
   ����һ����ΪN(1<=��<=10)�ĵذ壬�������ֲ�ͬ��ש��һ�ֳ���Ϊ1����һ�ֳ���Ϊ2����Ŀ���ޡ�Ҫ���������ΪN�ĵذ�������һ���ж����ֲ�ͬ���̷���
�������磬����Ϊ4�ĵ���һ��������5���̷���
����4=1+1+1+1
����4=2+1+1
����4=1+2+1
����4=1+1+2
����4=2+2
*
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��28�� ����8:05:26   
* @version        
*/
public class ALGO_11 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int end = f(n);
		
		System.out.print(end);

	}

	private static int f(int n) {
		
		if(n==1)		return 1;
		else if(n==2)	return 2;
		else			return f(n-1)+f(n-2);
	}

}
