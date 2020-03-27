package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** ̰���㷨��������OS�еĽ�����Դ�����йصġ����������ȷ��䡱
 * �㷨��� �������ľ��Ϸ
 * ADV-194
 * http://lx.lanqiao.cn/problem.page?gpid=T361
 *   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_194   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��27�� ����8:44:22   
* @version        
*/
public class ADV_194 {

	public static node[] nds;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		for(int mCount = 0; mCount < m; mCount++){
			int sum = 0;//��¼�����Ʒ��С���Ѿ�����Ļ�ľ
			
			int n = scan.nextInt();
			nds = new node[n];
			for(int nC = 0; nC < n; nC++){
				nds[nC] = new node(scan.nextInt(),scan.nextInt());
			}			
			//nds = sort(nds);
			Arrays.sort(nds, new nodeComparator());

			
			int i = 0;
			for(; i < n; i++){
				if(nds[i].hava + sum >= nds[i].need){
					//�����Ʒ��С���Ѿ���Լ��Ļ�ľ
					sum += nds[i].hava;
				}else{
					//С����nds[i]�޷������Ʒ
					break;
				}
			}
			
			if(i == n){
				//����С���Ѷ��������Ʒ
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			//��������   -->  ��� ��һ����forѭ������ ��mCount++ ��дΪ m++
//			System.out.println(nds.length);
//			for (int i = 0; i < nds.length; i++) {
//				System.out.println(nds[i].hava + "  " + nds[i].need);
//			}
		}
		
		
		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		//long endMili=System.currentTimeMillis();
		//System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}
	
	public static class node{
		public int hava;
		public int need;
		
		public node(int have,int need){
			this.hava = have;
			this.need = need;
		}
	}
	
	//����node�ıȽ���
	public static class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.need - o1.hava - o2.need + o2.hava;
		}
		
	}
	
	public static node[] sort(node[] nds){
		
		int len = nds.length;
		for(int i = 0; i < len; i++){
			for(int j = 1; j < len -i; j++){
				if(nds[j-1].need - nds[j-1].hava - nds[j].need + nds[j].hava > 0){
					node temp = nds[j-1];
					nds[j-1]  = nds[j];
					nds[j]    = temp;
				}
			}
		}
		
		return nds;
	}
	
	
}
