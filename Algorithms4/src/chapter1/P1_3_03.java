package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 
 * ��Ŀ���ƣ�Algorithms4 �����ƣ�P1_3_03 ����������ϰ1.3.03,�жϳ�ջ˳���Ƿ���ȷ ��ջ�����Ὣ����0��9��˳��ѹ��ջ��
 * ��ջ�������ӡ������ֵ�� �������������ǲ����ܲ����ģ� �����ˣ�bbbdbbb ����ʱ�䣺2020��1��31�� ����9:16:15
 * 
 * @version
 */
public class P1_3_03 {
	/**
	 * �⵽�����ֱ���жϣ������뵽��Ҫ�μ����ű�����������һ�����֣��� �ʹ���ʹ�ô������ж������ĳ�ջ˳���Ƿ���ȷ
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int N = 8;// ����:����
		// ����һ������ջ������
		Stack<Integer>[] a = (Stack<Integer>[]) new Stack[N];
		int i = 0;
		for(int j=0;j<N;j++){
			a[j] = new Stack<Integer>();
		}
		//System.out.print(a[0].isEmpty());
		for (;i<N; i++) {
			for(int j=0;j<10;j++){
				if (!StdIn.isEmpty()) {
					int item = StdIn.readInt();
					
					a[i].push(item);
				}else{
					System.out.println("�������ݴ��󣡣���");
					System.exit(0);
				}	
			}
					
		}
		
		for(int j=0;j<N;j++){
			for(int num : a[j]){
				System.out.print(num+"  ");
			}
			System.out.println();
		}

	}
}
