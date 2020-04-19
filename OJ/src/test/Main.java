package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static Set<String> hs = new HashSet<String>();
	private static int[] nums;



	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);

		
		System.out.println(Integer.MAX_VALUE);
		
		
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}



	private static void f(int num) {

		int ans = 0;
		int cnt = 0;
		for(int i = num / 2; i <= num; i++){
			
			int tem = 0;
			for(int j = 1; j <= Math.sqrt(i); j++){
				if(i % j == 0){ // i 可以整除 j
					if(j * j == i){
						tem++;
					}else{
						tem += 2;
					}
					
				}
			}
			if(tem > cnt){
				ans = i;
				cnt = tem;
			}
			
		}
		System.out.println(ans);
		
	}

	
	

	
}