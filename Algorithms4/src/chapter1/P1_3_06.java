package chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_06   
* 类描述：练习1.3.06,判断代码的作用   :反转队列q中所有元素的顺序
* 创建人：bbbdbbb   
* 创建时间：2020年2月3日 下午3:56:15   
* @version        
*/
public class P1_3_06 {

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		for(int i=0;i<10;i++){
			q.enqueue(""+i);
		}
		System.out.print("程序开始前队列q中的元素：");
		for(String s : q){
			System.out.print(s+"  ");
		}
		
		Stack<String> stack = new Stack<String>();
		while(!q.isEmpty()){
			stack.push(q.dequeue());
		}
		while(!stack.isEmpty()){
			q.enqueue(stack.pop());
		}
		System.out.print("\n程序结束后队列q中的元素：");
		for(String s : q){
			System.out.print(s+"  ");
		}
		
	}

}
