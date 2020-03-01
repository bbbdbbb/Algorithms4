package recursion;

import java.util.Arrays;
import java.util.Scanner;

/** 递归
 * 算法提高 数字黑洞
 * http://lx.lanqiao.cn/problem.page?gpid=T324   
*    
* 项目名称：OJ   
* 类名称：ADV_170   
* 问题描述：   

　    任意一个四位数，只要它们各个位上的数字是不全相同的，就有这样的规律：
　　1)将组成该四位数的四个数字由大到小排列，形成由这四个数字构成的最大的四位数；
　　2)将组成该四位数的四个数字由小到大排列，形成由这四个数字构成的最小的四位数(如果四个数中含有0，则得到的数不足四位)；
　　3)求两个数的差，得到一个新的四位数(高位零保留)。
　　重复以上过程，最后一定会得到的结果是6174。
　　比如：4312 3087 8352 6174，经过三次变换，得到6174

	样例输入（一个四位整数，输入保证四位数字不全相同）
		4312
	样例输出
		3

* 创建人：bbbdbbb   
* 创建时间：2020年3月1日 下午8:48:56   
* @version        
*/
public class ADV_170 {
	public static 	int count = 0;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		
		while(n!=6174){
			 n = f(n);
			++count;
		}
		System.out.print(count);

		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	private static int f(int n) {
		int[] num = new int[4];
		for(int i=3;i>=0;i--){
			num[i] = n%10;
			n = n/10;
		}
		Arrays.sort(num);
		int max = 0;
		int min = 0;
		for (int i = 0; i < num.length; i++) {
			min *= 10;
			min = min + num[i];
		}
		for (int i = 3; i >= 0; i--) {
			max *= 10;
			max = max + num[i];
		}
		
		
//		System.out.println(min);
//		System.out.println(max);

//		System.out.println("n="+n);
		return max-min;
	}

}
