package recursion;

import java.util.Scanner;

/**   
* http://lx.lanqiao.cn/problem.page?gpid=T559   
* 项目名称：OJ   
* 类名称：ADV_292   
* 类描述：   有难度的  递归题  需要线性代数的基本知识      —— 计算行列式 
* 创建人：bbbdbbb   
* 创建时间：2020年2月26日 下午9:33:03   
* @version        
*/
public class ADV_292 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++){
			for (int j = 0; j < n; j++) {
				a[i][j] = scan.nextInt();
			}
		}
		int end = determinant(n,a);
		//System.out.println("end="+end);
		System.out.print(end);
	}

	private static int determinant(int n, int[][] a) {
		
		if(n==1){
			return a[0][0];//注意，不能忽略行列式只有一个元素的情况
		}
		//递归停止条件，当行列式为2阶时，直接运算
		if(n==2){
			return a[0][0]*a[1][1]-a[0][1]*a[1][0];
		}

		int ans = 0;
		int[][] temp = new int[n-1][n-1];
		
		for(int A_1j = 0; A_1j < n; A_1j++){//A_1j表示第一行的某个元素的列编码；这个for是为了遍历第一行的每个元素
			
			int col = 0;
			//两个内循环是为了得到A_1j的余子式M_1j
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if(j!=A_1j)	
						temp[i-1][(col++)%(n-1)] = a[i][j];
				}
			}
			//printM(n-1,temp);
			
			//进行递归
			ans += ((A_1j+1+1)%2==0? 1: -1)* a[0][A_1j]*determinant(n-1,temp);
			//System.out.println("ans="+ans);
		}
		
		return ans;
	}

	private static void printM(int i, int[][] temp) {

		for(int j = 0; j < i; j++){
			for (int k = 0; k < i; k++) {
				System.out.print(temp[j][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
