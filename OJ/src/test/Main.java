package test;

import java.util.Scanner;

public class Main {

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
