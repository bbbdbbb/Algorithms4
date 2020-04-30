package dp.bag;

import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�_01knapsack_optm   
* �������� ��01����������пռ��Ż�optimize  
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��30�� ����5:40:37   
* @version        
*/
public class _01knapsack_optm {

	private static int[] vs;
	private static int[] ws;
	private static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		ws = new int[N+1];
		vs = new int[N+1];
		for(int i = 1; i <= N; i++){
			ws[i] = sc.nextInt();
			vs[i] = sc.nextInt();
		}
		
		//dp
		dp = new int[W+1];
		for(int i = 1; i <= N; i++){
			for(int j = W; j >= ws[i]; j--){
				dp[j] = Math.max(dp[j], dp[j-ws[i]] + vs[i]);
			}
		}
		
		System.out.println(dp[W]);
	}

}
/*
---------------------
	input:
4 5
2 3
1 2
3 4
2 2
	output:
7
------------------------
	input:
4 5 
1 2 
2 4 
3 4
4 5
	output:
8
--------------------------- 
 */