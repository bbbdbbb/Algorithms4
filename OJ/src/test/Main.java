package test;

import java.util.Arrays;
import java.util.Scanner;

class Main{
	
	public static int[] ns;
	public static boolean[] bis;
	
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);

		//测试 先赋值  在判断 是否  相等
		int x = -1;
		System.out.println(((x = 0) == 1) + "  x = " + x);
		System.out.println(((x = 2) == 2) + "  x = " + x);
	}
}