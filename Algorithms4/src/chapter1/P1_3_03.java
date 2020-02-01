package chapter1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 
 * ��Ŀ���ƣ�Algorithms4 
 * �����ƣ�P1_3_03 
 * ����������ϰ1.3.03,�жϳ�ջ˳���Ƿ���ȷ ��ջ�����Ὣ����0��9��˳��ѹ��ջ��
 * 		     ��ջ�������ӡ������ֵ�� �������������ǲ����ܲ����ģ� 
 * �����ˣ�bbbdbbb 
 * ����ʱ�䣺2020��1��31�� ����9:16:15
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
		Queue<Integer>[] a = (Queue<Integer>[]) new Queue[N];
		int i = 0;
		for(int j=0;j<N;j++){
			a[j] = new Queue<Integer>();
		}

		//��ȡ����
		for (;i<N; i++) {
			for(int j=0;j<10;j++){
				if (!StdIn.isEmpty()) {
					int item = StdIn.readInt();
					
					a[i].enqueue(item);
				}else{
					System.out.println("�������ݴ��󣡣���");
					System.exit(0);
				}	
			}					
		}
		
		//�ж�
		for(int j=0;j<N;j++){
			//�ȴ�ӡ ��Ŀ�������ĳ�ջ����
			for(int num : a[j]){
				System.out.print(num+"  ");
			}

			boolean bigFlag = true;		
			//�ж�
			while(!a[j].isEmpty()){
				Queue<Integer> temp = new Queue<Integer>();
				int number = a[j].dequeue();//��ջ���ó���һ����number
				for(int num : a[j]){//��ջ�����б�numberС����ѹ�루���ƣ���tempջ��
					if(number > num){
						temp.enqueue(num);
					}
				}
				//�жϱ�numberС�����Ƿ�����
				boolean flag = true;
				while(!temp.isEmpty()){
					int t = temp.dequeue();
					if(number<t){
						flag = false;
						break;
					}
					number = t;
				}
				if(flag==false){
					bigFlag = false;
					System.out.println(bigFlag);
					break;
				}
			}
			
			if(bigFlag==true){
				System.out.println(bigFlag);
			}
		}

	}
}
