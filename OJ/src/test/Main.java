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
		
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

	private static void f(int i) {

		System.out.println(i);
	}


	
	
}