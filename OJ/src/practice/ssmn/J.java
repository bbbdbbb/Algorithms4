package practice.ssmn;

import java.util.LinkedList;
import java.util.Scanner;


public class J {

	private static int n;
	private static int[][] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ns = new int[n][3];
		for(int i = 0; i < n; i++){
			ns[i][0] = sc.nextInt();
			ns[i][1] = sc.nextInt();
			ns[i][2] = sc.nextInt();
		}
		
		LinkedList<int[]> q  = new LinkedList<int[]>();
		int ans = f(1,0,q);
		
		System.out.println(ans);
		
	}

	private static int f(int i, int sum, LinkedList<int[]> q) {

		
		if(i == n){
			return sum;
		}
		//相交就直接退出
		LinkedList<int[]> tem  = new LinkedList<int[]>();
		while(!q.isEmpty()){
			int[] item = q.poll();
			tem.add(item);
			//判断是否相交
			Math.sqrt((item[0] - ns[i][0])*(item[0] - ns[i][0]) + (item[1] - ns[i][1])*(item[1] - ns[i][1])) ;
			if(Math.sqrt((item[0] - ns[i][0])*(item[0] - ns[i][0]) + (item[1] - ns[i][1])*(item[1] - ns[i][1])) > item[2] + ns[i][2]){    
				return sum;
			}
		}
		
		
		int no = f(i+1,sum,tem);
		tem.add(ns[i]);
		int yes = f(i+1,sum+ns[i][2]*ns[i][2],tem);

		
		return Math.max(no,yes);
	}

}
