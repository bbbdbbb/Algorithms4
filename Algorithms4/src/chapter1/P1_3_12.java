package chapter1;

import collection.Stack;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_12   
* 类描述：  练习1.3.12,在Stack类中添加一个静态的copy()方法，接受一个字符串栈作为参数，并返回该栈的一个副本  
* 创建人：bbbdbbb   
* 创建时间：2020年2月6日 下午8:53:57   
* @version        
*/
public class P1_3_12 {

	public static void main(String[] args) {
		
		Stack<String> s1 = new Stack<String>();
		s1.push("元素a");
		s1.push("元素b");
		s1.push("元素c");
		//调用copy方法，以字符串栈s1为参数，得到s1的一个副本
		Stack<String> s2 = Stack.copy(s1);
		
		System.out.print("s1: ");
		for(String s : s2){
			System.out.print(s+" ");
		}
		System.out.print("\ns2: ");
		for(String s : s2){
			System.out.print(s+" ");
		}
	}

}
