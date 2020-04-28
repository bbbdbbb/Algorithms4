package search.dfs;

import java.util.Scanner;

/**  抽象深度优先搜索
 *  计蒜客抽象深度优先搜索第四题 
 *  https://www.jisuanke.com/course/6497/341080
 *  
 *  题目：数独
 *  给一个9*9的数独，填写其中的空格，使得每一行,每一列以及每一个 3*3的小宫格都没有重复的数
 *  
 *  输入：

* 2 6 * * * * * *
* * * 5 * 2 * * 4
* * * 1 * * * * 7
* 3 * * 2 * 1 8 *
* * * 3 * 9 * * *
* 5 4 * 1 * * 7 *
5 * * * * 1 * * *
6 * * 9 * 7 * * *
* * * * * * 7 5 *


 * 输出：
1 2 6 7 3 4 5 9 8
3 7 8 5 9 2 6 1 4
4 9 5 1 6 8 2 3 7
7 3 9 4 2 5 1 8 6
8 6 1 3 7 9 4 2 5
2 5 4 8 1 6 3 7 9
5 4 7 2 8 1 9 6 3
6 1 3 9 5 7 8 4 2
9 8 2 6 4 3 7 5 1
 
 
*    
* 项目名称：OJ   
* 类名称：jsk_abstract_dfs04   
* 类描述：计蒜客学习中心-抽象深度搜索第二题-数独     
* 创建人：bbbdbbb   
* 创建时间：2020年4月1日 下午9:53:10   
* @version        
*/
public class jsk_abstract_dfs04 {
	
	public static char[][] map = new char[9][9];
	public static boolean[][] row = new boolean[9][10];
	public static boolean[][] col = new boolean[9][10];
	public static boolean[][] rea = new boolean[9][10];
	private static boolean flag;
	public static void main(String[] args) {

		int x = -1;
		int y = -1;//记录起点
		Scanner scan = new Scanner(System.in);
		//接收数独   ->  正常读取数据
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				map[i][j] = scan.next().charAt(0);
				if(x == -1 && y == -1 && map[i][j] == '*'){
					x = i;
					y = j;
				}else if(map[i][j] >= '0' && map[i][j] <= '9'){
					int num = map[i][j] - '0';
					row[i][num] = true;
					col[j][num] = true;
					rea[i/3*3 + j/3][num] = true;
				}
			}
		}
		

		dfs(x,y);

		
	}

	private static void dfs(int r, int c) {
		//System.out.println(r + "  " + c);
		if(flag){
			return;
		}
		
		if(r == 9 && c ==0){//找到 一种  填写数独的方式  就必须 抓住机会将其打印，不然即使将flag设置为flag,也会使得数组map[]中的答案被修改
			flag = true;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(j<8)
						System.out.print(map[i][j] + " ");
					else
						System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		if(map[r][c] != '*'){
			int tc = c,tr = r;
			if(tc == 8){
				tr++;
				tc = 0;
			}else{
				tc++;
			}
			dfs(tr,tc);
			
			//   !!!  错误  ！！！！
			//   第一次做的时候没有在这个if语句结束的时候 使用return
			//   如果这里 缺少return语句 会导致 数独中的 固有数字被更改，从而不会有正确结果
			
			//   这里不return，程序会继续执行到下面的for循环中，这一格map[r][c]可能可能是数字‘9’
			//   碰巧map[r][c]在行上，列上，所属九方格中都没有数字‘5’，
			//   那么就会将原来的数字‘9’改变为数字‘5’
			//	 例子：map[4][5]
			//   
			return;
			//System.out.println("数字没有return：  " + r + " " + c);
		}
		
		int i = 1;
		for(; i <= 9; i++){
			
			if(check(r,c,i)){//如果这个位置可以填入数字i
				//System.out.println("错误操作： " + r + " " + c + " " + i);
				map[r][c] = (char) ('0' + i);
				row[r][i] = true;
				col[c][i] = true;
				rea[r/3*3 + c/3][i] = true;
				//打桩：查看错误信息  上面如果 缺少return语句 会导致 数独中的 固有数字被更改，从而不会有正确结果  例子：map[4][5]
//				if(r == 4 && c == 5){
//					for(int i1 = 0; i1 < 9; i1++){
//						for(int j = 0; j < 9; j++){
//							if(j<8)
//								System.out.print(map[i1][j] + " ");
//							else
//								System.out.print(map[i1][j]);
//						}
//						System.out.println();
//					}
//				}
				
				int tc = c;
				int tr = r;
				if(tc == 8){
					tr++;
					tc = 0;
				}else{
					tc++;
				}
				
				//System.out.println(tr + " " + tc + " " + i);
				dfs(tr,tc);
				
				map[r][c] = '*';
				row[r][i] = false;
				col[c][i] = false;
				rea[r/3*3 + c/3][i] = false;
			}
			
		}
	}

	private static boolean check(int r, int c, int i) {
		return  !row[r][i] && !col[c][i] && !rea[r/3*3 + c/3][i];
	}

}
