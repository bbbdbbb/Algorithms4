package chapter1;

import collection.ResizingArrayStack;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_11_EvaluatePostfix   
* 类描述： 练习1.3.11,从标准输入得到一个后序表达式，求值并打印结果。
* 创建人：bbbdbbb   
* 创建时间：2020年2月5日 下午9:30:19   
* @version        
*/
public class P1_3_11_EvaluatePostfix {

	public static void main(String[] args) {
		Stack<String> number = new Stack<>();

		System.out.println("输入：");
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			System.out.print(item+"  ");
			
			if(Character.isDigit(item.charAt(0))){//item是数字
				number.push(item);
			}else if("+".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first+second+"");
			}else if("-".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first-second+"");
			}else if("*".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first*second+"");
			}else if("/".equals(item)){
				int second = Integer.parseInt(number.pop());
				int first = Integer.parseInt(number.pop());
				number.push(first/second+"");
			}else{
				System.out.println("\n输入的后序表达式不正确！！！");
			}			
		}
		
		if(!number.isEmpty())
			System.out.println("\n结果：\n"+number.pop());
	}
}
