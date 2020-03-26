package greedy;

import java.util.Arrays;
import java.util.Scanner;

/** ̰���㷨��ϸ�ڡ���Ȼ�Լ��ճ���������������Ǹо����벻�����ţ�����ʱ���Ż�һ��
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
public class ALGO_34 {

	public static int[] ns;
	public static boolean[] bis;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int n = scan.nextInt();
		ns = new int[n];
		bis = new boolean[n];
		for (int i = 0; i < n; i++) {
			ns[i] = scan.nextInt();
		}
		Arrays.sort(ns);
		
		int ans = 0;
		for(int i = n - 1; i >= 0; i--){
			if(bis[i])		continue;//ns[i]�Ѿ���ʹ��
			
			boolean flag = false;
			int j = 0;
			for(; j < i; j++){
				if(ns[j] + ns[i] == w && !bis[j]){
					//�ҵ�����Ԫ�� ���� �ֳ�һ��
					bis[j] = true;
					bis[i] = true;
					//System.out.println("��׮��"+ns[i]+" and "+ns[j]);
					ans++;
					break;
				}else if(ns[j] + ns[i] > w && !bis[j]){
					
					while(--j >= 0){
						if(bis[j]){
							continue;
						}else{
							//a[j]��a[i]�ֳ�һ��
							bis[j] = true;
							bis[i] = true;
							//System.out.println("��׮��"+ns[i]+" and "+ns[j]);
							flag = true;
							break;
						}
					}
			
					ans++;
					if(flag){
						break;
					}else{//a[i]���ܺ���������Ʒ��ϣ�ֻ�ܵ�������
						bis[i] = true;
						//System.out.println("��׮��"+ns[i]);
						break;
					}
					
				}
			}
			

			if(j == i){
				bis[i] = true;
				//System.out.print("��׮��"+ns[i]);
				ans++;
				for(--j; j >= 0; j--){
					if(bis[j]){
						continue;
					}else{
						bis[j] = true;
						//System.out.print(" and "+ns[j]);
						break;
					}
				}
				//System.out.println();
			}
			
		}
		
		System.out.println(ans);
		
	}

}
