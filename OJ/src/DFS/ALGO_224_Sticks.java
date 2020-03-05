package DFS;

import java.util.Arrays;
import java.util.Scanner;

/** ������  ��������  �� ���س�ʱ����Ҫ��֦
 * �㷨ѵ�� Sticks
 * http://lx.lanqiao.cn/problem.page?gpid=T572  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_224_Sticks   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��5�� ����8:03:26   
* @version        
*/
public class ALGO_224_Sticks {
	
	private static int n;//Сľ��������
	private static int[] s;//�����ȴ�С����洢ÿһ��Сľ���ĳ���
	private static int sum;//����Сľ���ĵĳ���֮��
	private static int max;//����� ľ������
	private static boolean[] vis;
	private static int parts;//��Ҫƴ�յ�ľ������

	
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();//Сľ��������
		while(n!=0){
			s = new int[n];
			vis = new boolean[n];
			sum = 0;				//�Һ�����������µ�һ���Ժ�ļ������
			for(int i=0;i<n;i++){
				s[i] = scan.nextInt();//�ȴ洢��һ��������
				sum += s[i];
			}
			Arrays.sort(s);//���򣬳�����С����
			max = s[n-1];//�Ȳ²�ľ���ĳ��ȵ����ľ���ĳ��ȣ����𲽼�һ���ж��Ƿ���������


			for(;max<=sum;max++){
				if(sum%max==0){
					parts = sum/max;
					
					if(f(0,n-1,0)){
						System.out.println(max);
						break;
					}
				}
			}

			//System.out.println("\nn="+n);
			n = scan.nextInt();
		}
		
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

	
	/**
	 * @param len	��¼��ǰ���ڴյ�ľ���ĳ���
	 * @param next	��һ��ľ����Ҫ�жϵ�����
	 * @param cpl	�ɹ�ƴ�յ�ľ������
	 * @return
	 */
	private static boolean f(int len,int next, int cpl) {
		
		System.out.println("\nf() next="+next);

		if(len==max){//��ǰ����ƴ�յ�ľ���ĳ��� ���� �������²��ľ���ĳ���
			cpl++;//�ɹ�ƴ�յ�ľ��������һ
			len = 0;//����ƴ������һ��ľ�������Խ���ǰ����ƴ�յ�ľ���ĳ�����Ϊ0
			next = n-1;//��ͷ��ʼѡ��ľ��
		}
		
		if(cpl==parts){//��ǰƴ�ճɹ���ľ���������� ��Ԥ���ľ������
			return true;   //˵��  �����ɹ��������������Ż�true
		}
		
		while(next>=0){
			if(!vis[next]){
				if(len+s[next]<=max){//��ǰѡ�е�ľ��s[next]����ʹ��
					vis[next] = true;
					if(f(len+s[next],next-1,cpl)){
						return true;
					}
					
					vis[next] = false;
				}
			}
			
			next--;
		}
		
		return false;	
		
	}

}
