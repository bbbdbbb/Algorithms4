package search.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 计蒜客学习中心   dfs剪枝
 * 	《因数最多的数》
 * 	 https://www.jisuanke.com/course/6497/341236
 *
	输入：
3
10
100
1000

	输出：
6
60
840

*	在没有剪枝的情况下，可以满足测试案例，但是当数据量变大后会严重超时
*    
*    
* 项目名称：OJ   
* 类名称：jsk_dfs06   
* 创建人：bbbdbbb   
* 创建时间：2020年4月8日 上午10:38:31   
* @version        
*/
public class jsk_dfs06 {

	public static Set<String> hs = new HashSet<String>();
	private static int[] nums;



	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		nums = new int[n];
		
		for(int i = 0; i < n; i++){
			nums[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++){
			f(nums[i]);
		}
		
		
	
	}



	private static void f(int num) {

		int ans = 0;
		int cnt = 0;
		for(int i = num / 2; i <= num; i++){
			
			int tem = 0;
			for(int j = 1; j <= Math.sqrt(i); j++){
				if(i % j == 0){ // i 可以整除 j
					if(j * j == i){
						tem++;
					}else{
						tem += 2;
					}
					
				}
			}
			if(tem > cnt){
				ans = i;
				cnt = tem;
			}
			
		}
		System.out.println(ans);
		
	}

	
	

	
}
