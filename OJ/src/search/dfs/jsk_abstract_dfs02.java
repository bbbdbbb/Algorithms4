package search.dfs;

import java.util.Scanner;

/** ���������������
 *  ����ͳ���������������ڶ���
 *  
 *  ��Ŀ���˻ʺ�����
 *  һ�������ϡ��ʺ����ڵ��к��У�������������б�ʵ�б���϶������� ��������
 *  �ʣ�һ�������Ϸ�8���ʺ� һ���ж����ַ�ʽ��
 *  
 *  ���룺
 *  8
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
	1 1 1 1 1 1 1 1
*  
*   �����
*   92


* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_abstract_dfs02   
* �������� �������ѵ��Ƶ-������������ڶ���-n�ʺ�����  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��1�� ����10:44:24   
* @version  1.0      
*/
public class jsk_abstract_dfs02 {
	
	public static int n;
	public static int[][] map;
	public static boolean[] up;
	public static boolean[] down;
	private static int ans;
	private static boolean[] cdis;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		map = new int[n][n];
		up = new boolean[2*n];
		down = new boolean[2*n];
		cdis = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		scan.close();
		
		ans = 0;
		dfs(0);
		
		System.out.println(ans);
	}

	private static void dfs(int row) {

		if(row == n){
			ans++;
			return;
		}
		
		for(int col = 0; col < n; col++){
			if(check(row,col)){
				//System.out.println("����check����");
				map[row][col] = 0;
				up[row + col] = true;
				down[row - col + n] = true;
				cdis[col] = true;
				
				dfs(row + 1);
				
				map[row][col] = 1;
				up[row + col] = false;
				down[row - col + n] = false;
				cdis[col] = false;
			}
		}
		
	}

	private static boolean check(int row, int col) {

		return map[row][col] == 1 && !up[row + col] && !down[row - col + n] && !cdis[col];
	}

}
