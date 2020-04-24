package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** �����ѧϰ����	̰���㷨
 * 	Ģ������
 * 	https://www.jisuanke.com/course/6497/341062
	���⣺
һ����n��Ģ������ͷ��һ�����Թ���m�Σ���ͷ���Ĺ�����Ϊh+b
ÿ��Ģ����Ѫ��hp�ͷ���np�������ͷ���Ĺ��������ڻ����Ģ���ķ�������
��ô�Ϳ�������Ģ������Ҫ�ķ�Ģ����Ӧ��hp�ι���
�ʣ��������������Ģ����
	���룺
5 10 50 50
120 1
110 2
100 4
80  7
90  6
	�����
2

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_greedy_03   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��24�� ����11:18:56   
* @version        
*/
public class jsk_greedy_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//Ģ������
		int m = sc.nextInt();
		int hpSum = sc.nextInt();
		hpSum += sc.nextInt(); 
		node[] nds = new node[n];
		for(int i = 0; i < n; i++){
			int hp = sc.nextInt();
			int np = sc.nextInt();
			nds[i] = new node(hp,np);
		}
		//��Ģ����Ѫ��Ϊ����Ļ�׼������ѡ��Ѫ�ٵ�
		Arrays.sort(nds, new nodeComparator());
		
		int ans = 0;
		for(int i = 0; i < n; i++){
			if(m == 0){
				break;
			}
			if(nds[i].hp > hpSum){
				continue;
			}else{
				if(m >= nds[i].np){
					m -= nds[i].np;
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static class node{
		public int hp;
		public int np;
		public node(int hp, int np){
			this.hp = hp;
			this.np = np;
		}
	}
	
	//�Ƚ���
	private static class nodeComparator implements Comparator<node>{

		@Override
		public int compare(node o1, node o2) {
			return o1.np - o2.np;
		}


	}

}
