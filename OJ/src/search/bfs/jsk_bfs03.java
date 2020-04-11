package search.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**   �����ѧϰ����   �����������bfs 
 * 	��ͷ���ؼ�
 * 	https://www.jisuanke.com/course/6497/341089
 * 	S���ȵ�����һ��P��Ȼ��T�㣬�����·��
 *
	����
8 10
P.####.#P#
..#..#...#
..#T##.#.#
..........
..##.#####
..........
#####...##
###....S##

	���
21
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_bfs03   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��10�� ����11:24:08   
* @version        
*/
public class jsk_bfs03 {

	private static int N;
	private static int M;
	private static char[][] maze;
	private static boolean[][] vis;
	private static int sx;//���s������
	private static int sy;
	private static int tx;//�յ�T������
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
		
		//�����Թ�
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
		
		
		//����ʼλ���ҵ�Կ��  P��
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
				//��¼p������꣬�͵������ľ���
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


