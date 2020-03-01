package recursion;

import java.util.Arrays;
import java.util.Scanner;

/** �ݹ�
 * �㷨��� ���ֺڶ�
 * http://lx.lanqiao.cn/problem.page?gpid=T324   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_170   
* ����������   

��    ����һ����λ����ֻҪ���Ǹ���λ�ϵ������ǲ�ȫ��ͬ�ģ����������Ĺ��ɣ�
����1)����ɸ���λ�����ĸ������ɴ�С���У��γ������ĸ����ֹ��ɵ�������λ����
����2)����ɸ���λ�����ĸ�������С�������У��γ������ĸ����ֹ��ɵ���С����λ��(����ĸ����к���0����õ�����������λ)��
����3)���������Ĳ�õ�һ���µ���λ��(��λ�㱣��)��
�����ظ����Ϲ��̣����һ����õ��Ľ����6174��
�������磺4312 3087 8352 6174���������α任���õ�6174

	�������루һ����λ���������뱣֤��λ���ֲ�ȫ��ͬ��
		4312
	�������
		3

* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��1�� ����8:48:56   
* @version        
*/
public class ADV_170 {
	public static 	int count = 0;
	
	public static void main(String[] args) {
		long startMili=System.currentTimeMillis();

		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		
		while(n!=6174){
			 n = f(n);
			++count;
		}
		System.out.print(count);

		//��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili=System.currentTimeMillis();
		System.out.println("�ܺ�ʱΪ��"+(endMili-startMili)+"����");
	}

	private static int f(int n) {
		int[] num = new int[4];
		for(int i=3;i>=0;i--){
			num[i] = n%10;
			n = n/10;
		}
		Arrays.sort(num);
		int max = 0;
		int min = 0;
		for (int i = 0; i < num.length; i++) {
			min *= 10;
			min = min + num[i];
		}
		for (int i = 3; i >= 0; i--) {
			max *= 10;
			max = max + num[i];
		}
		
		
//		System.out.println(min);
//		System.out.println(max);

//		System.out.println("n="+n);
		return max-min;
	}

}
