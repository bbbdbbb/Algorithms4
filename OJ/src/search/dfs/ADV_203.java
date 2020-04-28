package search.dfs;

import java.util.Scanner;

/** �㷨��� 8�ʺ󡤸�		ADV-203
 * 	����ͬ8�ʺ����⣬����������ÿ����һ�����֣�Ҫ��˻ʺ����ڸ�������֮�����  
 * 	http://lx.lanqiao.cn/problem.page?gpid=T374
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_203   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��28�� ����11:55:45   
* @version        
*/
public class ADV_203 {

	private static int[][] map;
	private static boolean[] celVis;//����ĳһ������û�лʺ�
	private static boolean[] up;//���ڱ�ʾб��Ϊ����б������û�лʺ�
	private static boolean[] down;//���ڱ�ʾб��Ϊ����б������û�лʺ�
	private static int ans;
	private static int n;

	public static void main(String[] args) {
		
		n = 8;
		Scanner sc = new Scanner(System.in);
		map = new int[n][n];
		celVis = new boolean[n];
		up = new boolean[2 * n];
		down = new boolean[2 * n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		ans = 0;
		dfs(0,0);
		System.out.println(ans);
	}

	private static void dfs(int row, int sum) {
		
		if(row == n){
			if(sum > ans)
				ans = sum;
			
			return;
		}
		
		for(int cel = 0; cel < n; cel++){
			if(check(row,cel)){
				up[row + cel] = true;
				down[row - cel + n] = true;
				celVis[cel] = true;
				
				dfs(row + 1, sum + map[row][cel]);
				
				up[row + cel] = false;
				down[row - cel + n] = false;
				celVis[cel] = false;
			}
		}
		
		
	}

	private static boolean check(int row, int cel) {
		return !celVis[cel] && !up[row + cel] && !down[row - cel + n];
	}

}

/*
��������
1 2 3 4 5 6 7 8
9 10 11 12 13 14 15 16
17 18 19 20 21 22 23 24
25 26 27 28 29 30 31 32
33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48
48 50 51 52 53 54 55 56
57 58 59 60 61 62 63 64

�������
260
 */
