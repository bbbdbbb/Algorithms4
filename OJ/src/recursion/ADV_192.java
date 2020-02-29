package recursion;

import java.util.Scanner;

/** �漰������ �ݹ��⣬Ч�ʲ��У���ʱ�ˣ���Ҫ�Ľ�
 * 
 * �㷨��� �������������
 * http://lx.lanqiao.cn/problem.page?gpid=T359  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_192   
* ��Ŀ������

	��һ�죬���������������з�����һ����ƽ�������ƽ����֣���n����õ����룬����û�����롣����Ϊ���ķ����˷ܲ��ѣ�
������׼��ȥ��һ���Լ��Ķ�������׼������m����Ʒȥ�ơ�������ǣ�����һ���֪����m����Ʒ�����������������뿴�������ƽ�ܲ��ܳƳ���Щ��Ʒ������
���Ƕ�����΢����1�����Ժ�;����������̫�����ˣ����ǾͶ������㡣

�����ʽ
������һ��Ϊ��������n��m��
�����ڶ���Ϊn��������ʾ��n�������������
����������Ϊm��������ʾ��m����Ʒ��������
�����ʽ
�������m�У����ڵ�i�У������i����Ʒ�ܱ��Ƴ������YES�������NO��

��������
4 2
1 2 4 8
15 16
�������
YES
NO

��������
4 1
10 7 1 19
6
�������
YES

* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��29�� ����3:51:00   
* @version        
*/
public class ADV_192 {
	public static int[] a;
	public static int[] sum;
	public static boolean flag;
	
	public static void main(String[] args) {
		

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		a = new int[n];
		sum = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
			if(i!=0){
				sum[i] = sum[i-1]+a[i];
			}else{
				sum[0] = a[0];
			}
		}
		
		while(m--!=0){
			long startMili=System.currentTimeMillis();
			int s = scan.nextInt();
			flag = false;
			if(s<=0)	System.out.println("NO");
			else{
				dfs(s,n-1);
				if(flag)	System.out.println("YES");
				else		System.out.println("NO");
			}
			long endMili=System.currentTimeMillis();
			System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");

		}
		
		
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��

	}

	private static void dfs(int s, int i) {

		if(flag)	return;
		if(i<0)		return;
		if(Math.abs(s)>sum[i])	return;
		
		if(s==0 || Math.abs(s)==sum[i]){
			flag = true;
			return;
		}
		
		if(i<0)		return;
		dfs(s-a[i],i-1);
		dfs(s,i-1);
		dfs(s+a[i],i-1);
		return;
	}

}
