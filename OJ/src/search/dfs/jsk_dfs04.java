package search.dfs;

import java.util.Scanner;

/** 深搜的剪枝策略
 * 	找数字
 * 	https://www.jisuanke.com/course/6497/341234
 * 	思路：
 * 	先利用Integer的toBinaryString()的方法,将数字temp转化成二进制
 * 	再利用String 的 parseInt()方法，将二进制的字符串转化成数字（二进制‘1011’直接就变成了十进制的‘1011’—— 一千零一十一，而不是‘11’）
 * 	最后判断能否被n整除，能就停止while循环 
*    
* 项目名称：OJ   
* 类名称：jsk_dfs04   
* 类描述： 计蒜客学习中心  深搜的剪枝策略  第一题  找数字  
* 创建人：bbbdbbb   
* 创建时间：2020年4月3日 下午4:05:07   
* @version        
*/
public class jsk_dfs04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp = 1;
		
		String bStr = Integer.toBinaryString(temp);
		
		while(Integer.parseInt(bStr) % n != 0){
			temp ++;
			bStr = Integer.toBinaryString(temp);
		}
		
		System.out.println(bStr);
		
	}

}
