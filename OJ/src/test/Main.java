package test;

import java.util.Arrays;
import java.util.Scanner;

class Main{
	
	public static int[] ns;
	public static boolean[] bis;
	
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		ns = new int[n];
		bis = new boolean[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		Arrays.sort(ns);
		
		int count = 0;
		for(int i = n - 1; i >= 0; i--){
			if(bis[i])		continue;
			
			//boolean flag = false;
			int j = 0;
			for(; j < i; j++){
				if(!bis[j] && ns[j] + ns[i] <= w ){
					bis[j] = true;
					bis[i] = true;
					count++;
					//flag = true;
					break;
				}
			}
			if(j == i){
				bis[i] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}