package search.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**   计蒜客学习中心   广度优先搜索bfs 
 * 	蒜头君回家
 * 	https://www.jisuanke.com/course/6497/341089
 * 	S点先到任意一个P，然后到T点，求最短路径
 *
	输入
8 10
P.####.#P#
..#..#...#
..#T##.#.#
..........
..##.#####
..........
#####...##
###....S##

	输出
21
*    
* 项目名称：OJ   
* 类名称：jsk_bfs03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月10日 下午11:24:08   
* @version        
*/
public class jsk_bfs03 {

	private static int N;
	private static int M;
	private static char[][] maze;
	private static boolean[][] vis;
	private static int sx;//起点s的坐标
	private static int sy;
	private static int tx;//终点T的坐标
	private static int ty;

	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	private static int[][] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new char[N][M];
		vis = new boolean[N][M];
		ans = new int[N][M];
		
		//绘制迷宫
		for(int i = 0; i < N; i++){
			String str = sc.next();
			for(int j = 0; j < M; j++){
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == 'S'){
					sx = i;
					sy = j;
				}
				if(maze[i][j] == 'T'){
					tx = i;
					ty = j;
				}

			}
		}
		
		
		//从起始位置找的钥匙  P点
		bfs(sx,sy,'P');
		//System.out.println(step);

		
		vis = new boolean[N][M];
		bfs(tx,ty,'P');

//		for(int i  = 0; i < N ; i++){
//			for(int j = 0; j < M; j++){
//				System.out.print(ans[i][j] + " ");
//			}
//			System.out.println();
//		}
		int step = M * N;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(ans[i][j] != 0 && ans[i][j] < step)
					step = ans[i][j];
			}
		}
		System.out.println(step);
	}


	private static void bfs(int x, int y,char aim) {
		
		LinkedList<node> q = new LinkedList<node>();
		q.add(new node(x,y,0));
		vis[x][y] = true;
		while(!q.isEmpty()){
			node now = q.poll();
			
			if(maze[now.x][now.y] == aim){
				//记录p点的坐标，和到达起点的距离
				ans[now.x][now.y] += now.d;
			}
			
			for(int i = 0; i < 4; i++){
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(in(nx,ny) && maze[nx][ny] != '#' && !vis[nx][ny]){
					vis[nx][ny] = true;
					q.add(new node(nx,ny,now.d + 1));
				}
			}
		}
		
	}
	
	private static boolean in(int x, int y) {

		return x>=0 && x<N && y>=0 && y<M;
	}

	private static class node{
		public  int x;
		public  int y;
		public int d;
		public node(int x,int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}


