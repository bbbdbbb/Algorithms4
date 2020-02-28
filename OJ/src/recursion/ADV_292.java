package recursion;

import java.util.Scanner;

/**   
* http://lx.lanqiao.cn/problem.page?gpid=T559   
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_292   
* ��������   ���Ѷȵ�  �ݹ���  ��Ҫ���Դ����Ļ���֪ʶ      ���� ��������ʽ 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��26�� ����9:33:03   
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
			return a[0][0];//ע�⣬���ܺ�������ʽֻ��һ��Ԫ�ص����
		}
		//�ݹ�ֹͣ������������ʽΪ2��ʱ��ֱ������
		if(n==2){
			return a[0][0]*a[1][1]-a[0][1]*a[1][0];
		}

		int ans = 0;
		int[][] temp = new int[n-1][n-1];
		
		for(int A_1j = 0; A_1j < n; A_1j++){//A_1j��ʾ��һ�е�ĳ��Ԫ�ص��б��룻���for��Ϊ�˱�����һ�е�ÿ��Ԫ��
			
			int col = 0;
			//������ѭ����Ϊ�˵õ�A_1j������ʽM_1j
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if(j!=A_1j)	
						temp[i-1][(col++)%(n-1)] = a[i][j];
				}
			}
			//printM(n-1,temp);
			
			//���еݹ�
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
