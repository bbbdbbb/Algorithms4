package practice.wbwp02;

import java.math.BigInteger;
import java.util.Scanner;

/**   
*    
* �����������ű�������2 ��Ŀһ  �˻�β��   
* �������ݣ�
5650 4542 3554 473 946 4114 3871 9073 90 4329
2758 7949 6113 5659 5245 7432 3051 4434 6704 3594
9937 1173 6866 3397 4759 7557 3070 2287 1453 9899
1486 5722 3135 1170 4014 5510 5120 729 2880 9019
2049 698 4582 4346 4427 646 9742 7340 1230 7683
5693 7015 6887 7381 4172 4341 2909 2027 7355 5649
6701 6645 1671 5978 2704 9926 295 3125 3878 6785
2066 4247 4800 1578 6652 4616 1113 6205 3264 2915
3966 5291 2904 1285 2193 1428 2265 8730 9436 7074
689 5510 8243 6114 337 4096 8199 7313 3685 211
*/
public class p01 {
	/*
	 * ��һ�ַ���
	 * 	����Java�ı�����ͨ��BigInteger��ֱ�����������
	 * 		
	 * �𰸣�
	 * 	31
	 */
//	public static void main(String[] args){
//		
//		Scanner scan = new Scanner(System.in);
//		
//		BigInteger b = new BigInteger("1");
//		BigInteger[] bs = new BigInteger[100];
//		
//		for (int i = 0; i < 100; i++) {
//			 bs[i] = new BigInteger(scan.next());
//		}
//		for (int i = 0; i < 100; i++) {
//			if(i%10==0)		System.out.println();
//			System.out.print(bs[i]+" ");
//			 b = b.multiply(bs[i]);
//		}
//		
//		System.out.println();
//		System.out.println(b);
//	}
	
	
	/*
	 * �ڶ��ַ�����
	 * 	�ж�����������Ƿ�������10������5�������������м���
	 * 	��������2�ܶ࣬����û�ж�����2���м���
	 */
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int zero=0,five=0,evenNum=0;
		
		for (int i = 0; i < 100; i++) {
			int num = scan.nextInt();
			while(num%10==0){//num��10�ı���������4800  ����zero��ֵ������2
				num /= 10;
				zero++;
			}
			while(num%5==0){//num��5�ı���������3125  ����five��ֵ������5
				num /= 5;
				zero++;
			}

		}
		
		System.out.println(five+zero);
	}
}
