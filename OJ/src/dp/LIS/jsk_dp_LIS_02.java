package dp.LIS;

import java.util.Scanner;

/**  计蒜客学习中心	最大字段和
 * 	 蒜头君的最大子矩阵和
 * 	https://www.jisuanke.com/course/6497/341114
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LIS_02   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月17日 下午10:49:59   
* @version        
*/
public class jsk_dp_LIS_02 {

	private static long[][] map;
	private static long[][] sum;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new long[n+10][m+10];
		sum = new long[n+10][m+10];
		long max = Long.MIN_VALUE;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
				sum[i][j] = sum[i-1][j] + map[i][j];
			}
		}
		
		if(max > 0){
			for(int len = 2; len <= n; len++){
				for(int i = 1; i <= n - len +1; i++){
					long s = 0;
					for(int j = 1; j <= m; j++){
						s = s + sum[i + len -1][j] - sum[i-1][j];
						if(s < 0){
							s = 0;
							continue;
						}
						if(s > max){
							max = s;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
