package DFS;

import java.util.Scanner;

/** bfs入门
 * 2386:Lake Counting
 * http://bailian.openjudge.cn/practice/2386/  
*    
* 项目名称：OJ   
* 类名称：POJ_2386   
* 题目描述：  
	判断输入的char数组中一共有几块W
	
	输入：
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

	输出：
7
	
* 创建人：bbbdbbb   
* 创建时间：2020年3月3日 下午5:51:52   
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
