package Test;
/**   
* ��Ŀ���ƣ�blog   
* �����ƣ�Knapsack   
* �������� 0-1�������� 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2019��10��21�� ����9:17:20   
* @version        
*/
public class Knapsack {
	public static void main(String args[]) {
		int [] w= {2,2,6,5,4};
		int [] v= {6,6,5,4,6};
		System.out.println("��������P73������");
		System.out.println("����i������wi����");		
		for (int i=0;i<w.length;i++) {
			System.out.print(w[i]+" ");
		}
		System.out.println();
		System.out.println("����i�ļ�ֵvi��");
		for (int i=0;i<w.length;i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println("");
		System.out.println("����������c=10");
		System.out.print("װ�뱳���е���Ʒ������ܼ�ֵΪ��");
		System.out.println(knapSack(w,v,10));
	}
	public static int knapSack(int [] w,int[] v,int C) {
		int size=w.length;
		if(size==0) {
			return 0;
		}
		int [][]dp=new int[size][C+1];
		for (int i=0;i<=C;i++) {
			dp[0][i]=w[0]<=i?v[0]:0;
		}
		for(int i=1;i<size;i++) {
			for (int j=0;j<=C;j++) {
				dp[i][j]=dp[i-1][j];
				if(w[i]<=j)
					dp[i][j]=(int )Math.max(dp[i][j], v[i]+dp[i-1][j-w[i]]);
			}			
		}
		return dp[size-1][C];
		
	}
}
