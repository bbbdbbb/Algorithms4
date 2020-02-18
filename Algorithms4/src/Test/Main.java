package Test;

import java.util.Random;

public class Main {

	 
	public static void main(String[] args) {
		String[] arr = {
				"我","算法","高","高世","高世杰","付易是个大老板","我不是高镜淞","代代","老f","哈哈",
		};
		Random random = new Random();
		for(int i=arr.length-1;i>=0;i--){
			swap(arr,i,random.nextInt(i+1));
		}
		
		for(int i=0;i<arr.length;i++){
			if(i%3==0)		System.out.println();
			System.out.print(arr[i]+"   ");
			
		}
	}
	
	public static void swap(String[] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
