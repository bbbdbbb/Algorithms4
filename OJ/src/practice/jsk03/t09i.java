package practice.jsk03;

import java.util.Arrays;
import java.util.Scanner;

public class t09i {

	public static int[] nums;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		nums = new int[n];
		
		for(int i = 0; i < n; i++){
			nums[i] = scan.nextInt();
		}
		
		int sum = 0;
	
		while(n>1){
			int b = 0;
			int a = 0;
			Arrays.sort(nums);
			System.out.println(Arrays.toString(nums));
			for (int i = 0; i < nums.length; i++) {
				if(nums[i]==0)	continue;
				else{
					a = nums[i];
					b = nums[i+1];
					
					n--;
					nums[i] = 0;
					nums[i+1] = 0;
					
					nums[0] = a+b;
					sum += nums[0];
					break;
				}
			}
		}
		
		System.out.println(sum);
		
	}

}
