package search.dfs;

import java.util.Scanner;

/** 抽象深度优先搜索
 * 计蒜客抽象深度优先搜索第三题
 * https://www.jisuanke.com/course/6497/341079
 * 
 * 题目：黑白皇后问题（2n皇后问题）
 * 类似于八皇后问题，在棋盘上有两种类型的皇后棋子：黑皇后和白皇后
 * 黑皇后和白皇后不能在棋盘上的同一个位置，其他不受影响
 * 
 * 输入
 * 4
	1 1 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
	
 * 输出
 * 2
 
 * 输入
 *  4
	1 0 1 1
	1 1 1 1
	1 1 1 1
	1 1 1 1
 * 输出
 * 0
 
*    
* 项目名称：OJ   
* 类名称：jsk_abstract_dfs03   
* 类描述：计蒜客学习中心-抽象深度搜索第一题-2n皇后问题     
* 创建人：bbbdbbb   
* 创建时间：2020年4月1日 上午11:28:08   
* @version        
*/
public class jsk_abstract_dfs03 {
	
	public static int n;
	public static int[][] map;
	public static boolean[] up;
	public static boolean[] down;
	private static boolean[] cdis;
	private static int ans;
	
	public static boolean[] up1;
	public static boolean[] down1;
	private static boolean[] cdis1;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		map = new int[n][n];
		up = new boolean[2*n];
		down = new boolean[2*n];
		cdis = new boolean[n];
		
		up1 = new boolean[2*n];
		down1 = new boolean[2*n];
		cdis1 = new boolean[n];
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
			dfs1(0);
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

	
	

	private static void dfs1(int row) {

		if(row == n){
			ans++;
			return;
		}
		
		for(int col = 0; col < n; col++){
			if(check1(row,col)){
				map[row][col] = 0;
				up1[row + col] = true;
				down1[row - col + n] = true;
				cdis1[col] = true;
				
				dfs1(row + 1);
				
				map[row][col] = 1;
				up1[row + col] = false;
				down1[row - col + n] = false;
				cdis1[col] = false;
			}
		}
	}

	private static boolean check1(int row, int col) {
		//System.out.println(row + " " + col);
		return map[row][col] == 1 && !up1[row + col] && !down1[row - col + n] && !cdis1[col];
	}

}
