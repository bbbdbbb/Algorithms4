package practice.ssmn;

import java.util.Scanner;

/**   摆动序列
*    
* 项目名称：OJ   
* 类名称：H   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月18日 上午10:19:19   
* @version        
*/
public class H {

	private static int m;
	private static int n;
	private static int[][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		dp = new int[m+10][n+10];
		
		for(int j = 1; j <= n; j++){
			dp[1][j] = 1;
		}
		for(int i = 2; i <= m; i++){
			if(i % 2 == 0){//偶数项  a[i]<a[i-1]
				for(int j = 1; j <= n; j++){
					for(int k = j + 1; k <= n; k++){
						dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10000; 
					}
				}
			}else{//奇数项  a[i]>a[i-1]
				for(int j = 1; j <= n; j++){
					for(int k = 1; k < j; k++){
						dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10000; 
					}
				}
			}
		}
		
		int ans = 0;
		for(int j = 1; j <= n; j++){
			ans += dp[m][j];
		}
		System.out.println(ans % 10000);
	}

}
