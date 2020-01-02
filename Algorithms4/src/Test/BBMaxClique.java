package Test;

import java.util.LinkedList;
/**   
* 项目名称：blog   
* 类名称：BBMaxClique   
* 类描述： 最大团问题 
* 创建人：bbbdbbb   
* 创建时间：2019年11月11日 下午7:36:54   
* @version        
*/
public class BBMaxClique {
	public int [][]a;//图G的邻接矩阵
	public static LinkedList<HeapNodes> heap;//活结点优先队列
	/*public MaxClique4(int[][] a){
		this.a=a;
		heap=new LinkedList<HeapNodes>();
	}*/
	public static void main(String[] args) {
		//a的下标从1开始，-1的值表示无效
		int[][] a={{-1,-1,-1,-1,-1,-1},
				   {-1,0,1,0,1,1},
				   {-1,1,0,1,0,1},
				   {-1,0,1,0,0,1},
				   {-1,1,0,0,0,1},
				   {-1,1,1,1,1,0}};
		int n=5;//5个结点
		int[] bestx=new int[n+1];
		System.out.println("图G的最大团的解向量为：");
		int best=bbMaxClique(a,bestx);				
		System.out.println("图G的最大团的顶点数为："+best);
	}
	//将当前构造出的活结点加入到子集空间树中并插入到活结点优先队列中
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
		int i=1;//结点所处的层次,初始为第一层
		int cn=0;
		int bestn=0;
		while(i!=n+1){//非叶节点
			boolean ok=true;
			BBnodes bnode=enode;
			for(int j=i-1;j>0;j--){
				if(bnode.leftChild&&a[i][j]==0){
					ok=false;
					break;
				}
				bnode=bnode.parent;
			}
			if(ok){//左儿子结点为可行结点
				if(cn+1>bestn)
					bestn=cn+1;
				addLiveNode(cn+n-i+1,cn+1,i+1,enode,true);
			}
			if(cn+n-i>=bestn){//右子树可能含有最优解
				addLiveNode(cn+n-i,cn,i+1,enode,false);
			}			
			//取下一个扩展结点
			HeapNodes node=heap.poll();
			enode=node.liveNode;
			cn=node.cliqueSize;
			i=node.level;
		}
		//构造当前最优解
		for(int j=n;j>0;j--){
			bestx[j]=enode.leftChild?1:0;
			enode=enode.parent;
			System.out.print(bestx[j]+" ");
		}
		System.out.println();
		return bestn;
	}
}
//解空间树种结点类型为BBnodes
class BBnodes{
	BBnodes parent;//父节点
	boolean leftChild;//是否是左儿子
	public BBnodes() {}
	public BBnodes(BBnodes par,boolean left){
		this.parent=par;
		this.leftChild=left;
	}
}
//活结点优先队列中元素类型为HeapNodes
class HeapNodes implements Comparable{
	BBnodes liveNode;
	int upperSize;//该结点为根的子树中的最大顶点数的上界,也是优先队列中元素的优先级
	int cliqueSize;//表示该结点相应的团的顶点数
	int level;//表示该结点在子集空间树中的层次
	public HeapNodes(BBnodes node,int up,int size,int lev){
		liveNode=node;
		upperSize=up;
		cliqueSize=size;
		level=lev;
	}
	@Override
	public int compareTo(Object x) {//降序排序
		int ux=((HeapNodes) x).upperSize;
		if(upperSize>ux) return -1;
		if(upperSize==ux) return 0;
		return 1;
	}
}
