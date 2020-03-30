package search.dfs;

import java.util.Scanner;

/** dfs ������ˮ���ͣ������������������Ǽ򵥵������ˣ�������ͬһ�У�ͬһ�С������⣬���
 * ����������������������
 * ����ը��
 * https://www.jisuanke.com/course/6497/341078  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs03   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��30�� ����3:25:49   
* @version        
*/
public class jsk_dfs03 {

	private static int n;
	private static int m;
	private static char[][] map;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new char[n][m];
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
					dfs(i,j);
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void dfs(int x, int y) {

		map[x][y] = '0';
		for(int i = 0; i < 4; i++){
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			//�ĸ������ߵ���
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

}
