package dp.unknow;

import java.util.Arrays;
import java.util.Scanner;

/**   计蒜客学习中 动态规划基础
 * 	过河
 * 	https://www.jisuanke.com/course/6497/341112
*    
* 项目名称：OJ   
* 类名称：jsk_dp09   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月16日 下午3:23:13   
* @version        
*/
public class jsk_dp09 {

	private static int[] f;
	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f = new int[n];
		ns = new int[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		Arrays.sort(ns);
		for(int itm : ns){
			System.out.println(itm);
		}
		
		f[0] = ns[0];
		f[1] = ns[1];
		f[2] = ns[0] + ns[1] + ns[2];
		for(int i = 3; i < n; i++){
			f[i] = Math.min(f[i-2] + ns[1] + ns[i] + ns[0] + ns[1], f[i-1] + ns[i] + ns[0]);
		}
		
		System.out.println(f[n-1]);
	}

}
