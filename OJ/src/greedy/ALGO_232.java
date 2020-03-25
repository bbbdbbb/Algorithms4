package greedy;

import java.util.Scanner;

/** 简单的贪心算法，不用复习
 *  算法训练 找零钱   
 *  http://lx.lanqiao.cn/problem.page?gpid=T586
*    
* 项目名称：OJ   
* 类名称：ALGO_232   
* 类描述：   
* 创建人：bbbdbbb   
* 创建时间：2020年3月24日 下午9:11:22   
* @version        
*/
public class ALGO_232 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();

		int m25=0,m50=0;
		for (int i = 0; i < n; i++) {
			if(m25 < 0){
				break;
			}
			
			int num = scan.nextInt();
			//System.out.println(num);
			if(num == 25){
				m25++;
			}else if(num == 50){
				m50++;
				m25--;
			}else if(num == 100){
				if(m50 > 0){//至少有一张50
					m50--;
					m25--;
				}else{//一张50的都没有，只能补3张25
					m25 -= 3;
				}
			}
		}
		
		
		if(m25 < 0)		System.out.println("NO");
		else			System.out.println("YES");
		
	}

}
