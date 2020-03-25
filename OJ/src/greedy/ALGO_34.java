package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ALGO_34 {

	public static int[] ns;
	public static boolean[] bis;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int n = scan.nextInt();
		ns = new int[n];
		bis = new boolean[n];
		for (int i = 0; i < n; i++) {
			ns[i] = scan.nextInt();
		}
		Arrays.sort(ns);
		
		int ans = 0;
		for(int i = n - 1; i >= 0; i--){
			if(bis[i])		continue;//ns[i]已经被使用
			
			boolean flag = false;
			int j = 0;
			for(; j < i; j++){
				if(ns[j] + ns[i] == w){
					//找到两个元素 可以 分成一组
					bis[j] = true;
					bis[i] = true;
					System.out.println("打桩："+ns[i]+" and "+ns[j]);
					ans++;
					break;
				}else if(ns[j] + ns[i] > w || j == i - 1){
					
					while(--j >= 0){
						if(bis[j]){
							continue;
						}else{
							//a[j]和a[i]分成一组
							bis[j] = true;
							bis[i] = true;
							System.out.println("打桩："+ns[i]+" and "+ns[j]);
							flag = true;
							break;
						}
					}
			
					ans++;
					if(flag){
						break;
					}else{//a[i]不能和其他纪念品组合，只能单独分组
						bis[i] = true;
						System.out.println("打桩："+ns[i]);
						break;
					}
					
				}
			}
			
			if(j == i){
				ans++;
				bis[i] = true;
				System.out.println("打桩："+ns[i]);
			}
			
		}
		
		System.out.println(ans);
		
	}

}
