package dp.unknow;

import java.util.Scanner;

/**	计蒜客学习中心 初始动态规划 
 * 	一维消消乐
 *  https://www.jisuanke.com/course/6497/341109
 *  
 *  
 *    
*    
* 项目名称：OJ   
* 类名称：jsk_dp06   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月15日 下午3:33:38   
* @version        
*/
public class jsk_dp06 {

	private static int[] ns;
	private static int[][] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n];
		//f = new int[n][n];	//f[9000][9000]导致超内存了
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		
		/*
		 ## 3层循环，超内存，超时
		 */
		//赋初值
//		for(int i = 0; i < n; i++){
//			for(int j = i; j < n; j++){
//				if(i == j)		f[i][j] = 0;
//				if(i == j - 1 && ns[i] * ns[j] > 0)	f[i][j] = ns[i] * ns[j];
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
		
		/*
		 * 更改方法
		 */
		f = new int[n][2];
		f[0][0] = 0;
		f[0][1] = 0;
		
		for(int i = 1; i < n; i++){
			f[i][0] = Math.max(f[i-1][0], f[i-1][1]);
			f[i][1] = f[i-1][0] + ns[i-1] * ns[i];
		}
		
		System.out.println(Math.max(f[n-1][0], f[n-1][1]));
		
	}

}
