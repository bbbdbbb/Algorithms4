package greedy;

import java.util.Scanner;

/** ̰���㷨
 * �㷨ѵ�� ���мҵ�Ԥ�� 
 * http://lx.lanqiao.cn/problem.page?gpid=T75 
��������
����һ�����м����ʻ���������ٵķ��ô�һ�����е���һ�����У��������ʱ�����ǿյģ���
������������֮��ľ���D1���������������C������Ϊ��λ����ÿ����������ʻ�ľ���D2��������ÿ�����ͼ۸�P����;��վ��N��N����Ϊ�㣩��
��վi�������ľ���Di��ÿ�����ͼ۸�Pi��i=1��2������N��������������������С�������λ������޷�����Ŀ�ĵأ��������No Solution����
	��������
275.6 11.9 27.4 2.8 2
102.0 2.9
220.0 2.2
	�������
26.95 
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�ALGO_15_plus   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��25�� ����4:45:05   
* @version        
*/
public class ALGO_15_plus {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double D1 = sc.nextDouble();//��������֮��ľ���
		double C = sc.nextDouble();//���������
		double D2 = sc.nextDouble();//ÿ��������ʻ�ľ���
		double P = sc.nextDouble();//��������ͼ�
		
		int N = sc.nextInt();//����վ������
		double[] Pi = new double[N+2];//ÿ������վ���ͼ�
		double[] Di = new double[N+2];//ÿ������վ�����ľ���
		double MaxDistance = D2 * C;
		
		//��ʼ��������ͼ�����
		Di[0] = 0; Pi[0] = P;
		Di[N+1] = D1; Pi[N+1] = 0;//���յ�Ҳ����Ϊһ������վ���յ���ͼ���0���������������յ�ʱ�����ﲻ����ʣ�����
		for(int i = 1; i <= N; i++){
			Di[i] = sc.nextDouble();
			Pi[i] = sc.nextDouble();
		}
		
		double fee = 0;//����
		double res = 0;//�����ʱʣ������
		//�ж��ܷ񵽴��յ�
		for(int i = 0; i <= N; i++){
			if(Di[i+1] - Di[i] > MaxDistance){//���ܵ����յ㣬����𰸣���������
				System.out.println("No Solution");
				return;
			}
		}
		//�����forѭ���Ѿ��жϿ��Ե����յ㣬����̰��ѡ��
		//ÿ��ѡ�� �ȵ�ǰ����վ�ͷѱ��˵�����ļ���վ
		int i = 0;//i��ʾ��ǰ���ڼ���վ��λ��
		while(i <= N){//��i = N + 1ʱ�������Ѿ������յ�
			int j = i + 1;
			for(; j <= N + 1; j++){
				if(Di[j] - Di[i] > MaxDistance){
					//�����������ͺ�Ҳ���ܵ������վj
					//���ҴӼ���վi������վj-1������վi���ͼ�������˵�
					//���� ���ͼ�����ֱ����ʻ�� j-1վ
					j--;
					break;
				}
				if(Pi[j] <= Pi[i]){
					break;
				}		
			}
			//System.out.print("��" + i + "������վ��   res = " + res + "  j = " + j);
			
			if(Pi[j] <= Pi[i]){
				//�ҵ���һ���ͼ۱ȵ�ǰ����վi���ͼ۱��ˣ������ܹ�����˼���վ
				
				if(res * D2 >= (Di[j] - Di[i])){//������͹���
//����һ���ͼ�������ǰ��i ��ֵ Ϊ  j�����¼���res����ʽ�У���Ԫ�������Ϊ 0					
//					i = j;
					res = res - (Di[j] - Di[i]) / D2;
					i = j;
					//System.out.println("  �͹��ã�����");
				}else{
					//���ͼӵ��ոպ��ܵ������վj
					fee = fee + ((Di[j] - Di[i]) / D2 - res) * Pi[i];
					//System.out.println("  ���� �� " + j );
					//ģ����ʻ������վj
					i = j;
					res = 0;//�͸ոպ�����
				}

			}else{
				//��������ʻ���������У�û�б����ڸ����˵ļ���վ
				//�ڵ�ǰվ���ͼ�����������һվ
				fee = fee + (C - res) * Pi[i];
				
				res = C - (Di[i+1] - Di[i]) / D2;
				i = i + 1;
				//System.out.println("  ����,���Ե�" + j);
//				res = C - (Di[j] - Di[i]) / D2;
//				i = j;
			}
		}
		
		System.out.printf("%.2f",fee);
	}

}
