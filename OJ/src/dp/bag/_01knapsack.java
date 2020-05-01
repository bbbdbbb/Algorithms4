package dp.bag;

import java.util.Scanner;

/** 
*    
* 项目名称：OJ   
* 类名称：_01knapsack   
* 类描述：01背包问题   的解法   
* 创建人：bbbdbbb   
* 创建时间：2020年4月30日 下午5:29:15   
* @version        
*/
public class _01knapsack {

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
				if(ws[i] <= j){
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-ws[i]] + vs[i]);
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
4 5
2 3
1 2
3 4
2 2
	output:
7
------------------------
	input:
4 5 
1 2 
2 4 
3 4
4 5
	output:
8
--------------------------- 
 */