package Test;

public class Biggest {
	public int[] x;//��x[i]=1ʱ����i��������У������١�
	public int n;//ͼG�Ķ�����
	public int cn;//��ǰ������
	public int bestn;//��ǰ��󶥵���
	public int[] bestx;//��ǰ���Ž�
	public int[][] a;//ͼG���ڽӾ���,0-������,1-������
	public int count;//ͼG������Ÿ���
	public static void main(String[] args) {
		//��Ϊ��������Դ�0��ʼ��������������0��ص�Ԫ������Ϊ-1����ʾ������
		int[][] a={{-1,-1,-1,-1,-1,-1},
				{-1,0,1,0,1,1},
				{-1,1,0,1,0,1},
				{-1,0,1,0,0,1},
				{-1,1,0,0,0,1},
				{-1,1,1,1,1,0}};
		int n=5;
		Biggest m=new Biggest();
		System.out.println("����P135ͼ5-5����ͼG������Ž�����Ϊ��");		
		System.out.println("ͼG������Ŷ�����Ϊ��"+m.maxclique(n, a));
		System.out.println("ͼG������Ÿ���Ϊ��"+m.count);
	}
	public int maxclique(int nn,int[][] aa){
		//��ʼ��
		n=nn;
		a=aa;
		x=new int[n+1];
		bestx=x;
		cn=0;
		bestn=0;
		count=0;
		//��������
		backtrack(1);
		return bestn;
	}
	
	public void backtrack(int i){
		if(i>n){
			//����Ҷ�ӽڵ㣬����������ʱ���������
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
