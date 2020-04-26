package search.dfs;

import java.util.Scanner;

/** dfs 类似与水池型，不过搜索的条件不是简单的相邻了，而是在同一行，同一列。新型题，灵活
 * 计蒜客深度优先搜索第三题
 * 引爆炸弹
 * https://www.jisuanke.com/course/6497/341078  

	输入：
5 5
00010
00010
01001
10001
01000
	输出：
2

*    
* 项目名称：OJ   
* 类名称：jsk_dfs03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月30日 下午3:25:49   
* @version        
*/
public class jsk_dfs03 {

	private static int n;
	private static int m;
	private static char[][] map;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	
	//剪枝
	private static boolean[] row;
	private static boolean[] col;

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new char[n][m];
		row = new boolean[n];
		col = new boolean[m];
		for (int i = 0; i < n; i++) {
			String str = scan.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++){
				if(map[i][j] == '1'){
					ans++;
					dfs_cut(i,j);
				}
			}
		}
		
		scan.close();
		System.out.println(ans);
		
	}

	private static void dfs(int x, int y) {

		//1.将当前点设置为访问状态
		map[x][y] = '0';
		
		//2.不同方向进行深度搜索
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			//四个方向走到底
			while(in(tx,ty)){				

				if(map[tx][ty] == '1'){
					dfs(tx,ty);
				}
				
				tx = tx + dir[i][0];
				ty = ty + dir[i][1];
			}
		}
	}

	private static boolean in(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	
	public static void dfs_cut(int x, int y){
		
		map[x][y] = '0';
		
		if(!row[x]){
			row[x] = true;
			for(int i = 0; i < m; i++){
				if(map[x][i] == '1'){
					dfs_cut(x,i);
				}
			}
		}
		
		if(!col[y]){
			col[y] = true;
			for(int j = 0; j < n; j++){
				if(map[j][y] == '1'){
					dfs_cut(j,y);
				}
			}
			
						
		}
		
	}

}

/*
10 10
1000000000
1100000000
1000000000
0000101001
0000101001
0001010010
0000000000
0000000010
0010000100
0010000100

4
 */
