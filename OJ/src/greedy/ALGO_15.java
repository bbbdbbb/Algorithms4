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
* �����ƣ�ALGO_15   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��26�� ����9:45:07   
* @version        
*/
public class ALGO_15 {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		double D1 = scan.nextDouble();
		double C  = scan.nextDouble();
		double D2 = scan.nextDouble();
		double P  = scan.nextDouble();
		int   N  = scan.nextInt();
		
		double[] ds = new double[N+2];//���յ�Ҳ������һ������վ
		double[] ps = new double[N+2];
		ds[N+1] = D1;
		ps[N+1] = 0.0;//���յ����������վ�����ͼ�����Ϊ0��˾���Ͳ�����Ϊ�յ���ͼ۹󣬶�������װ��
		ds[0]   = 0.0;
		ps[0]   = P;
		for(int i = 1; i <= N; i++){
			ds[i] = scan.nextDouble();
			ps[i] = scan.nextDouble();
		}
		
		double res = 0.0;//���浱ǰ���仹ʣ������
		double ans = 0.0;//���
		int i = 0;
		for(; i <= N; i++){
			if(C * D2 < (ds[i+1] - ds[i])){
				//�ڵ�iվ����������������ܵ�����һվ
				break;
			}
			
			//Ѱ�Ҽ���վi����ļ۸��ps[i]�͵ļ���վj
			int j = i + 1;
			for(; j <= N+1; j++){
				if(ps[i] <= ps[j]){
					continue;
				}else{
					break;
				}
			}
			
			if(C * D2 >= (ds[j] - ds[i])){//�ڵ�i������վ ����C���� ���� �����j������վ
				if( (res * D2) >= (ds[j] - ds[i])){//������ʣ���res���Ϳ��Ե����j������վ
					//�����ڵ�i������վ����
					
					res = res - (ds[j] - ds[i]) / D2 ;
					//System.out.println("1��׮" + i +" : ���ü���     j = " + j + "   res = " + res +"     ds[j] = " + ds[j] + "   ds[i]"+ds[i]);
				}else{//��Ҫ���������Ͳſ��Ե����j������վ
					double s = ds[j] - ds[i];
					double tem = res * D2;
					s = (s - tem); //s ��ȥ ����ʣ���������ʻ��·��
					ans =  ans + (s / D2) * ps[i];
					//��Ҫ���Ǽ���
					//res = res + (s / D2);
					
					//��ʹ���꣬ʡ�Լ���
					res = 0;
					//System.out.println("2��׮" + i +" : ans = " + ans + "   ps[i] = " + ps[i] + "    s = "+s  + "  res = "+res);
				}
				
				//ֱ�ӴӼ���վi �� ������վj�����ǵ����forѭ����һ��i++�������ȼ�1��һ�����ӻ�����
				i = j - 1;
			}else{//�ڵ�i������վ ����C���� ���� �����j������վ
				//���ͼ���
				ans = ans +(C - res) * ps[i];
				res = C;
				//System.out.println("3��׮" + i +" : ans = " + ans + "   ps[i] = " + ps[i]);
				
				//��ʻ����һվ
				res = res - (ds[i+1] - ds[i]) / D2 ;
			}
			
			
			//ģ�������Ӽ���վi ��ʻ�� ����վj�����͵Ĺ���
//			if(C * D2 >= (ds[j] - ds[i])){
//				res = 0;
//			}else{
//				res = res - (ds[j] - ds[i]) / D2 ;
//			}
		}
		
			
		
//��һ������ʱ�������˼·��ÿ��ֻ�Ƚ� ��i������վ �͵�i+1������վ ֮����ͼ۹�ϵ��
//		for(; i <= N; i++){
//			if(C * D2 < (ds[i+1] - ds[i])){
//				//�ڵ�iվ����������������ܵ�����һվ
//				break;
//			}
//			
//			if(ps[i] < ps[i+1]){//��ǰ��i������վ���ͼ� ���� ��һ�� i+1��վ
//				//���������
//				ans += (C - res) * ps[i];
//				System.out.print("��׮"+i+": "+ans);
//				
//				res = C - (ds[i+1] - ds[i]) / D2;
//				System.out.println("  res = "+res);
//			}else{//��ǰ��i������վ���ͼ� ������ ��һ�� i+1��վ
//				//�ͼӵ����þ���
//				double s = ds[i+1] - ds[i];
//				s = s - res * D2;//s - ����ʣ���������ʻ��·��
//				ans += (s / D2) * ps[i];
//				System.out.println("��׮"+i+": "+ans);
//
//				res = 0;
//			}
//			
//			//ģ�������Ӽ���վi ��ʻ�� ����վi+1 �����͵Ĺ���
//			//res = res - (ds[i+1] - ds[i]) / D2;  //�����Ż��� ��ģ�����ֱ����ӵ����͵�ʱ�򣬼�������
//		}
//		
		if(i == N+1){//�ɹ������յ�
			System.out.printf("%.2f",ans);
		}else{//�м�break ��
			System.out.println("No Solution");
		}
		
	}

}
