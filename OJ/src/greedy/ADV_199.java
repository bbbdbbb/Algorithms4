package greedy;

import java.util.Arrays;
import java.util.Scanner;

/** 贪心算法，思路简单，暴力，后期可以考虑代码优化；无解输出-1，没有解决
 * ADV-199
 *  算法提高 线段和点
 *  http://lx.lanqiao.cn/problem.page?gpid=T367  
问题描述
　　有n个点和m个区间，点和区间的端点全部是整数，对于点a和区间[b,c]，若a>=b且a<=c，称点a满足区间[b,c]。
　　求最小的点的子集，使得所有区间都被满足。
输入格式
　　第一行两个整数n m
　　以下n行 每行一个整数，代表点的坐标
　　以下m行 每行两个整数，代表区间的范围
输出格式
　　输出一行，最少的满足所有区间的点数，如无解输出-1。
样例输入
5 5
2
6
3
8
7
2 5
3 4
3 3
2 7
6 9
样例输出
2
* 项目名称：OJ   
* 类名称：ADV_199   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月27日 下午11:09:50   
* @version        
*/
public class ADV_199 {

	private static int[] ns;
	private static int[] ms2;
	private static int[] ms1;
	private static boolean[] bis;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		bis = new boolean[m];
		ns = new int[n];
		ms1 = new int[m];
		ms2 = new int[m];
		for(int i = 0; i < n; i++){
			ns[i] = scan.nextInt();
		}
		for(int i = 0; i < m; i++){
			ms1[i] = scan.nextInt();
			ms2[i] = scan.nextInt();
		}
		Arrays.sort(ns);
		
		int ans = 0;
		boolean flag = true;
		while(flag){
			int i = 0;
			for(; i < m; i++){
				if(bis[i] == false)		break;
			}
			if(i == m){//全部区间都被满足
				flag = false;
				continue;
			}
			
			int min = -1;
			//找最先结束的 区间
			for(int j = 0; j < m; j++){
				if(!bis[j] && ( min == -1 || ms2[j] < ms2[min])){//判断顺序不能变
					min = j;
				}
			}
			//找值最大的一个点满足区间min，
			int max = n -1;
			for(; max >= 0; max--){
				if(ns[max] <= ms2[min]){
					break;
				}
			}
			
			//将所有包含 点max的区间设置为true
			for(int j = 0; j < m; j++){
				if(!bis[j] && ms1[j] <= ns[max] && ms2[j] >= ns[max]){//区间j未被满足，且点在区间内
					bis[j] = true;
				}
			}
			
			ans++;
		}
		
		
		System.out.println(ans);
		
	}

}
