package dp.unknow;

import java.util.Scanner;

/** �����ѧϰ�� ��̬�滮����
 * 	ǽ��Ϳɫ
 * 	https://www.jisuanke.com/course/6497/341111
 * 	   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp08   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��16�� ����11:11:05   
* @version        
*/
public class jsk_dp08 {

	private static long[][] dp;
	private static int[] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//����dp������
		f = new int[n+10];
		f[1] = 3;
		f[2] = 6;
		f[3] = 6;
		for(int i = 4; i <= n; i++){
			f[i] = f[i-1] + f[i-2] * 2;
		}
		System.out.println(f[n]);
		
		/*
		 * �Լ���ķ�����
		 * �Ƚ���һ��ǽ����Ϊ��һ����ɫ 1 (ʲô��ɫ�����ԣ������*3)
		 * ��ô�ڶ���ǽֻ������Ϊ��ɫ 2 �� 3 (1 -> 2,3)
		 * ����������ǽ��������Ϊ 1,3,1,2 (2 -> 1,3   3 -> 1,2)  
		 * 
		 * ���ɣ�
		 * ��i��ǽ��������Ϊ��ɫ1����ɫ��1
		 * i����ɫ1 = i-1 ����ɫ��1�ĺ�
		 * i����ɫ��1 = i-1 ����ɫ1�ĺ� ����2 �ټ�����ɫ��һ�ĺ�
		 */
//		dp = new long[n+10][2];
//		dp[1][0] = 0;
//		dp[1][1] = 1;
//		for(int i = 2; i <= n; i++){
//			dp[i][0] = dp[i-1][1] * 2 + dp[i-1][0];
//			dp[i][1] = dp[i-1][0];
//		}
//		
//		if(n <= 1){
//			System.out.println(3);
//		}else{
//			System.out.println(dp[n][0] * 3);
//		}
		
	}

}
