package chapter1;

import collection.ResizingArrayQueue;
import edu.princeton.cs.algs4.StdIn;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_15   
* 类描述： 练习1.3.15,编写一个Queue的用例，接受一个命令行参数k并打印出标准输入中的倒数第k个字符串（假设标准输入中至少有k个字符串）。
* 创建人：bbbdbbb   
* 创建时间：2020年2月8日 下午4:39:15   
* @version        
*/
public class P1_3_15 {

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		
		ResizingArrayQueue<String> q = new ResizingArrayQueue<>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			q.enqueue(item);
		}
		
		if(k>q.size()){
			System.out.println("k超出队列长度！！！");
			System.exit(0);
		}
		
		int size = q.size();
		for(int i=0;i<size-k;i++){
			q.dequeue();
		}
		System.out.println(q.dequeue());
	}

}
