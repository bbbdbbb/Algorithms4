package search.dfs;

import java.util.Scanner;

/** ���������������
 *  ����ͳ����������������һ��
 *  
 *   ��Ŀ��
 *   ����n����ʾ��n��ľ��
 *   ������n���������ֱ��ʾn��ľ���ĳ���
 *   �ж�m��ľ���ܷ�ƴ�ճ�һ���ȱ�������
 *   
 *  ����ʱ�䣺2020��3��30�� ����10:01:37    
 *  �����Ż���2020��3��31��   -->  ͨ����¼��һ��ľ����λ�ã�����dfs()��forѭ���Ĵ����������ϣ���ȥ�أ���(1,4),(2,3),(5)
 *  				   -->  �����ϣ���ȥ��.ԭ����(1,4),(2,3),(5) �� (1,4),(5),(2,3)��Ϊ˳��ͬ���ɲ�ͬ��ѡ��
 *  				   -->  �Ż��󣬽������ظ��ж�
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_abstract_dfs01   
* ��������   
* �����ˣ�bbbdbbb   
* 
* @version        
*/
public class jsk_abstract_dfs01 {

	private static int[] item;
	private static int s = 0;//��¼����ľ�����ȵ��ܺ�
	private static boolean flag = false;//�ж��ܷ�ɹ�ƴ�ɵȱ�������
	private static boolean[] vis;//���ڼ�¼ľ����û��ʹ��
	private static int n;
	
	public static int test = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		item = new int[n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			item[i] = scan.nextInt();
			s += item[i];
		}
		
		//System.out.println("s = " + s);
		
		//��֦��
		//��ΪҪʹ��ȫ��ľ����ľ���ĳ����ܺͱ��������ı���
		if(s % 3 != 0){
			System.out.println("no");
		}else{
			dfs2(0,0,0);
			if(flag){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
			
		}
		
		System.out.println(test);
		
	}

	private static void dfs(int count, int sum) {

		if(flag){
			return;
		}
		
		if(count == 3){
			flag = true;

			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0);
			return;
		}
		
		for(int i = 0; i < n; i++){
			test++;
			
			if(!vis[i]){
				vis[i] = true;
				//System.out.println("for>  i = " + i +" count = "+count + "  sum =  " +(sum + item[i]));
				dfs(count, sum + item[i]);
				vis[i] = false;
			}
		}
		
	}
	
	

	/**
	 * �����Ż��������ظ�������
	 * �Ż��ĵĹؼ��������ǰд����dfs(count + 1, 0,count)��ֱ�Ӵ�count�ᵼ�½������
	 * ���磺
	 * �ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����������˵Ӧ�ôӡ�2����ʼ
	 * �������dfs(count + 1, 0,count)�Ļ����ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����
	 * ��ֻ��ѡ��5�������²�����ȷ�ж�
	 * 
	 * @param count �Ѿ����ƴ�յ�ľ������
	 * @param sum ��ǰ��ƴ��ľ���ĳ��ȣ���sum == s / 3  ʱ��ɵ�ǰľ����ƴ�գ�
	 * @param index ��һ��Ӧ��������ľ��������
	 */
	private static void dfs(int count, int sum, int index) {
		test++;
		
		if(flag){
			return;
		}
		
		if(count == 3){
			flag = true;
			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0,0);//�Ż��ĵĹؼ��������ǰд����dfs(count + 1, 0,count)��ֱ�Ӵ�count�ᵼ�½������
								//���磺
								//�ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����������˵Ӧ�ôӡ�2����ʼ
								//��Ϊ�����鷳����ÿ�ζ���׼���ҵ����¿�ʼ��λ�ã�����ÿ��ƴ�ճɹ�һ��ľ��ʱ����ͷ��ʼ������������ľ��
								//�������dfs(count + 1, 0,count)�Ļ����ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����
								//��ֻ��ѡ��5�������²�����ȷ�ж�
			return;
		}
		
		for(int i = index; i < n; i++){
			
			if(!vis[i]){
				vis[i] = true;
				//System.out.println("for>  i = " + i +" count = "+count + "  sum =  " +(sum + item[i]));
				dfs(count, sum + item[i],i+1);
				vis[i] = false;
			}
		}
		
	}

	
	//ʹ������ö��
	private static void dfs2(int count, int sum, int index) {

		if(flag){
			return;
		}
		
		if(index >= n){
			return;
		}
		
		if(count == 3){
			flag = true;
			return;
		}
		
		if(sum == s / 3){
			dfs(count + 1, 0,0);//�Ż��ĵĹؼ��������ǰд����dfs(count + 1, 0,count)��ֱ�Ӵ�count�ᵼ�½������
								//���磺
								//�ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����������˵Ӧ�ôӡ�2����ʼ
								//��Ϊ�����鷳����ÿ�ζ���׼���ҵ����¿�ʼ��λ�ã�����ÿ��ƴ�ճɹ�һ��ľ��ʱ����ͷ��ʼ������������ľ��
								//�������dfs(count + 1, 0,count)�Ļ����ڡ�1 2 3 4 5����ѡ���ˡ�1�� �͡�4����
								//��ֻ��ѡ��5�������²�����ȷ�ж�
			return;
		}
		
		//ѡ ��ǰ  ľ��
		if(!vis[index]){
			dfs2(count,sum + item[index],index + 1);
		}
		//��ѡ ��ǰ ľ��
		dfs2(count,sum,index+1);
		
	}
}
