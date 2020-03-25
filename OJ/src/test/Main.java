package test;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		

		while(true){
			if(scan.nextInt() == 1){
				System.out.println("11111111");
			}else{
				System.out.println("22222");
			}

		
		}
		
		//计时，在提交答案的时候要删除
		//long endMili=System.currentTimeMillis();
		//System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
	}
	
	public class node{
		public int k;
		public int a1;
		public int x;
		public int y;
		public int m;
	}
	
	//创建node的比较器
	public class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.a1 - o2.a1;
		}
		
	}
	
	
}