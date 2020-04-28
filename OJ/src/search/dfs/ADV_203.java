package search.dfs;

import java.util.Scanner;

/** 算法提高 8皇后·改		ADV-203
 * 	规则同8皇后问题，但是棋盘上每格都有一个数字，要求八皇后所在格子数字之和最大。  
 * 	http://lx.lanqiao.cn/problem.page?gpid=T374
*    
* 项目名称：OJ   
* 类名称：ADV_203   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月28日 上午11:55:45   
* @version        
*/
public class ADV_203 {

	private static int[][] map;
	private static boolean[] celVis;//用于某一列上有没有皇后
	private static boolean[] up;//用于表示斜率为正的斜线上有没有皇后
	private static boolean[] down;//用于表示斜率为负的斜线上有没有皇后
	private static int ans;
	private static int n;

	public static void main(String[] args) {
		
		n = 8;
		Scanner sc = new Scanner(System.in);
		map = new int[n][n];
		celVis = new boolean[n];
		up = new boolean[2 * n];
		down = new boolean[2 * n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		ans = 0;
		dfs(0,0);
		System.out.println(ans);
	}

	private static void dfs(int row, int sum) {
		
		if(row == n){
			if(sum > ans)
				ans = sum;
			
			return;
		}
		
		for(int cel = 0; cel < n; cel++){
			if(check(row,cel)){
				up[row + cel] = true;
				down[row - cel + n] = true;
				celVis[cel] = true;
				
				dfs(row + 1, sum + map[row][cel]);
				
				up[row + cel] = false;
				down[row - cel + n] = false;
				celVis[cel] = false;
			}
		}
		
		
	}

	private static boolean check(int row, int cel) {
		return !celVis[cel] && !up[row + cel] && !down[row - cel + n];
	}

}

/*
样例输入
1 2 3 4 5 6 7 8
9 10 11 12 13 14 15 16
17 18 19 20 21 22 23 24
25 26 27 28 29 30 31 32
33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48
48 50 51 52 53 54 55 56
57 58 59 60 61 62 63 64

样例输出
260
 */
