package search.dfs;

import java.util.Scanner;

/** dfs,迷宫
 * 计蒜客深度优先搜索第一题
 * 中国象棋“马走日”
 * https://www.jisuanke.com/course/6497
*    
* 项目名称：OJ   
* 类名称：jsk_dfs01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月30日 下午2:24:41   
* @version        
*/
public class jsk_dfs01 {
	
	public static char[][] maze   = new char[10][9];
	public static boolean[][] vis = new boolean[10][9];
	public static int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	public static boolean flag = false;

	public static void main(String[] args) {		

		Scanner scan = new Scanner(System.in);
		//从控制台获取输入
		int x = 0, y = 0;//记录起点的坐标
		for(int i = 0; i < 10; i++){
			//获取  行
			String str = scan.next();
			//将str中的元素分别储存到 maze数组i行中的每一列
			for(int j = 0; j < 9; j++){
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == 'S'){
					x = i;
					y = j;
				}
			}
		}
		
		dfs(x,y);
		if(flag){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
		for(int i = 0; i < 10; i++){
			for(char ch : maze[i]){
				System.out.print(ch);
			}
			System.out.println();
		}
		
		
	}


	private static void dfs(int x, int y) {
		
		//将maze[x][y]设置为已经走过的标记
		vis[x][y] = true;
//		maze[x][y] = 'm';
		
		if(flag){
			return;
		}
		
		if(maze[x][y] == 'T'){
			flag = true;
			return;
		}
		

		
		//深度搜索
		for(int i = 0; i < 8; i++){
			//获得下一步各个方向的坐标
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && maze[tx][ty] != '#' && !vis[tx][ty]){
				dfs(tx,ty);
			}
		}
		
//		//当前位置深度搜索失败，将当前位置状态恢复为没有访问
//		vis[x][y] = false;
//		maze[x][y] = '.';
//		
//		return;
	}


	private static boolean in(int tx, int ty) {
		return tx >= 0 && tx < 10 && ty >= 0 && ty < 9;
	}
	
	

}
