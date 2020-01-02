package Test;

public class Biggest {
	public int[] x;//当x[i]=1时，点i在最大团中，否则不再。
	public int n;//图G的顶点数
	public int cn;//当前顶点数
	public int bestn;//当前最大顶点数
	public int[] bestx;//当前最优解
	public int[][] a;//图G的邻接矩阵,0-无连边,1-有连边
	public int count;//图G的最大团个数
	public static void main(String[] args) {
		//因为数组的所言从0开始，所以索引将与0相关的元素设置为-1，表示无意义
		int[][] a={{-1,-1,-1,-1,-1,-1},
				{-1,0,1,0,1,1},
				{-1,1,0,1,0,1},
				{-1,0,1,0,0,1},
				{-1,1,0,0,0,1},
				{-1,1,1,1,1,0}};
		int n=5;
		Biggest m=new Biggest();
		System.out.println("书上P135图5-5无向图G的最大团解向量为：");		
		System.out.println("图G的最大团顶点数为："+m.maxclique(n, a));
		System.out.println("图G的最大团个数为："+m.count);
	}
	public int maxclique(int nn,int[][] aa){
		//初始化
		n=nn;
		a=aa;
		x=new int[n+1];
		bestx=x;
		cn=0;
		bestn=0;
		count=0;
		//回溯搜索
		backtrack(1);
		return bestn;
	}
	
	public void backtrack(int i){
		if(i>n){
			//到达叶子节点，当满足条件时，向左边走
			for(int j=1;j<=n;j++){
				bestx[j]=x[j];
				System.out.print(x[j]+" ");
			}
			System.out.println();
			bestn=cn;
			count++;
			return;
		}
		else{
			boolean ok=true;
			for(int j=1;j<i;j++){
				if(x[j]==1&&a[i][j]==0){
					ok=false;
					break;
				}
			}
			if(ok){
				
				x[i]=1;
				cn++;
				backtrack(i+1);
				x[i]=0;
				cn--;
			}
			if(cn+n-i>=bestn){
				x[i]=0;
				backtrack(i+1);
				}
			}
		}
}
