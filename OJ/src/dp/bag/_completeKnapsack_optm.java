package dp.bag;

import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�_completeKnapsack_optm   
* ����������ȫ�������� �� �ռ��Ż�   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��30�� ����9:54:56   
* @version        
*/
public class _completeKnapsack_optm {

	private static int[] ws;
	private static int[] vs;
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
			for(int j = ws[i]; j <= W; j++){
				dp[j] = Math.max(dp[j], dp[j-ws[i]] + vs[i]);
			}
		}
		
		//output
		System.out.println(dp[W]);
		
	}
}
/*
---------------------
	input:
3 7
3 4
4 5
2 3
	output:
10
------------------------
	input:
4 5 
1 2 
2 4 
3 4
4 5
	output:
10
--------------------------- 
 */