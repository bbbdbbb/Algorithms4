package dp.bag;

import java.util.Scanner;

/**   
*    
* 项目名称：OJ   
* 类名称：_completeKnapsack_optm   
* 类描述：完全背包问题 的 空间优化   
* 创建人：bbbdbbb   
* 创建时间：2020年4月30日 下午9:54:56   
* @version        
*/
public class _completeKnapsack_optm {

	private static int[] ws;
	private static int[] vs;
	private static int[] dp;

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
		dp = new int[W+1];
		for(int i = 1; i <= N; i++){
			for(int j = ws[i]; j <= W; j++){
				dp[j] = Math.max(dp[j], dp[j-ws[i]] + vs[i]);
			}
		}
		
		//output
		System.out.println(dp[W]);
		
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