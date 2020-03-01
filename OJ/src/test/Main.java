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
		



		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

	private static int f(int[] a, boolean[] vis, int sum) {
		
		int len = vis.length;
		for (int i = 0; i < len; i++) {
			//i��i+1���ڣ�����������
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
