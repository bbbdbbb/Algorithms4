package greedy;

import java.util.Arrays;
import java.util.Scanner;

/** ̰���㷨��˼·�򵥣����������ڿ��Կ��Ǵ����Ż����޽����-1��û�н��
 * ADV-199
 *  �㷨��� �߶κ͵�
 *  http://lx.lanqiao.cn/problem.page?gpid=T367  
��������
������n�����m�����䣬�������Ķ˵�ȫ�������������ڵ�a������[b,c]����a>=b��a<=c���Ƶ�a��������[b,c]��
��������С�ĵ���Ӽ���ʹ���������䶼�����㡣
�����ʽ
������һ����������n m
��������n�� ÿ��һ������������������
��������m�� ÿ��������������������ķ�Χ
�����ʽ
�������һ�У����ٵ�������������ĵ��������޽����-1��
��������
5 5
2
6
3
8
7
2 5
3 4
3 3
2 7
6 9
�������
2
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_199   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��27�� ����11:09:50   
* @version        
*/
public class ADV_199 {

	private static int[] ns;
	private static int[] ms2;
	private static int[] ms1;
	private static boolean[] bis;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		bis = new boolean[m];
		ns = new int[n];
		ms1 = new int[m];
		ms2 = new int[m];
		for(int i = 0; i < n; i++){
			ns[i] = scan.nextInt();
		}
		for(int i = 0; i < m; i++){
			ms1[i] = scan.nextInt();
			ms2[i] = scan.nextInt();
		}
		Arrays.sort(ns);
		
		int ans = 0;
		boolean flag = true;
		while(flag){
			int i = 0;
			for(; i < m; i++){
				if(bis[i] == false)		break;
			}
			if(i == m){//ȫ�����䶼������
				flag = false;
				continue;
			}
			
			int min = -1;
			//�����Ƚ����� ����
			for(int j = 0; j < m; j++){
				if(!bis[j] && ( min == -1 || ms2[j] < ms2[min])){//�ж�˳���ܱ�
					min = j;
				}
			}
			//��ֵ����һ������������min��
			int max = n -1;
			for(; max >= 0; max--){
				if(ns[max] <= ms2[min]){
					break;
				}
			}
			
			//�����а��� ��max����������Ϊtrue
			for(int j = 0; j < m; j++){
				if(!bis[j] && ms1[j] <= ns[max] && ms2[j] >= ns[max]){//����jδ�����㣬�ҵ���������
					bis[j] = true;
				}
			}
			
			ans++;
		}
		
		
		System.out.println(ans);
		
	}

}
