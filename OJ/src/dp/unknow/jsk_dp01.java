package dp.unknow;

import java.util.Scanner;

/**   
 *  ��ͷ����¥��(1)
 *  https://www.jisuanke.com/course/6497/341110
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��14�� ����9:53:22   
* @version        
*/
public class jsk_dp01 {

	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n + 10];
		ns[1] = 1;
		ns[2] = 2;
		for(int i = 3; i <= n; i++){
			ns[i] = (ns[i - 1] + ns[i - 2]) % 100007;
		}
		System.out.println(ns[n]);
		
	}

}
