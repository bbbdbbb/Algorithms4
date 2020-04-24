package greedy;

import java.util.Scanner;

/** 贪心算法（贪心的那部分虽然简单，但是细节非常多，需要非常仔细的思考）
 *  算法训练 最大最小公倍数
 *  ALGO-2
 *  http://lx.lanqiao.cn/problem.page?gpid=T12 
*    
* 项目名称：OJ   
* 类名称：ALGO_2   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月24日 下午8:10:12   
* @version        
*/
public class ALGO_2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long n = scan.nextInt();
		/*
		 * n有两种情况：
		 * 		1. n为奇数：
		 * 			n,n-1和n-2就分别为奇偶奇，没有公因数2和3，所以最大的最小公倍数为3者乘积n*(n-1)*(n-2)
		 * 		1. n为偶数：
		 * 			(1) n,n-1和n-2就分别为偶奇偶，n和n-2有一个公因数2，所以这3个的最大的最小公倍数是(n*(n-1)*(n-2))/2，此时结果肯定不是最大的，要计算其他情况；
		 * 			(2) n,n-1和n-2不行，就试试n,n-1和n-3，他们分别为偶奇奇，没有公因数2。容易忽略的是，n和n-3可能有公因数3（注意！！！）
		 * 				<1>	n和n-3不是3的倍数，(2)的最大的最小公倍数就是n*(n-1)*(n-3)
		 * 				<2> n和n-3是3的倍数,此时(2)的最大的最小公倍数就是(n*(n-1)*(n-3))/3,此时结果肯定不是最大的，要计算其他情况；n*(n-1)*(n-5) 可以证明小于(n-1)*(n-2)*(n-3) 
		 * 			(3) 放弃n，从n-1开始取3个数：n-1,n-2和n-3，分别为奇偶奇，等同于第1中情况，所以最大的最小公倍数就是(n-1)*(n-2)*(n-3)
		 */
		if(n<=2)				System.out.println(n);
		else if(n%2 == 1)		System.out.println(n*(n-1)*(n-2));
		else if(n%3 == 0)		System.out.println((n-1)*(n-2)*(n-3));
		else 					System.out.println(n*(n-1)*(n-3));

	}
}
