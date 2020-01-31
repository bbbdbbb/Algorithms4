package chapter1;

import collection.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_02   
* 类描述：练习1.3.02,给一组新的输入，调试P84的main方法   
* 创建人：bbbdbbb   
* 创建时间：2020年1月31日 下午8:51:02   
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
		StdOut.println("\n剩下的元素数量："+s.size());
	}
}
