package search.dfs;

import java.util.Arrays;
import java.util.Scanner;


/** ��֦����dfs���ܶ�ϸ�ڣ���Ҫ��ϸ���
 * �㷨ѵ�� Sticks
 * http://lx.lanqiao.cn/problem.page?gpid=T572  
*    
	���룺
9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
	�����
6
5

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_224_Sticks   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��5�� ����8:03:26   
* @version        
*/
public class ALGO_224_Sticks_cut {
	
	private static int n;//Сľ��������
	private static int[] s;//�����ȴ�С����洢ÿһ��Сľ���ĳ���
	private static int sum;//����Сľ���ĵĳ���֮��
	private static int max;//����� ľ������
	private static boolean[] vis;
	private static int parts;//��Ҫƴ�յ�ľ������

	
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		//n = scan.nextInt();//Сľ��������
		while((n=scan.nextInt()) != 0 ){
			s = new int[n];
			vis = new boolean[n];
//�Һ��������� sum ����ÿ��whileѭ����Ҫ��ֵΪ0�����µ�һ���Ժ�ļ������			
			sum = 0;				
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
			//n = scan.nextInt();
		}
		
		scan.close();
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
		
		//System.out.println("\nf() next="+next);

		if(len==max){//��ǰ����ƴ�յ�ľ���ĳ��� ���� �������²��ľ���ĳ���
			cpl++;//�ɹ�ƴ�յ�ľ��������һ
			len = 0;//����ƴ������һ��ľ�������Խ���ǰ����ƴ�յ�ľ���ĳ�����Ϊ0
			next = n-1;//��ͷ��ʼѡ��ľ��
		}
		
		if(cpl==parts){//��ǰƴ�ճɹ���ľ���������� ��Ԥ���ľ������
			return true;   //˵��  �����ɹ��������������Ż�true
		}
		
		while(next>=0){
			if(vis[next]==false){//��ǰľ��û��ѡ��
				
				if(len+s[next]<=max){//��ǰѡ�е�ľ��s[next]����ʹ��
					vis[next] = true;
					if(f(len+s[next],next-1,cpl)){
						return true;
					}
					
					vis[next] = false;
					
					//���ڱ�������ʧ��ʱ��len=0�����Ե�ǰ�ľ��Ϊ��һ��ľ�����޷����ʣ�µ�ľ������Ϊһ��������ľ��
					if(len == 0){
						break;
					}
					
					//len���ϵ�ǰ��ľ��s[next]����һ��������ľ�����������ľ�����ܳɹ�ƴ��
					if(len+s[next] == max){
						break;
					}										
				}
				
				//len+s[next] > max  ����ͬ�ȳ��ȵ�ľ��
				int i = next-1;
				while(i>=0 && s[next]==s[i]){
					i--;
				}
				next = i;// !!!ע�⣺     ������i = next-1;  ���� �� next = i;   �����и���������Ϣ����  next���ټ�һ,�Ѿ�����˸���
				
				//�ж�ʣ��ľ���ĳ���+��ǰ��ƴ�ճ���len �Ƿ����or����  max
				int rest = 0;
				while(i>=0){
					if(vis[i]==false){
						rest += s[i];
					}
					i--;
				}
				
				//ʣ��ľ���ĳ���+��ǰ��ƴ�ճ���len С�� max
				if(rest+len<max){
					break;
				}
				
				continue;//�����Ѿ�������next���������ֱ������while���������ִ�л�ʹ��next��һ
			}
			
			next--;
		}
		
		return false;	
		
	}

	
}
