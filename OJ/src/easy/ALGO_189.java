package easy;

import java.util.Scanner;

/**   
* 算法训练 P0505
* http://lx.lanqiao.cn/problem.page?gpid=T512
*    
* 项目名称：OJ   
* 类名称：ALGO_189   
* 
* 题目描述：
* 一个整数n的阶乘可以写成n!，它表示从1到n这n个整数的乘积。阶乘的增长速度非常快，例如，13！就已经比较大了，已经无法存放在一个整型变量中；
* 而35！就更大了，它已经无法存放在一个浮点型变量中。因此，当n比较大时，去计算n!是非常困难的。幸运的是，在本题中，我们的任务不是去计算n!，
* 而是去计算n!最右边的那个非0的数字是多少。例如，5！=1*2*3*4*5=120，因此5!最右边的那个非0的数字是2。再如，7！=5040，
* 因此7！最右边的那个非0的数字是4。再如，15！= 1307674368000，因此15！最右边的那个非0的数字是8。请编写一个程序，
* 输入一个整数n(0<n<=100)，然后输出n!最右边的那个非0的数字是多少。   
** 样例
*样例输入
	> 7
*样例输出
	> 4	
* 
* 创建人：bbbdbbb   
* 创建时间：2020年2月27日 下午12:05:00   
* @version        
*/
public class ALGO_189 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		long n = scan.nextInt();
		long end = 1;
		
		for(int i=1;i<=n;i++){
			end *= i;
			while(end%10==0){
				end = end / 10;
			}
			end = end % 1000;
		}
		
		System.out.print(end%10);
	}
}
