package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] pazz;


	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		pazz = new int[m];
		
		int sum = 0;
		for(int j = 0; j < m; j++){
			pazz[j] = scan.nextInt();
			sum += pazz[j];
		}
		Arrays.sort(pazz);
		
		int max = sum / n;
		int i = max;
		for(; i > 0; i--){
			int count = 0;
			for(int j = m-1; j >= 0; j--){
				count = count + pazz[j] / i;
//				if(i > pazz[j]){
//					break;
//				}
			}
			if(count >= n){
				System.out.println(i);
				break;
			}
		}
		if(i == 0){
			System.out.println(0);
		}
		
		scan.close();
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

}