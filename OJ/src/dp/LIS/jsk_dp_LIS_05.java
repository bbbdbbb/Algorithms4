package dp.LIS;

import java.util.Scanner;

/** 计蒜客学习中心	最大字段和
 * 	删除最少的元素
 * 	https://www.jisuanke.com/course/6497/341117  
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LIS_05   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月19日 上午10:20:43   
* @version        
*/
public class jsk_dp_LIS_05 {

	private static int[] ns;
	private static boolean flag;
	private static int n;
	private static int[] lef;
	private static int[] rit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ns = new int[n+10];
		for(int i = 1; i <= n; i++){
			ns[i] = sc.nextInt();
		}
		//正解：    
		//	lef[i]表示 从左边开始 元素ns[i] 的最长下降序列
		//  rit[i]表示 从右边开始 元素ns[i] 的最长下降序列
		lef = new int[n+10];
		rit = new int[n+10];
		//1.赋初值
		for(int i = 1; i <= n; i++){
			lef[i] = 1;
			rit[i] = 1;
		}
		//2.计算
		for(int i = 1; i <= n; i++){
			for(int j = i - 1; j >= 1; j--){
				if(ns[j] >= ns[i]){
					lef[i] = Math.max(lef[i], lef[j] + 1);
				}
			}
		}
		for(int i = n; i >= 1; i--){
			for(int j = i + 1; j <= n; j++){
				if(ns[j] >= ns[i]){
					rit[i] = Math.max(rit[i], rit[j] + 1);
				}
			}
		}

		//遍历，得最大的结果
		int max = 0;
		for(int i = 1; i <= n; i++){
			max = Math.max(max, lef[i] + rit[i] - 1);
		}
		System.out.println(n - max);
		
		
		/*
		 * 思路混乱，没有逻辑
		 */
//		int ans = 0;
//		for(int i = 1; i <= n; i++){//i 就是 Ap1 > Ap2 > ... > Api < ... < Apn  
//			flag = false;
//			int decline = lds(i);
//			int increase;
//			if(flag){
//				increase = lis(i+1);
//			}else{
//				increase = lis(i);
//			}
//			
//			//System.out.println("i = " + i + "  decline = " + decline + "   increase = " + increase + "  flag = " + flag);
//			ans = Math.max(ans, decline + increase);
//		}
//		
//		System.out.println(n - ans);
		
	}

//	private static int lds(int end) {//最长下降序列
//
//		int[] dp = new int[n+10];
//		int ans = 0;
//		for(int i = 1; i <= end; i++){
//			dp[i] = 1;
//		}
//		for(int i = 1; i <= end; i++){
//			
//			for(int j = i - 1; j >= 1; j--){
//				if(ns[j] >= ns[i]){
//					dp[i] = Math.max(dp[i], dp[j]+1);
//				}
//			}
//			ans = Math.max(ans, dp[i]);
//		}
//		
//		if(ans == dp[end])
//			flag = !flag;
//		return ans;
//	}
//
//	private static int lis(int start) {//最长上升序列
//
//		int[] dp = new int[n+10];
//		int ans = 0;
//		if(start <= n){
//			for(int i = start; i <= n; i++){
//				dp[i] = 1;
//			}
//			for(int i = start; i <= n; i++){
//				for(int j = i -1; j >= start; j--){
//					if(ns[j] <= ns[i]){
//						dp[i] = Math.max(dp[i], dp[j] + 1);
//					}
//				}
//				ans = Math.max(ans, dp[i]);
//			}
//		}
//		
//		
//		return ans;
//	}

}
