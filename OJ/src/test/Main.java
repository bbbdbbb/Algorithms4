package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		char[] chs = new char[N];
		for(int i = 0; i < N; i++){
			
			chs[i] = scan.next().charAt(0);
			System.out.println(chs[i]+""+i);
			scan.nextLine();
		}
		
		int pri = 0;
		int end = N-1;
		//̰��ѡ�񣬴�ͷ��β��ѡ��һ���ֵ�����С������ĸ
		while(pri <= end){
			boolean left = false;//�ж� ��ȡ ͷ����β��������ĸ
			
			for(int i = 0; pri + i <= end; i++){
				if(chs[pri] < chs[end]){
					left = true;//��ȡ ͷ��������ĸ
					break;
				}else if(chs[pri] > chs[end]){
					left = false;
					break;
				}

			}
			
			
			if(left)	System.out.print(chs[pri++]);
			else		System.out.print(chs[end--]);
		}
		
		
		scan.close();
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

}