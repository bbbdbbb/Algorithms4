package search.dfs;

import java.util.Scanner;

public class jsk_dfs06_cut {
	
	private static long[] zys = new long[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	private static int n;
	private static long[] ns;
	private static int[] zysCnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ns = new long[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextLong();
		}
		for(int i = 0; i < n; i++){
			
			long ans = 0;
			int ansCnt = 0;
			for(long k = ns[i] / 2; k <= ns[i]; k++){
				zysCnt = new int[15];
				dfs(k,0);
				
				int tem = 1;
				for(int j = 0; j < 15; j++){
					tem = tem * (zysCnt[j] + 1);
				}
				
				if(tem > ansCnt){
					ansCnt = tem;
					ans = k;
				}
			}
			
			

			System.out.println(ans);
			
			//test
//			System.out.print(ns[i] + ":  ");
//			for(int j = 0; j < 15; j++){
//				System.out.print(zysCnt[j] + " ");
//			}
//			System.out.println();
		}
	}

	private static void dfs(long num, int index) {

		if(num == 1){
			return;
		}
		
		for(int i = index; i < n; i++){
			if(num % zys[i] == 0){
				zysCnt[i]++;
				dfs(num / zys[i],index);
				return;
			}
		}
	}

}
