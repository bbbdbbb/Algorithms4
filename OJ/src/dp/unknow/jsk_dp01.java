package dp.unknow;

import java.util.Scanner;

/**   
 *  蒜头君爬楼梯(1)
 *  https://www.jisuanke.com/course/6497/341110
*    
* 项目名称：OJ   
* 类名称：jsk_dp01   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月14日 下午9:53:22   
* @version        
*/
public class jsk_dp01 {

	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n + 10];
		ns[1] = 1;
		ns[2] = 2;
		for(int i = 3; i <= n; i++){
			ns[i] = (ns[i - 1] + ns[i - 2]) % 100007;
		}
		System.out.println(ns[n]);
		
	}

}
