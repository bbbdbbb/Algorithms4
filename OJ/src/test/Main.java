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
		
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		//long endMili=System.currentTimeMillis();
		//System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}
	
	public class node{
		public int k;
		public int a1;
		public int x;
		public int y;
		public int m;
	}
	
	//����node�ıȽ���
	public class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.a1 - o2.a1;
		}
		
	}
	
	
}