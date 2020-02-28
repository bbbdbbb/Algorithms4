package recursion;

import java.util.Scanner;

/**   
 * 算法训练 瓷砖铺放
 * http://lx.lanqiao.cn/problem.page?gpid=T55
*    
* 项目名称：OJ   
* 类名称：ALGO_11   
* 类描述：一道简单的递归题
* 
   　有一长度为N(1<=Ｎ<=10)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，数目不限。要将这个长度为N的地板铺满，一共有多少种不同的铺法？
　　例如，长度为4的地面一共有如下5种铺法：
　　4=1+1+1+1
　　4=2+1+1
　　4=1+2+1
　　4=1+1+2
　　4=2+2
*
* 创建人：bbbdbbb   
* 创建时间：2020年2月28日 下午8:05:26   
* @version        
*/
public class ALGO_11 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int end = f(n);
		
		System.out.print(end);

	}

	private static int f(int n) {
		
		if(n==1)		return 1;
		else if(n==2)	return 2;
		else			return f(n-1)+f(n-2);
	}

}
