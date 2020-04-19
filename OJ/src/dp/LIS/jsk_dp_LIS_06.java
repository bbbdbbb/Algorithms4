package dp.LIS;

import java.util.Scanner;

/** �����ѧϰ����	����ֶκ�
 * 	��ͷ������
 * 	https://www.jisuanke.com/course/6497/341118   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp_LIS_06   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��19�� ����2:47:04   
* @version        
*/
public class jsk_dp_LIS_06 {

	private static long[] ns;
	private static long[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new long[n+10];
		dp = new long[n+10];
		for(int i = 1; i <= n; i++){
			ns[i] = sc.nextLong();
			dp[i] = ns[i];
		}
		
		//lis
		long ans = 0;
		for(int i = 1; i <= n; i++){
			for(int j = i - 1; j >= 1; j--){
				if(ns[j] < ns[i]){
					dp[i] = Math.max(dp[i], dp[j] + ns[i]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
		
	}

}
