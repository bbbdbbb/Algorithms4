package search.dfs;

import java.util.Scanner;

/** 抽象深度优先搜索
 *  计蒜客抽象深度优先搜索第二题
 *  
 *  题目：八皇后问题
 *  一个棋盘上‘皇后’所在的列和行，还有两个正负斜率的斜线上都不能有 其他棋子
 *  问，一个棋盘上放8个皇后 一共有多少种方式？
 *  
 *  输入：
 *  8
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
*  
*   输出：
*   92


* 项目名称：OJ   
* 类名称：jsk_abstract_dfs02   
* 类描述： 计蒜客培训视频-抽象深度搜索第二题-n皇后问题  
* 创建人：bbbdbbb   
* 创建时间：2020年4月1日 上午10:44:24   
* @version  1.0      
*/
public class jsk_abstract_dfs02 {
	
	public static int n;
	public static int[][] map;
	public static boolean[] up;
	public static boolean[] down;
	private static int ans;
	private static boolean[] cdis;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		map = new int[n][n];
		up = new boolean[2*n];
		down = new boolean[2*n];
		cdis = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		scan.close();
		
		ans = 0;
		dfs(0);
		
		System.out.println(ans);
	}

	private static void dfs(int row) {

		if(row == n){
			ans++;
			return;
		}
		
		for(int col = 0; col < n; col++){
			if(check(row,col)){
				//System.out.println("进入check（）");
				map[row][col] = 0;
				up[row + col] = true;
				down[row - col + n] = true;
				cdis[col] = true;
				
				dfs(row + 1);
				
				map[row][col] = 1;
				up[row + col] = false;
				down[row - col + n] = false;
				cdis[col] = false;
			}
		}
		
	}

	private static boolean check(int row, int col) {

		return map[row][col] == 1 && !up[row + col] && !down[row - col + n] && !cdis[col];
	}

}
