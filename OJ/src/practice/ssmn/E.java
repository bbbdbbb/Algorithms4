package practice.ssmn;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int cnt = 0;
		for(int i = 1; i <= n; i++){
			boolean flag = false;
			if(i % a == 0){
				cnt++;
				continue;
			}
			if(i % b == 0){
				cnt++;
				continue;
			}
			if(i % c == 0){
				cnt++;
				continue;
			}
		}
		
		System.out.println( n - cnt);
		
	}
}