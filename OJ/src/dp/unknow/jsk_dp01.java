package dp.unknow;

import java.util.Scanner;

public class jsk_dp01 {

	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n + 10];
		ns[1] = 1;
		ns[2] = 2;
		for(int i = 3; i <= n; i++){
			ns[i] = (ns[i - 1] + ns[i - 2]) % 100007;
		}
		System.out.println(ns[n]);
		
	}

}
