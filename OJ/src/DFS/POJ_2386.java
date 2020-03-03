package DFS;

import java.util.Scanner;

/** bfs����
 * 2386:Lake Counting
 * http://bailian.openjudge.cn/practice/2386/  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�POJ_2386   
* ��Ŀ������  
	�ж������char������һ���м���W
	
	���룺
10 12
W........WW.
.WW......WWW
....WW...WW.
.........WW.
............
..W......W..
.........WW.
W.W.W.....W.
.W.W......W.
..W...W...W.

	�����
7
	
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��3�� ����5:51:52   
* @version        
*/
public class POJ_2386 {
	public static char[][] chs;
	private static int n;
	private static int m;
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		chs = new char[n][m]; 
		int count = 0;

		for(int i=0;i<n;i++){
			String input = scan.next();
			for(int j=0;j<m;j++){
				chs[i][j] = input.charAt(j);
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(chs[i][j]=='W'){
					dfs(i,j);
					count++;
				}
				
			}
			
		}
		System.out.println(count);
		

	}

	
	private static void dfs(int x,int y) {
		
		chs[x][y] = '.';
		
		for(int dx=-1;dx<=1;dx++){
			for(int dy=-1;dy<=1;dy++){
				int newX = x + dx;
				int newY = y + dy;
				
				if(newX>=0 && newX<n && newY>=0 && newY<m && chs[newX][newY]=='W')		dfs(newX,newY);
			}
		}
	}

}
