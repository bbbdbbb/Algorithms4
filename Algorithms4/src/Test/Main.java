package Test;

import java.util.Random;

public class Main {

	 
	public static void main(String[] args) {
		
		Random random = new Random();
		for(int i=arr.length-1;i>=0;i--){
			//������ɵ��������Χ�ͱ��[0,i+1)
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
	
	private static String[] arr = {
			"��","�㷨","��","����","������","�����Ǹ����ϰ�","�Ҳ��Ǹ߾���","����","��f","����",
	};

}
