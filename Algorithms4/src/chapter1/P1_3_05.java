package chapter1;

import edu.princeton.cs.algs4.Stack;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_05   
* ����������ϰ1.3.05,��������N����ӡN�Ķ����Ʊ�ʾ
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��1�� ����9:23:34   
* @version        
*/
public class P1_3_05 {
	public static void main(String[] args) {
		info(50);
		info(127);
		info(521);
		info(2020);
		info(2019);
	}
	
	public static void info(int N){
		System.out.print("N = "+N+" = ");
		Stack<Integer> stack = new Stack<>();
		while(N>0){
			stack.push(N%2);
			N=N/2;
		}
		for(int d : stack){
			System.out.print(d);
		}
		System.out.println();
	}

}