package practice.jsk05;

import java.util.Arrays; 
import java.util.Scanner;

public class t08 {

	private static int[] ns;
	private static int[] ms;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- != 0){
			int n = sc.nextInt();
			ns = new int[n];
			int m = sc.nextInt();
			ms = new int[m];
			for(int i = 0; i < n; i++){
				ns[i] = sc.nextInt();
			}
			for(int i = 0; i < m; i ++){
				ms[i] = sc.nextInt();
			}
			Arrays.sort(ns);
			
			int j = 1;
			for(;j < n; j++){
				if(!f(ns[j],j)){
					break;
				}
			}
			if(j == n){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
			
		}//while(T-- != 0)
		
		
		
	}

	private static boolean f(int num, int j) {
		
		boolean flag = false;
		
		
		return flag;
	}





}
