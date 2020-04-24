package greedy;

import java.util.Arrays;
import java.util.Scanner;

/** ̰���㷨��ϸ�ڡ���Ȼ�Լ��ճ���������������Ǹо����벻�����ţ�����ʱ���Ż�һ��   ->  4��24�գ��������Ż������
 * �㷨ѵ�� ����Ʒ����
 * http://lx.lanqiao.cn/problem.page?gpid=T96
 * 
 * ��������
*��Ԫ���쵽�ˣ�Уѧ���������ָ����������ļ���Ʒ���Ź�����Ϊʹ�òμ�����ͬѧ����õļ���Ʒ��ֵ ��Ծ��⣬��Ҫ�ѹ����ļ���Ʒ���ݼ۸���з��飬��ÿ�����ֻ�ܰ�����������Ʒ������ÿ�����Ʒ�ļ۸�֮�Ͳ��ܳ���һ��������������Ϊ�˱�֤�ھ����̵�ʱ ���ڷ������м���Ʒ������ϣ���������Ŀ���١�
*�����������дһ�������ҳ����з��鷽���з��������ٵ�һ�֣�������ٵķ�����Ŀ��  
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_34   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��25�� ����10:41:43   
* @version        
*/

public class ALGO_34{
	
	public static int[] ns;
	public static boolean[] bis;
	
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		ns = new int[n];
		bis = new boolean[n];
		for(int i = 0; i < n; i++){
			ns[i] = sc.nextInt();
		}
		Arrays.sort(ns);
		
		int count = 0;
		for(int i = n - 1; i >= 0; i--){
			if(bis[i])		continue;
			
			//boolean flag = false;
			int j = 0;
			for(; j < i; j++){
				if(!bis[j] && ns[j] + ns[i] <= w ){
					bis[j] = true;
					bis[i] = true;
					count++;
					//flag = true;
					break;
				}
			}
			if(j == i){
				bis[i] = true;
				count++;
			}
		}
		
		System.out.println(count);
	}
}