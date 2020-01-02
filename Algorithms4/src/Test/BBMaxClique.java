package Test;

import java.util.LinkedList;
/**   
* ��Ŀ���ƣ�blog   
* �����ƣ�BBMaxClique   
* �������� ��������� 
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2019��11��11�� ����7:36:54   
* @version        
*/
public class BBMaxClique {
	public int [][]a;//ͼG���ڽӾ���
	public static LinkedList<HeapNodes> heap;//�������ȶ���
	/*public MaxClique4(int[][] a){
		this.a=a;
		heap=new LinkedList<HeapNodes>();
	}*/
	public static void main(String[] args) {
		//a���±��1��ʼ��-1��ֵ��ʾ��Ч
		int[][] a={{-1,-1,-1,-1,-1,-1},
				   {-1,0,1,0,1,1},
				   {-1,1,0,1,0,1},
				   {-1,0,1,0,0,1},
				   {-1,1,0,0,0,1},
				   {-1,1,1,1,1,0}};
		int n=5;//5�����
		int[] bestx=new int[n+1];
		System.out.println("ͼG������ŵĽ�����Ϊ��");
		int best=bbMaxClique(a,bestx);				
		System.out.println("ͼG������ŵĶ�����Ϊ��"+best);
	}
	//����ǰ������Ļ�����뵽�Ӽ��ռ����в����뵽�������ȶ�����
	public static void addLiveNode(int up,int size,int lev,BBnodes par,boolean ch){
		BBnodes enode=new BBnodes(par,ch);
		HeapNodes h=new HeapNodes(enode,up,size,lev);
		heap.add(h);
		//Collections.sort(heap);
	}
	public static int bbMaxClique(int[][] a,int[] bestx){
		int n=bestx.length-1;
		heap=new LinkedList<HeapNodes>();
		BBnodes enode=null;
		int i=1;//��������Ĳ��,��ʼΪ��һ��
		int cn=0;
		int bestn=0;
		while(i!=n+1){//��Ҷ�ڵ�
			boolean ok=true;
			BBnodes bnode=enode;
			for(int j=i-1;j>0;j--){
				if(bnode.leftChild&&a[i][j]==0){
					ok=false;
					break;
				}
				bnode=bnode.parent;
			}
			if(ok){//����ӽ��Ϊ���н��
				if(cn+1>bestn)
					bestn=cn+1;
				addLiveNode(cn+n-i+1,cn+1,i+1,enode,true);
			}
			if(cn+n-i>=bestn){//���������ܺ������Ž�
				addLiveNode(cn+n-i,cn,i+1,enode,false);
			}			
			//ȡ��һ����չ���
			HeapNodes node=heap.poll();
			enode=node.liveNode;
			cn=node.cliqueSize;
			i=node.level;
		}
		//���쵱ǰ���Ž�
		for(int j=n;j>0;j--){
			bestx[j]=enode.leftChild?1:0;
			enode=enode.parent;
			System.out.print(bestx[j]+" ");
		}
		System.out.println();
		return bestn;
	}
}
//��ռ����ֽ������ΪBBnodes
class BBnodes{
	BBnodes parent;//���ڵ�
	boolean leftChild;//�Ƿ��������
	public BBnodes() {}
	public BBnodes(BBnodes par,boolean left){
		this.parent=par;
		this.leftChild=left;
	}
}
//�������ȶ�����Ԫ������ΪHeapNodes
class HeapNodes implements Comparable{
	BBnodes liveNode;
	int upperSize;//�ý��Ϊ���������е���󶥵������Ͻ�,Ҳ�����ȶ�����Ԫ�ص����ȼ�
	int cliqueSize;//��ʾ�ý����Ӧ���ŵĶ�����
	int level;//��ʾ�ý�����Ӽ��ռ����еĲ��
	public HeapNodes(BBnodes node,int up,int size,int lev){
		liveNode=node;
		upperSize=up;
		cliqueSize=size;
		level=lev;
	}
	@Override
	public int compareTo(Object x) {//��������
		int ux=((HeapNodes) x).upperSize;
		if(upperSize>ux) return -1;
		if(upperSize==ux) return 0;
		return 1;
	}
}
