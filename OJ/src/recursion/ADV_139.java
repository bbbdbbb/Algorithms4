package recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 递归题，逻辑写的很乱，结果超时。需要优化代码 这题涉及最优解，等学了动态规划在回来优化代码 算法提高 种树
 * http://lx.lanqiao.cn/problem.page?gpid=T282
 * 
 * 项目名称：OJ 类名称：ADV_139 题目描述：
 * 
 * A城市有一个巨大的圆形广场，为了绿化环境和净化空气，市政府决定沿圆形广场外圈种一圈树。园林部门 得到指令后，
 * 初步规划出n个种树的位置，顺时针编号1到n。并且每个位置都有一个美观度Ai，如果在这里种树就可以得到这Ai的美观度。 但由于A城市土壤
 * 肥力欠佳，两棵树决不能种在相邻的位置（i号位置和i+1号位置叫相邻位置。值得注意的是1号和n号也算相邻位置！）。
 * 最终市政府给园林部门提供了m棵树苗并要求全部种上，请你帮忙设计种树方案使得美观度总和最大。如果无法将m棵树苗全部种上，给出无解信息。
 * 
 * 样例输入 > 7 3 > 1 2 3 4 5 6 7 样例输出 > 15
 * 
 * 样例输入 > 7 4 > 1 2 3 4 5 6 7 样例输出 > Error!
 * 
 * 
 * 创建人：bbbdbbb 创建时间：2020年3月2日 下午3:03:13
 * 
 * @version
 */
public class ADV_139 {
	public static int m;

	public static void main(String[] args) {
		long startMili = System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		m = scan.nextInt();

		int[] a = new int[n];
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			vis[i] = false;
		}

		if (n == 1 && m == 1)
			System.out.print(a[0]);
		else if (n / 2 == m && n % 2 == 0) {
			int odd = 0;
			int even = 0;
			for (int i = 0; i < a.length; i++) {
				if (i % 2 == 0) {
					even += a[i];
				} else {
					odd += a[i];
				}
			}
			System.out.print(Math.max(odd, even));
		} else if (n / 2 < m)
			System.out.print("Error!");
		else {
			int sum = 0;
			// 开始递归
			sum = f(a, vis, sum);

			System.out.println(sum);
		}

		// 计时，在提交答案的时候要删除
		long endMili = System.currentTimeMillis();
		System.out.println("\n总耗时为：" + (endMili - startMili) + "毫秒");
	}

	private static int f(int[] a, boolean[] vis, int sum) {

		int len = vis.length;

		int count = 0;
		for (int i = 0; i < len; i++) {
			if (vis[i])
				count++;
		}
		if (count == m) {
			return sum;
		}
		
		int[] temp = new int[len];
		if(count==0){
			for (int i = 0; i < len-m; i++) {
				if (vis[(i - 1 + len) % len] || vis[i] || vis[(i + 1) % len])
					continue;
				vis[i] = true;
				temp[i] = f(a, vis, sum+a[i]);
				vis[i] = false;
			}
		}else{
			for (int i = 0; i < len; i++) {
				if (vis[(i - 1 + len) % len] || vis[i] || vis[(i + 1) % len])
					continue;
				vis[i] = true;
				temp[i] = f(a, vis, sum+a[i]);
				vis[i] = false;
			}
		}

		Arrays.sort(temp);

		return temp[len - 1];

	}

}
