package practice.jsk05;

import java.util.Scanner;

/** 计蒜客模拟题五
 * 	卡片游戏  
 * 	https://www.jisuanke.com/course/6497/467059
 * 
 * 蒜头君最优策略选牌，花妹贪心选牌，求最大差值
 * 
	输入：
100
304 166 849 478 770 991 42 114 85 425 799 91 333 958 401 988 684 709 513 737 
672 156 994 575 79 707 282 238 892 479 985 196 996 185 25 766 175 419 
231 259 843 30 349 175 987 102 162 23 810 27 111 833 182 104 408 260 162 41 
850 54 519 186 601 867 370 625 632 544 395 214 154 238 243 854 764 582 955 
278 956 117 304 66 949 485 521 708 96 682 749 945 87 267 482 39 485 851 16 116 746 410
	输出：
8895

*  
*    
* 项目名称：OJ   
* 类名称：t05   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月12日 下午4:47:48   
* @version        
*/
public class t05 {

	private static int[] ns;
	private static int ans = 0;
	private static int[][] dp;
	private static boolean[][] vis;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ns = new int[N];
		dp = new int[N][N];
		vis = new boolean[N][N];
		for(int i = 0; i < N; i++){
			ns[i] = sc.nextInt();
			
		}
		
		int ans = dp(0,N-1,true);
		System.out.println(ans);
	}

	private static int dp(int l, int r, boolean isSuan) {
		
		if(vis[l][r]){
			return dp[l][r];
		}
		
		if(l > r){
			return 0;
		}
		
		vis[l][r] = true;
		int res = 0;
		if(isSuan){//该蒜头君选牌，采取最优策略
			res = Math.max(dp(l+1, r, !isSuan) + ns[l], dp(l, r-1, !isSuan) + ns[r]);
		}else{//该花生妹选牌，采取贪心策略
			if(ns[l] >= ns[r]){
				res = dp(l+1, r, !isSuan) - ns[l];
			}else{
				res = dp(l, r-1, !isSuan) - ns[r];
			}
		}

		dp[l][r] = res;
		return res;
	}
	



}
