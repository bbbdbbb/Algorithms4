package chapter1;

import collection.ResizingArrayQueue;
import edu.princeton.cs.algs4.StdIn;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_15   
* �������� ��ϰ1.3.15,��дһ��Queue������������һ�������в���k����ӡ����׼�����еĵ�����k���ַ����������׼������������k���ַ�������
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��8�� ����4:39:15   
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
			System.out.println("k�������г��ȣ�����");
			System.exit(0);
		}
		
		int size = q.size();
		for(int i=0;i<size-k;i++){
			q.dequeue();
		}
		System.out.println(q.dequeue());
	}

}
