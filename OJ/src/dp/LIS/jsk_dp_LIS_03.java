package dp.LIS;

import java.util.Scanner;

/** 计蒜客学习中心	最大字段和
 * 	蒜头君的环状矩阵
 * 	https://www.jisuanke.com/course/6497/341115  
*    
* 项目名称：OJ   
* 类名称：jsk_dp_LIS_03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月17日 下午10:48:57   
* @version        
*/
public class jsk_dp_LIS_03 {

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
				for(int i = 1; i <= n; i++){
					for(int start = 1; start <= m; start++ ){
						int row = (i + len -1) % n;
						if(row == 0)		row = n;
						long s = 0;
						for(int j = 0; j < m; j++){	
							
							int tem = j;
							//System.out.println(i + " " + j + "  start = " + start + "  tem = " + tem);
							j = (j + start) % m;
							if(j == 0)		j = m;
							
							
							if(row > i){
								s = s + sum[row][j] - sum[i-1][j];
							}else{
								s = s + sum[row][j] + sum[n][j] - sum[i-1][j];
							}
							
							if(i == 3){
								//System.out.println("i = " + i +"  row = "+ row + "  j = " + j  + "  s = " + s);
							}
							
							if(s < 0){
								s = 0;
								j = tem;
								continue;
							}
							if(s > max){
								max = s;
							}
							
							j = tem;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}


}
