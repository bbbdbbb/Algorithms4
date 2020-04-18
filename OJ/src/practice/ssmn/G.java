package practice.ssmn;

import java.util.Scanner;

/**   ��������
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�G   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��18�� ����9:55:39   
* @version        
*/
public class G {

	private static int[][] map;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n;
	private static int m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+10][m+10];
		int xx = sc.nextInt();
		int yy = sc.nextInt();
		
		map[1][1] = 1;
		int x = 1;
		int y = 1;
		int d = 0;//����
		for(int i = 2; i <= n * m; i++){
			int tx = x + dir[d][0];
			int ty = y + dir[d][1];
			if(in(tx,ty) && map[tx][ty] == 0){
				map[tx][ty] = i;
			}else{//�ı䷽��
				d = (d + 1) % 4;
				tx = x + dir[d][0];
				ty = y + dir[d][1];
				map[tx][ty] = i;
			}
			
			x = tx;
			y = ty;
		}
		
//		for(int i = 1; i <= n; i++){
//			for(int j = 1; j <= m; j++){
//				if(j % m == 0){
//					System.out.println(map[i][j]);
//				}else{
//					System.out.print(map[i][j] + "  ");
//				}
//			}
//		}
		
		System.out.println(map[xx][yy]);
		
	}

	private static boolean in(int x, int y) {

		return x >= 1 && x <= n && y >= 1 && y <= m;
	}

}
