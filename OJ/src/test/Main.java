package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		
		int end = f(chs1,0,chs2,0);		
		System.out.print(end);

	}

	private static int f(char[] chs1, int i, char[] chs2, int j) {
		
		//µİ¹éÖÕÖ¹Ìõ¼ş
		if(i==chs1.length || j==chs2.length)	return 0;
		else if(chs1[i] == chs2[j])				return f(chs1,i+1,chs2,j+1)+1;
		else									return Math.max(f(chs1,i+1,chs2,j), f(chs1,i,chs2,j+1));

	}

}
