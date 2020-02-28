package recursion;

import java.util.Scanner;

/**   
* http://lx.lanqiao.cn/problem.page?gpid=T303   
* 项目名称：OJ   
* 类名称：ALGO_122   
* 类描述：   纯粹的递归题
* 	每天早上，租鞋窗口都会排起长龙，假设有还鞋的m个，有需要租鞋的n个。现在的问题是，这些人有多少种排法，
* 	可以避免出现体育组没有冰鞋可租的尴尬场面。（两个同样需求的人（比如都是租鞋或都是还鞋）交换位置是同一种排法）
* 样例(1)
*样例输入(1)
	· 3 2
*样例输出(1)
	· 5	
* 
* 创建人：bbbdbbb   
* 创建时间：2020年2月26日 下午5:35:54   
* @version        
*/
public class ALGO_122 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		int sum = count(m,n);
		System.out.print(sum);
	}

	
	private static int count(int m, int n) {
		
		if(m<n || m<0 || n<0)	return 0;
		if(m==1 && n==0) return 1;
		if(m==1 && n==1) return 1;		
		
		
		return count(m-1,n)+count(m,n-1);
	}


}
