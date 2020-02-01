package chapter1;

import edu.princeton.cs.algs4.Stack;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_05   
* 类描述：练习1.3.05,输入整数N，打印N的二进制表示
* 创建人：bbbdbbb   
* 创建时间：2020年2月1日 下午9:23:34   
* @version        
*/
public class P1_3_05 {
	public static void main(String[] args) {
		int N = 50;
		Stack<Integer> stack = new Stack<>();
		while(N>0){
			stack.push(N%2);
			N=N/2;
		}
		for(int d : stack){
			System.out.print(d);
		}
	}

}
