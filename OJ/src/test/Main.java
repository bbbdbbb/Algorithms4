package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[] a = new int[n];
		boolean[] vis = new boolean[n];
		for(int i=0;i<n;i++){
			a[i] = scan.nextInt();
			vis[i] = false;
		}
		
		if(n/2<m)		System.out.print("Error!");
		else{
			int sum = 0;
			sum = f(a,vis,sum);
			
			System.out.println(sum);
		}
		



		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	private static int f(int[] a, boolean[] vis, int sum) {
		
		int len = vis.length;
		for (int i = 0; i < len; i++) {
			//i和i+1相邻，不符合条件
			if(vis[i] && vis[(i+1)%len])
				return sum;
		}
		
		int[] temp = new int[len];
		for (int i = 0; i < len; i++) {
			if(vis[i])		continue;
			vis[i] = true;
			temp[i] = f(a,vis,sum+a[i]);
			vis[i] = false;
			
		}
		Arrays.sort(temp);
		System.out.println(temp[len-1]);
		
		return temp[len-1];
	}

	
}
