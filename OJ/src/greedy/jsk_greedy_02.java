package greedy;

import java.util.Scanner;
import java.util.Arrays;

/** �����ѧϰ����	̰���㷨
 * 	��Լ�õ�
 *  https://www.jisuanke.com/course/6497/341061
 *  
	��Ŀ��
������һ��nյ��ƣ�ÿյ��Ƶ�λ����a[i]�����ĳյ�Ƶ����������յ���ŵĵƵľ��벻����m
�Ϳ��԰���յ�ƹرա����е�һյ�ƺ����һյ�Ʋ��ܹص�
	����: ��Ƶ�յ��n��������m  ��Ƶ�λ��a[i]
4 5
3 6 10 1
	�����
1

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_greedy_02   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��24�� ����11:03:38   
* @version        
*/
public class jsk_greedy_02{
    
    public static int lap[];
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        lap = new int[n];

        for(int i = 0; i < n; i++){
            lap[i] = scan.nextInt();
        }
        Arrays.sort(lap);

        int count = 0;//��¼�صƵ�����
        int left = 0;//��¼�����������ŵĵƵ��±�
        for(int i = 1; i < n - 1; i++){
            if(lap[i+1] - lap[left] <= m){
            	//���������յ���ŵĵƵľ��벻����m��
            	//�ѵ�ǰ��lap[i]Ϩ�𣬼���
            	//��Ϊ��ǰ��lap[i]Ϩ���ˣ�������һյ��lap[i+1]��˵��
            	//�������������ŵĵ�Ҳ��lap[left]
            	//���в��ø���  left ��ֵ
                count++;
            }else{
            	//��ǰ��lap[i]��Ϩ��Ϩ��
            	//��ô��һյ��lap[i+1]�������������ŵĵƾ������ڵ�lap[i]
                left = i;
            }
        }
        
		System.out.print(count);
    
    }
}
