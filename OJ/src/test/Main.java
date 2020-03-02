package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int m;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		m = scan.nextInt();
		
		int[] a = new int[n];
		boolean[] vis = new boolean[n];
		for(int i=0;i<n;i++){
			a[i] = scan.nextInt();
			vis[i] = false;
		}
		
		if(n==1 && m==1) 	System.out.print(a[0]);
		else if(n/2<m)		System.out.print("Error!");
		else{
			int sum = 0;
			sum = f(a,vis,sum,-1);
			
			System.out.println(sum);
		}
		



		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	private static int f(int[] a, boolean[] vis, int sum,int index) {
		
		if(index == -1){
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
				temp[i] = f(a,vis,sum,i);
				vis[i] = false;
				
			}
			Arrays.sort(temp);
			
			
			return temp[len-1];
		}else{
			int len = vis.length;
			for (int i = 0; i < len; i++) {
				//i和i+1相邻，不符合条件
				if(vis[i] && vis[(i+1)%len])
					return sum;
			}
			

			
			sum = sum + a[index];
			//System.out.println(sum);
			
			int count = 0;
			for (int i = 0; i < len; i++) {
				if(vis[i])		count++;		
			}
			if(count==m){
				return sum;
			}

			int[] temp = new int[len];
			for (int i = 0; i < len; i++) {
				if(vis[i])		continue;
				vis[i] = true;
				temp[i] = f(a,vis,sum,i);
				vis[i] = false;
				
			}
			Arrays.sort(temp);
		
			
			return temp[len-1];
		}


	}

	
}
