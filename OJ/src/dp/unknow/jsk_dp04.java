package dp.unknow;

import java.util.Scanner;

/**   计蒜客学习中心 初始动态规划
 * 	蒜头君的新游戏   -->  围圈传物
 * 	https://www.jisuanke.com/course/6497/341107
 * 		
*    
* 项目名称：OJ   
* 类名称：jsk_dp04   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月14日 下午2:19:21   
* @version        
*/
public class jsk_dp04 {

	private static int[][] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		f = new int[n+10][m+10];
		f[2][1] = 1;
		f[n][1] = 1;
//		f[1][2] = 2;
//		f[3][2]++;
//		f[n-1][2]++;
		
		for(int j = 2; j <= m; j++){
			for(int i = 1; i <= n; i++){		
				int l = i - 1;
				int r = i + 1;
				if(l < 1)		l = n;
				if(r > n)		r = 1;
				f[i][j] = f[l][j - 1] + f[r][j - 1];
				System.out.println("f[" + i + "][" + j + "] = " + f[i][j]);

			}
		}
		
		System.out.println(f[1][m]);
	}

}
