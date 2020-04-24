package dp.LCS;

import java.util.Scanner;

/** 计蒜客学习中心    最长公共子序列和编辑距离
 * 	蒜头君的日志
 * 	https://www.jisuanke.com/course/6497/341121  
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LCS_03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 下午5:45:00   
* @version        
*/
public class jsk_dp_LCS_03 {

	private static int[] ns;
	private static int[] ms;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ns = new int[n+1];
		ms = new int[m+1];		
		for(int i = 1; i <= n; i++){
			ns[i] = sc.nextInt();
		}
		for(int i = 1; i <= m; i++){
			ms[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++){
			int max = 0;
			for(int j = 1; j <= m; j++){
				dp[i][j] = dp[i-1][j];
				if(ns[i] > ms[j] && max < dp[i-1][j]){
					max = dp[i-1][j];
				}else if(ns[i] == ms[j]){
					dp[i][j] = max + 1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= m; i++){
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
		
	}
}
