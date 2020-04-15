package dp.unknow;

import java.util.Scanner;

/**  计蒜客学习中心 初始动态规划  
 * 	数组分组
 * 	https://www.jisuanke.com/course/6497/341110
*    
* 项目名称：OJ   
* 类名称：jsk_dp07   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月15日 下午9:49:40   
* @version        
*/
public class jsk_dp07 {

	private static int[] ns;
	private static int[][] f;
	private static int[] S;
	private static int[][] m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n+10];
		//官方推荐方法：
		S = new int[n+10];
		m = new int[n+10][n+10];
		for(int i = 1; i <= n; i++){
			m[i][i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++){
			for(int j = i + 1; j <= n; j++){
				m[i][j] = m[i][j-1] * m[j][j] % 1000;
			}
		}
		
		for(int i = 2; i <= n; i++){
			for(int j = 1; j <= i; j++){
				m[1][i] = Math.max(m[1][i], m[1][j-1] + m[j][i]);
			}
		}
		System.out.println(m[1][n]);
		
		//区间dp方法，3层for循环，O(n^3)
//		f = new int[n][n];
//		for(int i = 0; i < n; i++){
//			ns[i] = sc.nextInt();
//		}
//
//		//赋初值
//		for(int i = 0; i < n; i++){
//			for(int j = i; j < n; j++){
//				if(i == j)		f[i][j] = ns[i];
//				else{
//					f[i][j] = ns[i];
//					for(int k = 1; k <= j - i; k++){
//						f[i][j] = f[i][j] * ns[i + k] % 1000;
//					}
//				}
//			}
//		}
//		
//		for(int len = 2; len < n; len++){
//			for(int i = 0; i < n - len; i++){
//				for(int k = 0; k < len; k++){
//					f[i][i+len] = Math.max(f[i][i+len], f[i][i+k] + f[i+k+1][i+len]);
//				}
//			}
//		}
//		
//		System.out.println(f[0][n-1]);
		
	}

}
