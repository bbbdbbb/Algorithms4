package recursion;

import java.util.Scanner;

/**
 * �㷨��� ��ַ�����
 * http://lx.lanqiao.cn/problem.page?gpid=T378   
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ADV_207   
* ������������� �ݹ����⣬��һ�β��ᣬֵ��OJ   
* 
	��x(i), y(i), z(i)��ʾ�����ַ�����X={x(1)x(2)����x(m)}��Y={y(1)y(2)����y(n)}��Z={z(1)z(2)����z(k)},
    ���ǳ���Ϊ�ַ����У�����m,n��k�ֱ����ַ�����X��Y��Z�ĳ��ȣ�����()�е����ֱ������ַ����е��±ꡣ
��	�������һ���ϸ�������ҳ��ȴ���0���±�����{i1,i2����ik}��ʹ�ö����е�j=1,2,����k����x(ij)=z(j)����ô���ǳ�Z��X���ַ������С�
    ���ң����Z����X���ַ�����������Y���ַ������У���ô���ǳ�ZΪX��Y�Ĺ����ַ����С�
��	�����ǽ���������У�����ϣ���������������ַ�����X��Y����󳤶ȵĹ����ַ����У���������ֻҪ����������󳤶ȹ��������ж�Ӧ�ĳ���ֵ��
��	������˵���ַ�����X=abcd��Y=acde����ô���ǵ���󳤶�Ϊ3����Ӧ�Ĺ����ַ�����Ϊacd��

* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��2��28�� ����9:34:48   
* @version        
*/
public class ADV_207 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		
		int end = f(chs1,0,chs2,0);		
		System.out.print(end);

	}

	private static int f(char[] chs1, int i, char[] chs2, int j) {
		
		//�ݹ���ֹ����
		if(i==chs1.length || j==chs2.length)	return 0;
		else if(chs1[i] == chs2[j])				return f(chs1,i+1,chs2,j+1)+1;
		else									return Math.max(f(chs1,i+1,chs2,j), f(chs1,i,chs2,j+1));

	}
}
