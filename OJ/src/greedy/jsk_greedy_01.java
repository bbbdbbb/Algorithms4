package greedy;

import java.util.Scanner;

/** �����ѧϰ����	̰���㷨
 * 	���ҹ���
 * 	https://www.jisuanke.com/course/6497/341060  
��N�����������Ҫ������Ʒ�����û����û�������Ҫ�Ĳ�Ʒ���Դӹ���������Ҳ�����òֿ���洢�Ĳ�Ʒ���ֿ��������ޣ���������޸���ĿΪ�ֿ����������ָ���ν���?��
ÿ���ܲ�Ʒ�������ɱ����ۻᷢ���仯�����ǲֿⴢ���Ʒ�ĵ���S���ᷢ���ı�
��N���ܵ����ٳɱ���
	���룺 N����  S�ֿⴢ�浥��
		ÿһ�� �� ��Ʒ�ɱ�  ���û���������
4 5
88 200
89 400
97 300
91 500	
	�����
126900

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_greedy_01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��24�� ����10:41:06   
* @version        
*/
public class jsk_greedy_01{
    
    public static long[] cost;
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long S = scan.nextLong();
        cost = new long[N];
        
        long sum = 0L; 
        long temp = 1005000L;
        for(int i = 0; i < N; i++){
            cost[i] = scan.nextLong();
            long num = scan.nextLong();
            
            //ѡ������˵ļ۸������ɱ�+����ɱ�
            //һ���Ǳ���ֱ�������۸���ͣ�cost[j]
            //һ�������ܵ�������ʽ�ļ۸���ϱ���һ�ܵļ۸���ͣ�temp + S
            //���ܵ�������ʽ�ļ۸�����������ܵı��������Ĳ�Ʒ��
            //�������Ѿ������˱���ĳɱ�������������ֻ���ټ���һ�ܵı���ɱ�
            temp = Math.min(cost[i] , temp + S);
            
            sum = sum + temp * num;
        }
        
        System.out.print(sum);
    }
}
