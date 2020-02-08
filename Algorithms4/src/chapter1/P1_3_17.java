package chapter1;

import collection.Transaction;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_17   
* 类描述： 练习1.3.17,为Transaction类完成练习1.3.16  
* 创建人：bbbdbbb   
* 创建时间：2020年2月8日 下午9:02:39   
* @version        
*/
public class P1_3_17 {
	//答案在 collection包中的Transaction类
	//Transaction类的大部分内容我是复制作者的开源在网上的代码：
	//https://algs4.cs.princeton.edu/12oop/Transaction.java.html
	
	//在作者的实现代码最后面添加了readTransactions()方法，和测试案例
	
	//readTransactions()方法
//	public static Transaction[] readTransactions(String fileName){
//		In in = new In(fileName);
//		Queue<String> q = new Queue<String>();
//		while(!in.isEmpty())
//			q.enqueue(in.readLine());
//		
//		int N = q.size();
//		Transaction[] a = new Transaction[N];
//		for(int i=0;i<N;i++){
//			a[i] = new Transaction(q.dequeue());
//		}
//		return a;
//	}
	
	//测试案例
	   public static void main(String[] args) {
	    	Transaction[] transactions = Transaction.readTransactions("test-data\\Transaction_file.txt");
			for(int i=0;i<transactions.length;i++){
				System.out.println(transactions[i]);
			}
	    }

}
