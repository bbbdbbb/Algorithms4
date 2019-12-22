package chapter1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class X1_1_10_BinarySearch {

	public static void main(String[] args) {
		//int[] whitelist = In.readInts(args[0]);
		int[] whitelist = new int[args.length];
		for(int i=0;i<args.length;i++) {
			whitelist[i] = Integer.parseInt(args[i]);
		}
		Arrays.sort(whitelist);
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if(rank(key,whitelist)<0)
				StdOut.println(key+"...");
		}
	}
	
	public static int rank(int key,int[] a) {
		//����a[]�����������
		int lo = 0;
		int hi = a.length-1;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(key<a[mid])
				hi = mid-1;
			else if(key>a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
