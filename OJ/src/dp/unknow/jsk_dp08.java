package dp.unknow;

import java.util.Scanner;

/** 计蒜客学习中 动态规划基础
 * 	墙壁涂色
 * 	https://www.jisuanke.com/course/6497/341111
 * 	   
*    
* 项目名称：OJ   
* 类名称：jsk_dp08   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月16日 上午11:11:05   
* @version        
*/
public class jsk_dp08 {

	private static long[][] dp;
	private static int[] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//官网dp方法：
		f = new int[n+10];
		f[1] = 3;
		f[2] = 6;
		f[3] = 6;
		for(int i = 4; i <= n; i++){
			f[i] = f[i-1] + f[i-2] * 2;
		}
		System.out.println(f[n]);
		
		/*
		 * 自己想的方法：
		 * 先将第一块墙设置为第一个颜色 1 (什么颜色都可以，最后结果*3)
		 * 那么第二块墙只能设置为颜色 2 和 3 (1 -> 2,3)
		 * 继续第三块墙可以设置为 1,3,1,2 (2 -> 1,3   3 -> 1,2)  
		 * 
		 * 规律：
		 * 第i块墙可以设置为颜色1和颜色非1
		 * i的颜色1 = i-1 的颜色非1的和
		 * i的颜色非1 = i-1 的颜色1的和 乘以2 再加上颜色非一的和
		 */
//		dp = new long[n+10][2];
//		dp[1][0] = 0;
//		dp[1][1] = 1;
//		for(int i = 2; i <= n; i++){
//			dp[i][0] = dp[i-1][1] * 2 + dp[i-1][0];
//			dp[i][1] = dp[i-1][0];
//		}
//		
//		if(n <= 1){
//			System.out.println(3);
//		}else{
//			System.out.println(dp[n][0] * 3);
//		}
		
	}

}
