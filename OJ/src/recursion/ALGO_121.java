package recursion;

import java.util.Scanner;

/** 
 * 算法训练 猴子分苹果
 * http://lx.lanqiao.cn/problem.page?gpid=T302  
*    
* 项目名称：OJ   
* 类名称：ALGO_121   
* 题目描述：  递推
* 		秋天到了，n只猴子采摘了一大堆苹果放到山洞里，约定第二天平分。这些猴子很崇拜猴王孙悟空，所以都想给他留一些苹果。
* 		第一只猴子悄悄来到山洞，把苹果平均分成n份，把剩下的m个苹果吃了,然后藏起来一份，最后把剩下的苹果重新合在一起。
* 		这些猴子依次悄悄来到山洞，都做同样的操作，恰好每次都剩下了m个苹果。第二天，这些猴子来到山洞，把剩下的苹果分成n分，
* 		巧了，还是剩下了m个。问，原来这些猴子至少采了多少个苹果。 
** 样例
*样例输入
	> 5 1
*样例输出
	> 15621	
* 
* 创建人：bbbdbbb   
* 创建时间：2020年2月27日 下午9:35:35   
* @version        
*/
public class ALGO_121 {
	/**
	 * 方法一：李政道教授的那道猴子分桃算术题
	 * https://wenku.baidu.com/view/d0adc98f680203d8ce2f2455.html
	 * https://blog.csdn.net/Z_122113/article/details/104456530
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int sum = (int) (Math.pow(n, n+1) - (n-1)*m);
		
		System.out.print(sum);

	}
}
