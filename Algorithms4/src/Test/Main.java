package Test;

import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	//快排
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>(); 
		
		while(true){
			int num = scan.nextInt();
			if(num==0)		break;
			queue.add(num);
		}
		int[] a = new int[queue.size()];
		for(int i=0;i<a.length;i++){
			a[i] = queue.poll();
		}
		
		sort(a,0,a.length-1);
		
		for(int num : a){
			System.out.print(num+" ");
		}
	}

	
	private static void sort(int[] a, int lo, int hi) {
		
		if(hi<=lo)		return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}


	//快排的切分函数
	private static int partition(int[] a,int lo,int hi){
		
		int i=lo;
		int j=hi+1;
		int v=a[lo];
		
		while(true){
			while(a[++i]<v)	if(i==hi) break;
			while(v<a[--j])	if(j==lo) break;
			if(i>=j)	break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		int temp = a[j];
		a[j] = a[lo];
		a[lo] = temp;
		
		return j;
	}
}
