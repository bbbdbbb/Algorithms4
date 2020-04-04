package search.dfs;

import java.util.Scanner;

/**  抽象深度搜索剪枝
 * 	Besty的旅行
 * 	https://www.jisuanke.com/course/6497/341235 
*    
* 项目名称：OJ   
* 类名称：jsk_dfs05_cut   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月4日 下午9:26:29   
* @version        
*/
public class jsk_dfs05_cut {

	private static int N;
	private static int[][] map;
	private static int ans;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] lost;
	

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		N = scan .nextInt();
		map = new int[N][N];
		lost = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				for(int k = 0; k < 4; k++){
					int ti = i + dir[k][0];
					int tj = j + dir[k][0];
					if(in(ti,tj)){
						lost[i][j]++;
					}
				}
			}
		}
		
		lost[N-1][0]++;
		ans = 0;
		dfs(0,0,0);
		
		
		System.out.println(ans);
		
		System.out.println("用时：" + (System.currentTimeMillis() -start));

		
	}

	private static boolean in(int ti, int tj) {
		return ti>=0 && ti<N && tj>=0 && tj<N;
	}

	private static void dfs(int x, int y, int cnt) {
		
		//到达终点，并且所有的格子都走过
		if(x == N - 1 && y == 0 && cnt == N * N - 1){
			ans++;
			return;
		}
		
		map[x][y] = 1;
		
		//如果map[x][y]的四个方向  其中有一个点的剩余路线lost[tx][ty]只有一个了，那么必须走这个方向
		int d = -1;
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && map[tx][ty] == 0){
				lost[tx][ty]--;
				if(lost[tx][ty] == 1)
					d = i;
			}		
		}
		
		for(int i = 0; i < 4; i++){
			if(d != -1 && d != i){
				continue;
			}
			
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			
			if(in(tx,ty) && map[tx][ty] == 0){
				int count2 = 0;
				boolean flag = true;
				for(int j = 0; j < 4; j++){
					int ex = tx + dir[j][0];
					int ey = ty + dir[j][1];
					if(in(ex,ey) && map[ex][ey] == 0){
						if(lost[ex][ey] < 2){
							flag = false;
							break;
						}else if(lost[ex][ey] == 2){
							count2++;
						}
					}
				}
				
				if(flag && count2 <= 1){
					dfs(tx,ty,cnt+1);
				}
			}			
		}
		
		map[x][y] = 0;
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && map[tx][ty] == 0){
				lost[tx][ty]++;
			}		
		}
		
	}

}
