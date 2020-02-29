package recursion;

import java.util.Scanner;

/** 涉及搜索的 递归题，效率不行，超时了，需要改进
 * 
 * 算法提高 盾神与砝码称重
 * http://lx.lanqiao.cn/problem.page?gpid=T359  
*    
* 项目名称：OJ   
* 类名称：ADV_192   
* 题目描述：

	有一天，他在宿舍里无意中发现了一个天平！这个天平很奇怪，有n个完好的砝码，但是没有游码。盾神为他的发现兴奋不已！
于是他准备去称一称自己的东西。他准备好了m种物品去称。神奇的是，盾神一早就知道这m种物品的重量，他现在是想看看这个天平能不能称出这些物品出来。
但是盾神稍微想了1秒钟以后就觉得这个问题太无聊了，于是就丢给了你。

输入格式
　　第一行为两个数，n和m。
　　第二行为n个数，表示这n个砝码的重量。
　　第三行为m个数，表示这m个物品的重量。
输出格式
　　输出m行，对于第i行，如果第i个物品能被称出，输出YES否则输出NO。

样例输入
4 2
1 2 4 8
15 16
样例输出
YES
NO

样例输入
4 1
10 7 1 19
6
样例输出
YES

* 创建人：bbbdbbb   
* 创建时间：2020年2月29日 下午3:51:00   
* @version        
*/
public class ADV_192 {
	public static int[] a;
	public static int[] sum;
	public static boolean flag;
	
	public static void main(String[] args) {
		

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		a = new int[n];
		sum = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
			if(i!=0){
				sum[i] = sum[i-1]+a[i];
			}else{
				sum[0] = a[0];
			}
		}
		
		while(m--!=0){
			long startMili=System.currentTimeMillis();
			int s = scan.nextInt();
			flag = false;
			if(s<=0)	System.out.println("NO");
			else{
				dfs(s,n-1);
				if(flag)	System.out.println("YES");
				else		System.out.println("NO");
			}
			long endMili=System.currentTimeMillis();
			System.out.println("总耗时为："+(endMili-startMili)+"毫秒");

		}
		
		
		//计时，在提交答案的时候要删除

	}

	private static void dfs(int s, int i) {

		if(flag)	return;
		if(i<0)		return;
		if(Math.abs(s)>sum[i])	return;
		
		if(s==0 || Math.abs(s)==sum[i]){
			flag = true;
			return;
		}
		
		if(i<0)		return;
		dfs(s-a[i],i-1);
		dfs(s,i-1);
		dfs(s+a[i],i-1);
		return;
	}

}
