package recursion;

import java.util.Scanner;

/**   
* http://lx.lanqiao.cn/problem.page?gpid=T303   
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_122   
* ��������   ����ĵݹ���
* 	ÿ�����ϣ���Ь���ڶ����������������л�Ь��m��������Ҫ��Ь��n�������ڵ������ǣ���Щ���ж������ŷ���
* 	���Ա������������û�б�Ь��������γ��档������ͬ��������ˣ����綼����Ь���ǻ�Ь������λ����ͬһ���ŷ���
* ����(1)
*��������(1)
	�� 3 2
*�������(1)
	�� 5	
* 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��26�� ����5:35:54   
* @version        
*/
public class ALGO_122 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		int sum = count(m,n);
		System.out.print(sum);
	}

	
	private static int count(int m, int n) {
		
		if(m<n || m<0 || n<0)	return 0;
		if(m==1 && n==0) return 1;
		if(m==1 && n==1) return 1;		
		
		
		return count(m-1,n)+count(m,n-1);
	}


}
