package dp.LCS;

import java.util.Scanner;

/** 计蒜客学习中心    最长公共子序列和编辑距离
 * 	回文串
 * 	https://www.jisuanke.com/course/6497/341120  
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LCS_02   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 下午5:33:37   
* @version        
*/
public class jsk_dp_LCS_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] a = str.toCharArray();
		int n = a.length;
		char[] b = new char[n];
		for(int i = 0; i < n; i++){
			b[i] = a[n-i-1];
		}
		
		int[][] dp = new int[n+1][n+1];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(a[i] == b[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
				}else{
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		System.out.println(n - dp[n][n]);
	}

}
