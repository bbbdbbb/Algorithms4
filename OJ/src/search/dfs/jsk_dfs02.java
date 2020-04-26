package search.dfs;

import java.util.Scanner;

/** dfs,水池型的题目，类似于《挑战竞赛》上的例题
 *  计蒜客深度优先搜索第二题
 *   踏青
 *   https://www.jisuanke.com/course/6497/341077
*    
* 项目名称：OJ   
* 类名称：jsk_dfs02   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月30日 下午2:51:25   
* @version        
*/
public class jsk_dfs02 {
	
	public static char[][] map;
	public static int[][]  dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static int n;
	public static int m;

	public static void main(String[] args) {

		//获取控制台的地图
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new char[n][m];
		for(int i = 0; i < n; i++){
			String str = scan.next();
			for(int j = 0; j < m; j++){
				map[i][j] = str.charAt(j);
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map[i][j] == '#'){
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}

	private static void dfs(int x, int y) {
		//利用dfs将一个草丛'#'全部替换成'.'
		
		//1.将当前点设置为访问状态
		map[x][y] = '.';
		
		//2.不同方向进行深度搜索
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && map[tx][ty] == '#'){
				dfs(tx,ty);
			}
		}
	}

	private static boolean in(int x, int y) {

		return x>=0 && x < n && y>=0 && y<m;
	}

}
