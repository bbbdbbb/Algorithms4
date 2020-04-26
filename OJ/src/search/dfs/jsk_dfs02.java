package search.dfs;

import java.util.Scanner;

/** dfs,ˮ���͵���Ŀ�������ڡ���ս�������ϵ�����
 *  �����������������ڶ���
 *   ̤��
 *   https://www.jisuanke.com/course/6497/341077
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs02   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��30�� ����2:51:25   
* @version        
*/
public class jsk_dfs02 {
	
	public static char[][] map;
	public static int[][]  dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static int n;
	public static int m;

	public static void main(String[] args) {

		//��ȡ����̨�ĵ�ͼ
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
		//����dfs��һ���ݴ�'#'ȫ���滻��'.'
		
		//1.����ǰ������Ϊ����״̬
		map[x][y] = '.';
		
		//2.��ͬ��������������
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
