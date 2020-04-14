package dp.unknow;

import java.util.Scanner;

/**   计蒜客学习中心 初始动态规划
 * 	弹簧板（加强）
 * 	https://www.jisuanke.com/course/6497/341106


	in:
5
1 1 1 1 1
	out:
5

	in:
5
5 4 3 2 1
	out:
1

   
* 项目名称：OJ   
* 类名称：jsk_dp03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月14日 下午1:53:25   
* @version        
*/
public class jsk_dp03 {

	private static int[] a;
	private static int[] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n+10];
		f = new int[n+10];
		for(int i = 1; i <= n; i++){
			a[i] = sc.nextInt();
		}
		
		f[n] = 1;
		int ans = 1;
		for(int i = n - 1; i >= 1; i--){
			if(a[i] > (n - i)){
				f[i] = 1;
			}else{
				f[i] = f[ i + a[i] ] + 1;
			}
			ans = Math.max(ans, f[i]);
		}
		System.out.println(ans);
	}

}
