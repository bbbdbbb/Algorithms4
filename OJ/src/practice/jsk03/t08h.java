package practice.jsk03;

import java.util.Arrays;
import java.util.Scanner;

public class t08h {

	public static int[] pazz;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		pazz = new int[m];
		
		int sum = 0;
		for(int j = 0; j < m; j++){
			pazz[j] = scan.nextInt();
			sum += pazz[j];
		}
		Arrays.sort(pazz);
		
		int max = sum / n;
		int i = max;
		for(; i > 0; i--){
			int count = 0;
			for(int j = m-1; j >= 0; j--){
				count = count + pazz[j] / i;
				
				if(i > pazz[j]){//剪枝，必不可少
					break;
				}
			}
			if(count >= n){
				System.out.println(i);
				break;
			}
		}
		if(i == 0){
			System.out.println(0);
		}
	}

}
