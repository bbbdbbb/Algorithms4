package dp.LCS;

import java.util.Scanner;

/** 计蒜客学习中心    最长公共子序列和编辑距离
 * 	最长公共子序列
 * 	https://www.jisuanke.com/course/6497/341119  
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LCS_01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 下午4:37:17   
* @version        
*/
public class jsk_dp_LCS_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		int[][] dp = new int[a.length + 10][b.length + 10];
		
		int n = a.length;
		int m = b.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(a[i] == b[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
				}else{
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
	}

}
