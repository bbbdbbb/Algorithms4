package chapter1;

import collection.Transaction;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_17   
* �������� ��ϰ1.3.17,ΪTransaction�������ϰ1.3.16  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��8�� ����9:02:39   
* @version        
*/
public class P1_3_17 {
	//���� collection���е�Transaction��
	//Transaction��Ĵ󲿷��������Ǹ������ߵĿ�Դ�����ϵĴ��룺
	//https://algs4.cs.princeton.edu/12oop/Transaction.java.html
	
	//�����ߵ�ʵ�ִ�������������readTransactions()�������Ͳ��԰���
	
	//readTransactions()����
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
	
	//���԰���
	   public static void main(String[] args) {
	    	Transaction[] transactions = Transaction.readTransactions("test-data\\Transaction_file.txt");
			for(int i=0;i<transactions.length;i++){
				System.out.println(transactions[i]);
			}
	    }

}
