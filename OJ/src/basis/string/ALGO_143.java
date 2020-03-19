package basis.string;

import java.util.Scanner;

/** �ַ����任		��ĸ��Сд֮���ת�����ж���ĸ�Ƿ�������С���ɣ�4��5ֵ�ø�ϰ
 * 	http://lx.lanqiao.cn/problem.page?gpid=T379
 *  �㷨ѵ�� �ַ����任
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_143   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��19�� ����10:46:37   
* @version    
* 
* �㷨ѵ�� �ַ����任    
*     
* ��������
�������ž������ѧ�ڵı��ѵ������Ҷ����ַ����Ĳ����Ѿ����յ��൱�����ˡ����죬����ʦ�����һ�´�Ҷ����ַ������������������
       ����ʦ�Լ�������1,2,3,4,5��5�������ֱ�ָ����ͬ��5���ַ�������������Ҫ���ݴ���Ĳ�������������ʦ�Ĺ涨���������ַ������и�ʽת����
��������ʦָ���Ĳ������£�
����1 ��ʾȫ��ת��Ϊ��д��ĸ�������abC ��� ABC
����2 ��ʾȫ��ת��ΪСд��ĸ�������abC���abc
����3 ��ʾ���ַ������������������ abc ��� cba
����4 ��ʾ���ַ����ж�Ӧ�Ĵ�д��ĸת��ΪСд��ĸ���������е�Сд��ĸת��Ϊ��д��ĸ������� abC���ABc
����5��ʾ��ȫ��ת��ΪСд��ĸ�������������е������Ӵ�ת��Ϊ��Ӧ����д��ʽ���������abcD ת��Ϊa-d����Σ�-���ٴ���1����ĸ���������ab������Ҫת��Ϊ��д��ʽ��    


��������
	5 ABcdEE
�������
	a-ee
*/
public class ALGO_143 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String str = scan.next();
		
		if(n == 1){
			//ȫ��ת��Ϊ��д��ĸ�������abC ��� ABC
			System.out.println(str.toUpperCase());
		}else if(n == 2){
			//ȫ��ת��ΪСд��ĸ�������abC���abc
			System.out.println(str.toLowerCase());
		}else if(n == 3){
			//���ַ������������������ abc ��� cba
			StringBuffer sb = new StringBuffer(str);
			System.out.println(sb.reverse());
		}else if(n == 4){
			//���ַ����ж�Ӧ�Ĵ�д��ĸת��ΪСд��ĸ���������е�Сд��ĸת��Ϊ��д��ĸ������� abC���ABc
			char[] chs = str.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				if(chs[i] >= 'a' && chs[i] <= 'z'){
					chs[i] -= 32;
					System.out.print(chs[i]);
				}else{
					chs[i] += 32;
					System.out.print(chs[i]);
				}
			}
			
			
		}else{//n = 5
			//��ȫ��ת��ΪСд��ĸ�������������е������Ӵ�ת��Ϊ��Ӧ����д��ʽ���������abcD ת��Ϊa-d����Σ�-���ٴ���1����ĸ���������ab������Ҫת��Ϊ��д��ʽ��
			str = str.toLowerCase();
			
			int count = 1;//���ڼ���ÿһ�����������ַ����ĳ���
			int len = str.length();
			char[] chs = new char[len + 1];
			for(int i = 0; i < len; i++){
				chs[i] = str.charAt(i);
			}
			//��ԭ�ַ�����ĩβ����ַ�'a'����Ӱ�������ַ����жϣ������Լ򻯶�ĩβ�����ַ��Ĵ���
			//���磺  "abcdxxabc"  ���е�"abc"���ַ���������ǲ��ô���ģ����Խ�����"abcdxxabca"
			chs[len] = 'a';
			
			//�����ʱ������chs[len]��������
			for(int i = 1; i <= len; i++){
				if(chs[i] == chs[i-1] + 1){
					//chs[i]��chs[i-1]����
					count++;
				}else{
					if(count > 2){//�������ַ�������3����Ҫ���м��ʡ��
						for(int j = i - count + 1; j <= i - 2; j++){
							chs[j] = '-';
						}
					}
					
					count = 1;
				}
			}
			
			//�����ʱ���ܰ�chs[len]��������
			for(int i = 0; i < len; i++){
				if(chs[i] == '-' && chs[i+1] != '-'){
					System.out.print(chs[i]);
				}else if(chs[i] != '-'){
					System.out.print(chs[i]);
				}
			}
		}
	}

}
