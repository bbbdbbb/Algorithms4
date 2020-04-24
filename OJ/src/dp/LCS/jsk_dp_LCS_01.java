package dp.LCS;

import java.util.Scanner;

/** �����ѧϰ����    ����������кͱ༭����
 * 	�����������
 * 	https://www.jisuanke.com/course/6497/341119  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp_LCS_01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��19�� ����4:37:17   
* @version        
*/
public class jsk_dp_LCS_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		int[][] dp = new int[a.length + 10][b.length + 10];
		
		int n = a.length;
		int m = b.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(a[i] == b[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
				}else{
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
	}

}
