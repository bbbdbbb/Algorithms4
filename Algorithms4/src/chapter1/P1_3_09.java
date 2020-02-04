package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_09   
* 类描述： 练习1.3.09,编写一段程序，从标准输入得到一个缺少左括号的表达式，
* 		并打印在出补全括号之后的中序表达式。
* 创建人：bbbdbbb   
* 创建时间：2020年2月3日 下午8:26:29   
* @version        
*/
public class P1_3_09 {

	public static void main(String[] args) {
		Stack<String> number = new Stack<>();//存储算式中的数字
		Stack<String> operator = new Stack<>();//存储算式中的运算符

		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			System.out.println(item);
			if(Character.isDigit(item.charAt(0))){//如果item是数字0~9，压入number栈
				number.push(item);				
			}else if("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)){
				//如果item是运算符，压入operator栈
				operator.push(item);
			}else if(")".equals(item) && number.size()>=2 && operator.size()>=1){//如果item是')'
				String second = number.pop();
				String first = number.pop();
				String newBracket = "("+first+operator.pop()+second+")";
				number.push(newBracket);
				
				System.out.println("打桩： 1新产生的括号表达式为 "+newBracket);
				
			}else{
				//输入数据不能够成一个完整的括号表达式
				System.out.println("数据错误！！！");
			}
			
		}
		if(number.size()==1){
			System.out.print("结果："+number.pop());
		}

	}

}
