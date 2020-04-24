package dp.LCS;

import java.util.Scanner;

/** 计蒜客学习中心    最长公共子序列和编辑距离
 * 	蒜头君的秘密文件(将str1转化为str2需要的最少步骤)	
 * 	https://www.jisuanke.com/course/6497/341122
 * 	   
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LCS_04   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 下午9:52:32   
* @version        
*/
public class jsk_dp_LCS_04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		
		int n = a.length;
		int m = b.length;
		int[][] dp = new int [n+1][m+1];
		for(int k = 1; k <= n; k++){
			dp[k][0] = k;
		}
		for(int k = 1; k <= m; k++){
			dp[0][k] = k; 
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(a[i-1] == b[j-1]){
					dp[i][j] = dp[i-1][j-1]; 
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
	}

}
