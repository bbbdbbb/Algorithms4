package dp.LIS;

import java.util.Scanner;

/**  计蒜客学习中心	最大字段和
 * 	跳木桩
 * 	https://www.jisuanke.com/course/6497/341116 
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LIS_04   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 上午10:03:54   
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
