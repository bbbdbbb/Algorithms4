package greedy;

import java.util.Scanner;

/** ̰���㷨
 * �㷨ѵ�� ���мҵ�Ԥ�� 
 * http://lx.lanqiao.cn/problem.page?gpid=T75 
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
					System.out.println("1��׮" + i +" : ���ü���     j = " + j + "   res = " + res +"     ds[j] = " + ds[j] + "   ds[i]"+ds[i]);
				}else{//��Ҫ���������Ͳſ��Ե����j������վ
					double s = ds[j] - ds[i];
					double tem = (double)Math.round((res * D2)*1000)/1000;
					s = (double)Math.round((s - tem) * 1000) / 1000; //s - ����ʣ���������ʻ��·��
					ans = (double)Math.round(( ans + (double)(Math.round((s / D2) * ps[i] * 1000)) /1000) *1000) / 1000;
					//��Ҫ���Ǽ���
					res = (double)Math.round((res + (double)(Math.round((s / D2) * 1000)) / 1000) * 1000) / 1000;
					
					
					System.out.println("2��׮" + i +" : ans = " + ans + "   ps[i] = " + ps[i] + "    s = "+s  + "  res = "+res);

				}
			}else{//�ڵ�i������վ ����C���� ���� �����j������վ
				//���ͼ���
				ans = (double)Math.round((ans +(C - res) * ps[i]) * 1000) / 1000;
				res = C;
				System.out.println("3��׮" + i +" : ans = " + ans + "   ps[i] = " + ps[i]);
			}
			
			
			//ģ�������Ӽ���վi ��ʻ�� ����վi+1 �����͵Ĺ���
			if(j + 1 == i){
				res = 0;
			}else{
				res = (double)Math.round((res - (double)(Math.round((ds[i+1] - ds[i]) / D2 * 1000)) / 1000) * 1000) /1000;
			}
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
		
		if(i == N+1){//�ɹ������յ�
			System.out.printf("%.2f",ans);
		}else{//�м�break ��
			System.out.println("No Solution");
		}
		
	}

}
