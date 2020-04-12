package practice.jsk05;

import java.util.Scanner;

/** 计蒜客模拟五    ---- 数学推算
 * 	煎牛排
 * 	https://www.jisuanke.com/course/6497/467057  
 * 
 	题目：
 一共需要煎 n 块牛排，牛排有两面，每面需要剪5分钟。现在有 k 个锅，每个锅一次只能煎两块牛排
 求 煎 n 块牛排所需的最少时间
 	输入： 
998244353  10    n ,  k
 	输出：
499122180

	输入：
30 10
	输出：
15

	输入：
1 10
	输出：
10


*    
* 项目名称：OJ   
* 类名称：t03   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月12日 下午10:38:57   
* @version        
*/
public class t03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = 0;
		
		/*
		 * 思路：
		 * 1.当 n <= 2k 时，锅虽然没有放满，也必须煎两次。 => t = 2次 * 5分钟
		 * 2.当 n  > 2k 时， 对n取2k的余有：n = s * 2k + m, 其中s是商，m是余数
		 * 	(1).当 m = 0 时，每次锅都能放满2k个牛排，没有操作空间。 => t = s * 2次 * 5分钟
		 *  (2).当 m <= k时， 余数m小于一次可以煎的牛排数量的一半，就拿2k个牛排出来凑数
		 *  	a.前面的 (s - 1) * 2k 个牛排就正常操作，耗时(s - 1) * 2次 * 5分钟
		 *  	b.煎2k 个牛排的正面，耗时5分钟
		 *  	c.煎m个牛排的正面，和2k-m 个牛排的反面，耗时5分钟
		 *  	d.煎剩余 2m 个牛排的反面， 耗时5分钟
		 *  	=> t = s * 2次 * 5分钟 + 5分钟
		 *  (3).当m > k 时，没有操作空间  => t = s * 2次 * 5分钟 + 10分钟
		 */
		if(n <= 2 * k){ // t = 2 * 5
			t = 2 * 5;
		}else{// n > 2k
			if(n % (2 * k) == 0){
				t = n / (2 * k) * 2 * 5;
			}else if(n % (2 * k) <= k){
				t = n / (2 * k) * 2 * 5 + 5;
			}else{
				t = n / (2 * k) * 2 * 5 + 10; 
			}
		}
		
		System.out.println(t);
		
	}

}
