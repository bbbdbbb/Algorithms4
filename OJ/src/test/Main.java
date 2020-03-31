package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		
		int x = 2;
		int y = 3;
		f(x + y);
		
		//计时，在提交答案的时候要删除
		long endMili=System.currentTimeMillis();
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}

	private static void f(int i) {

		System.out.println(i);
	}


	
	
}