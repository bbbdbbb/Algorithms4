package search.dfs;

import java.util.Scanner;

/** �����ѧϰ����   dfs��֦
 * 	��������������
 * 	 https://www.jisuanke.com/course/6497/341236
 *
	���룺
3
10
100
1000

	�����
6
60
840  

*	��֦��
*	1.δ��֦��˼·�Ǵ�����1��num���ֱ�������������ĸ�������һ��������¼��������ֵ
*	2.��֦����������1��num�����жϣ����Ǽ��������1��47�ĸ���
*		  ��������Ҫ���ǣ�Ҫ��ֵС���������ĸ������ڻ����ֵ���
*		  ���磺 2 * 2 * 3  =  12 �� 2 * 3 * 3 = 18 
*		 12��18��������������6����Ϊ12<18,ȡ12.
*		  ��ô18��������Ƕ������ģ����Լ�֦  

* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs06_cut   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��9�� ����10:18:50   
* @version        
*/
public class jsk_dfs06_cut {
	
	private static long[] zys = new long[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	private static int n;
	private static long[] ns;
	
	private static long ans = 0;
	private static int ansCnt = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ns = new long[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextLong();
		}
		for(int i = 0; i < n; i++){
			ans = 0;
			ansCnt = 0;
			dfs(0,60,1,1,i);
			System.out.println(ans);
		}
		
		
	}

	/**
	 * @param index ��¼��ǰӦ�÷��ʵ�����zys[]���±�
	 * @param m		ʣ�����ѡ����������ĸ���(ȫ��ѡ2��������ѡ��ʮ���)
	 * @param num	��ǰ��ѡ�������������Ļ�
	 * @param cnt	��ǰ��num�����Ӹ���
	 * @param ni	��Ӧ����ns[]���±�
	 */
	private static void dfs(int index, int m, long num, int cnt, int ni) {
		
		if(cnt > ansCnt){
			ansCnt = cnt;
			ans = num;
		}else if(cnt == ansCnt && num < ans){
			ans = num;
		}
		
		//�Ѿ�������15���������ˣ����������Ѿ���������zys[]�ķ�Χ
		if(index == 15){
			return;
		}
		
		for(int i = 1; i <= m; i++){
			num = num * zys[index];
			if(num > ns[ni]){
				break;
			}
			dfs(index + 1, i, num, cnt * (i + 1), ni);
		}
	
	}

}
