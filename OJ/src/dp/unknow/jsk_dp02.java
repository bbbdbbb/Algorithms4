package dp.unknow;

import java.util.Scanner;

/**   蒜头君爬楼梯(2)
		https://www.jisuanke.com/course/6497/341105
*    
* 项目名称：OJ   
* 类名称：jsk_dp02   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年4月15日 下午9:58:09   
* @version        
*/
public class jsk_dp02 {

	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n+10];
		ns[0] = 0;
		ns[1] = 1;
		ns[2] = 1;
		for(int i = 3; i <= n; i++){			
			for(int j = i - 1; j >= 0; j -= 2)
				ns[i] += ns[j];
			if(i % 2 == 1){//从0层可以直接跳上去
				ns[i]++;
			}
			ns[i] %= 100007; 
		}
		
		System.out.println(ns[n]);
	}

}
;