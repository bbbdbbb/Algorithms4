package search.dfs;

import java.util.Scanner;

public class jsk_dfs05_cut {

	private static int N;
	private static int[][] map;
	private static int ans;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		
		ans = 0;
		dfs(0,0);
		
		
		System.out.println(ans);
		
	}

	private static void dfs(int x, int y) {
		
		if(map[x][y] == 1){
			return;
		}
		
		if(check(x,y)){
			return;
		}
		
		map[x][y] = 1; 
		if(x == N - 1 && y == 0 && all()){
			ans++;
			map[x][y] = 0;
			return;
		}
		
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && map[tx][ty] == 0){
				dfs(tx,ty);
			}
		}
		
		map[x][y] = 0;
		
	}

	/*
	 * true:不可以继续走下去
	 * false：可以继续走
	 */
	private static boolean check(int x, int y) {

		if((x == 0 || x == N - 1) && y >= 1 && y <= N-2){
			if(map[x][y-1] + map[x][y+1] == 1){
				return false;
			}else{
				return true;
			}
		}
		if((y == 0 || y == N - 1) && x >= 1 && x <= N-2){
			if(map[x-1][y] + map[x+1][y] == 1){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}

	private static boolean in(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

	private static boolean all() {
		
		boolean b = true;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(map[i][j] == 0){//有小方格没有走到
					b = false;
					break;
				}
			}

		}
		return b;
	}

}
