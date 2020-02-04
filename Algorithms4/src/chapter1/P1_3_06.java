package chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**   
*    
* ��Ŀ���ƣ�Algorithms4   
* �����ƣ�P1_3_06   
* ����������ϰ1.3.06,�жϴ��������   :��ת����q������Ԫ�ص�˳��
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��3�� ����3:56:15   
* @version        
*/
public class P1_3_06 {

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		for(int i=0;i<10;i++){
			q.enqueue(""+i);
		}
		System.out.print("����ʼǰ����q�е�Ԫ�أ�");
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
		System.out.print("\n������������q�е�Ԫ�أ�");
		for(String s : q){
			System.out.print(s+"  ");
		}
		
	}

}
