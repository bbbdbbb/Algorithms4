package dp.bag;

import java.util.Scanner;

/**   
*    
* 项目名称：OJ   
* 类名称：_completeKnapsack   
* 类描述： 完全背包的一般解法  
* 创建人：bbbdbbb   
* 创建时间：2020年4月30日 下午9:41:33   
* @version        
*/
public class _completeKnapsack {

	private static int[] ws;
	private static int[] vs;
	private static int[][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		ws = new int[N+1];
		vs = new int[N+1];
		for(int i = 1; i <= N; i++){
			ws[i] = sc.nextInt();
			vs[i] = sc.nextInt();
		}
		
		//dp
		dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int j = 0; j <= W; j++){
				dp[i][j] = dp[i-1][j];
				if(j >= ws[i]){
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-ws[i]] + vs[i]);
				}
			}
		}
		
		
		//output
		System.out.println(dp[N][W]);
	}

}
/*
---------------------
	input:
3 7
3 4
4 5
2 3
	output:
10
------------------------
	input:
4 5 
1 2 
2 4 
3 4
4 5
	output:
10
--------------------------- 
 */