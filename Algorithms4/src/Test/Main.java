package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	static boolean[] used;
    static int num;//�ָ��ľ��������
    static int[] s;
    static int sum;
    static int max;
    static int parts;
 
    //"ľ��"��ʾ�ϳɺ��stick��"ľ��"��ʾδ�ϳɵ�stick
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while((num = sc.nextInt()) != 0){
			used = new boolean[num];
			sum = 0;
			s = new int[num];
			for(int i = 0; i<num; i++){
				s[i] = sc.nextInt();
				sum += s[i];
			}
			
			Arrays.sort(s);//��ľ����������(��С����)
			max = s[num - 1];
			
			//ľ���ĳ���һ�����ڵ������ľ�����ȣ����Դ����ľ����ʼ
			for(; max<= sum; max++){
				//ľ���ĳ���һ���ܱ��ܳ�������
				if(sum%max == 0){
					parts = sum/max;//ľ������Ŀ
					if(search(0, num - 1, 0)){
						System.out.println(max);
						break;
					}
				}
			}
		}
		sc.close();
	}
	
	/*
	 * ������ƴ��һ��ľ����ľ��
	 * @param res:��ǰ���ľ�����еĳ���
	 * @param next����һ��������ľ�����±�
	 * @param cpl���Ѿ�ƴ�ɵ�ľ������
	 */
 
	public static boolean search(int res, int next, int cpl){
		//��res=maxʱ�����κϳɳɹ���
		if(res == max){
			cpl++;
			res = 0;
			next = num - 1;
			//��һ�κϳɳɹ���next����ָ�����������λ�ã���ʱӦ�ý����ûأ������ӵ�ǰ���Ŀ�ʼ�ϳ�
		}
		
		//cpl = parts,��ǰ����ľ���ϳ����
		if(cpl == parts){
			return true;
		}
		
		//û�гɹ��������ϳ�
		while(next >= 0){
			//�����ǰľ��û�б��ù�
			if(used[next] == false){
				//ľ���ĵ�ǰ����+��ǰ������ľ������ û�г���max������Է���
				if(res + s[next] <= max){
					used[next] = true;
					//���������ɹ�
					if(search(res + s[next], next - 1, cpl)){
						return true;
					}
					
					//�������ɹ�
					used[next] = false;
					
					//����������ʧ��ʱ��res=0��˵����ǰ�ľ���޷��ϳ�ľ������϶�������ʧ��
					if(res == 0){
						break;
					}
					
					//���Ժϳɵ�ǰ�ģ�����ʣ�µ��޷��ϳ�
					if(res + s[next] == max){
						break;
					}
				}
				
				//���ĳһ��ľ��ƥ��ʧ�ܣ����ڵ�ǰ�����£�������ͬ���ȵ�ľ����������ƥ����
				int i = next - 1;
				while(i >=0 && s[i] == s[next]){
					i--;
				}
				next = i;
				
				//����ʣ��ľ�����ܳ���
				int l_s = 0;
				while(i >= 0){
					if(used[i] == false){
						l_s += s[i];
					}
					i--;
				}
				//���ʣ��ľ�����ܳ��ȶ�С��max-res����ƴ��һ��ʧ��
				if(l_s < max - res){
					break;
				}
				continue;
			}
			next--;//�˴����ڿ��Ƶ�if(used[next] == false)������ʱ��ָ����һ��ľ��
		}
		return false;
	}
}


