package chapter1;

import collection.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_02   
* ����������ϰ1.3.02,��һ���µ����룬����P84��main����   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��1��31�� ����8:51:02   
* @version        
*/
public class P1_3_02 {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty()){
				StdOut.print(s.pop()+"  ");
			}
			
		}
		StdOut.println("\nʣ�µ�Ԫ��������"+s.size());
	}
}
