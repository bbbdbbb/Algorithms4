package dp.LIS;

import java.util.Scanner;

/**  �����ѧϰ����	����ֶκ�
 * 	��ľ׮
 * 	https://www.jisuanke.com/course/6497/341116 
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp_LIS_04   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��19�� ����10:03:54   
* @version        
*/
public class jsk_dp_LIS_04 {

	private static int[] ns;
	private static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n+10];
		for(int i = 1; i <= n; i++){
			ns[i] = sc.nextInt();
		}
		
		int ans = 0;
		dp = new int[n+10];
		//dp[n] = 1;
		for(int i = n; i >= 1; i--){
			for(int j = i + 1; j <= n; j++){
				if(ns[j] <= ns[i]){
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i]++;
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}

}
