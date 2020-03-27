package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ADV_199 {

	private static int[] ns;
	private static int[] ms2;
	private static int[] ms1;
	private static boolean[] bis;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		bis = new boolean[m];
		ns = new int[n];
		ms1 = new int[m];
		ms2 = new int[m];
		for(int i = 0; i < n; i++){
			ns[i] = scan.nextInt();
		}
		for(int i = 0; i < m; i++){
			ms1[i] = scan.nextInt();
			ms2[i] = scan.nextInt();
		}
		Arrays.sort(ns);
		
		int ans = 0;
		boolean flag = true;
		while(flag){
			int i = 0;
			for(; i < m; i++){
				if(bis[i] == false)		break;
			}
			if(i == m){//全部区间都被满足
				flag = false;
				continue;
			}
			
			int min = -1;
			//找最先结束的 区间
			for(int j = 0; j < m; j++){
				if(!bis[j] && ( min == -1 || ms2[j] < ms2[min])){//判断顺序不能变
					min = j;
				}
			}
			//找值最大的一个点满足区间min，
			int max = n -1;
			for(; max >= 0; max--){
				if(ns[max] <= ms2[min]){
					break;
				}
			}
			
			//将所有包含 点max的区间设置为true
			for(int j = 0; j < m; j++){
				if(!bis[j] && ms1[j] <= ns[max] && ms2[j] >= ns[max]){//区间j未被满足，且点在区间内
					bis[j] = true;
				}
			}
			
			ans++;
		}
		
		
		System.out.println(ans);
		
	}

}
