package dp.unknow;

import java.util.Scanner;

/**	�����ѧϰ���� ��ʼ��̬�滮 
 * 	һά������
 *  https://www.jisuanke.com/course/6497/341109
 *  
 *  
 *    
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp06   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��15�� ����3:33:38   
* @version        
*/
public class jsk_dp06 {

	private static int[] ns;
	private static int[][] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ns = new int[n];
		//f = new int[n][n];	//f[9000][9000]���³��ڴ���
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		
		/*
		 ## 3��ѭ�������ڴ棬��ʱ
		 */
		//����ֵ
//		for(int i = 0; i < n; i++){
//			for(int j = i; j < n; j++){
//				if(i == j)		f[i][j] = 0;
//				if(i == j - 1 && ns[i] * ns[j] > 0)	f[i][j] = ns[i] * ns[j];
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
		
		/*
		 * ���ķ���
		 */
		f = new int[n][2];
		f[0][0] = 0;
		f[0][1] = 0;
		
		for(int i = 1; i < n; i++){
			f[i][0] = Math.max(f[i-1][0], f[i-1][1]);
			f[i][1] = f[i-1][0] + ns[i-1] * ns[i];
		}
		
		System.out.println(Math.max(f[n-1][0], f[n-1][1]));
		
	}

}
