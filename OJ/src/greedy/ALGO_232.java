package greedy;

import java.util.Scanner;

/** �򵥵�̰���㷨�����ø�ϰ
 *  �㷨ѵ�� ����Ǯ   
 *  http://lx.lanqiao.cn/problem.page?gpid=T586
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_232   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��24�� ����9:11:22   
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
				if(m50 > 0){//������һ��50
					m50--;
					m25--;
				}else{//һ��50�Ķ�û�У�ֻ�ܲ�3��25
					m25 -= 3;
				}
			}
		}
		
		
		if(m25 < 0)		System.out.println("NO");
		else			System.out.println("YES");
		
	}

}
