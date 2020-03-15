package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int[] pazz;


	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		
		Queue<Integer> q=new PriorityQueue<>();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(1);
		while(!q.isEmpty())
        {
            int n=q.poll();
            System.out.println(n);
        }
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(scan.nextInt());
		}
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext())
        {
			int nnn = set.size();
            System.out.println(it.next());
        }
		
		scan.close();
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

}