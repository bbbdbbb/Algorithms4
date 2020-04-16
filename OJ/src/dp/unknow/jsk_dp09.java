package dp.unknow;

import java.util.Arrays;
import java.util.Scanner;

/**   �����ѧϰ�� ��̬�滮����
 * 	����
 * 	https://www.jisuanke.com/course/6497/341112
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp09   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��16�� ����3:23:13   
* @version        
*/
public class jsk_dp09 {

	private static int[] f;
	private static int[] ns;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f = new int[n];
		ns = new int[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		Arrays.sort(ns);
		for(int itm : ns){
			System.out.println(itm);
		}
		
		f[0] = ns[0];
		f[1] = ns[1];
		f[2] = ns[0] + ns[1] + ns[2];
		for(int i = 3; i < n; i++){
			f[i] = Math.min(f[i-2] + ns[1] + ns[i] + ns[0] + ns[1], f[i-1] + ns[i] + ns[0]);
		}
		
		System.out.println(f[n-1]);
	}

}
