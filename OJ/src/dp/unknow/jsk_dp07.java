package dp.unknow;

import java.util.Scanner;

/**  �����ѧϰ���� ��ʼ��̬�滮  
 * 	�������
 * 	https://www.jisuanke.com/course/6497/341110
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp07   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��15�� ����9:49:40   
* @version        
*/
public class jsk_dp07 {

	private static int[] ns;
	private static int[][] f;
	private static int[] S;
	private static int[][] m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n+10];
		//�ٷ��Ƽ�������
		S = new int[n+10];
		m = new int[n+10][n+10];
		for(int i = 1; i <= n; i++){
			m[i][i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++){
			for(int j = i + 1; j <= n; j++){
				m[i][j] = m[i][j-1] * m[j][j] % 1000;
			}
		}
		
		for(int i = 2; i <= n; i++){
			for(int j = 1; j <= i; j++){
				m[1][i] = Math.max(m[1][i], m[1][j-1] + m[j][i]);
			}
		}
		System.out.println(m[1][n]);
		
		//����dp������3��forѭ����O(n^3)
//		f = new int[n][n];
//		for(int i = 0; i < n; i++){
//			ns[i] = sc.nextInt();
//		}
//
//		//����ֵ
//		for(int i = 0; i < n; i++){
//			for(int j = i; j < n; j++){
//				if(i == j)		f[i][j] = ns[i];
//				else{
//					f[i][j] = ns[i];
//					for(int k = 1; k <= j - i; k++){
//						f[i][j] = f[i][j] * ns[i + k] % 1000;
//					}
//				}
//			}
//		}
//		
//		for(int len = 2; len < n; len++){
//			for(int i = 0; i < n - len; i++){
//				for(int k = 0; k < len; k++){
//					f[i][i+len] = Math.max(f[i][i+len], f[i][i+k] + f[i+k+1][i+len]);
//				}
//			}
//		}
//		
//		System.out.println(f[0][n-1]);
		
	}

}
