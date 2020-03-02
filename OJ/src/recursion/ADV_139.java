package recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * �ݹ��⣬�߼�д�ĺ��ң������ʱ����Ҫ�Ż����� �����漰���Ž⣬��ѧ�˶�̬�滮�ڻ����Ż����� �㷨��� ����
 * http://lx.lanqiao.cn/problem.page?gpid=T282
 * 
 * ��Ŀ���ƣ�OJ �����ƣ�ADV_139 ��Ŀ������
 * 
 * A������һ���޴��Բ�ι㳡��Ϊ���̻������;���������������������Բ�ι㳡��Ȧ��һȦ����԰�ֲ��� �õ�ָ���
 * �����滮��n��������λ�ã�˳ʱ����1��n������ÿ��λ�ö���һ�����۶�Ai����������������Ϳ��Եõ���Ai�����۶ȡ� ������A��������
 * ����Ƿ�ѣ��������������������ڵ�λ�ã�i��λ�ú�i+1��λ�ý�����λ�á�ֵ��ע�����1�ź�n��Ҳ������λ�ã�����
 * ������������԰�ֲ����ṩ��m�����粢Ҫ��ȫ�����ϣ������æ�����������ʹ�����۶��ܺ��������޷���m������ȫ�����ϣ������޽���Ϣ��
 * 
 * �������� > 7 3 > 1 2 3 4 5 6 7 ������� > 15
 * 
 * �������� > 7 4 > 1 2 3 4 5 6 7 ������� > Error!
 * 
 * 
 * �����ˣ�bbbdbbb ����ʱ�䣺2020��3��2�� ����3:03:13
 * 
 * @version
 */
public class ADV_139 {
	public static int m;

	public static void main(String[] args) {
		long startMili = System.currentTimeMillis();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		m = scan.nextInt();

		int[] a = new int[n];
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			vis[i] = false;
		}

		if (n == 1 && m == 1)
			System.out.print(a[0]);
		else if (n / 2 == m && n % 2 == 0) {
			int odd = 0;
			int even = 0;
			for (int i = 0; i < a.length; i++) {
				if (i % 2 == 0) {
					even += a[i];
				} else {
					odd += a[i];
				}
			}
			System.out.print(Math.max(odd, even));
		} else if (n / 2 < m)
			System.out.print("Error!");
		else {
			int sum = 0;
			// ��ʼ�ݹ�
			sum = f(a, vis, sum);

			System.out.println(sum);
		}

		// ��ʱ�����ύ�𰸵�ʱ��Ҫɾ��
		long endMili = System.currentTimeMillis();
		System.out.println("\n�ܺ�ʱΪ��" + (endMili - startMili) + "����");
	}

	private static int f(int[] a, boolean[] vis, int sum) {

		int len = vis.length;

		int count = 0;
		for (int i = 0; i < len; i++) {
			if (vis[i])
				count++;
		}
		if (count == m) {
			return sum;
		}
		
		int[] temp = new int[len];
		if(count==0){
			for (int i = 0; i < len-m; i++) {
				if (vis[(i - 1 + len) % len] || vis[i] || vis[(i + 1) % len])
					continue;
				vis[i] = true;
				temp[i] = f(a, vis, sum+a[i]);
				vis[i] = false;
			}
		}else{
			for (int i = 0; i < len; i++) {
				if (vis[(i - 1 + len) % len] || vis[i] || vis[(i + 1) % len])
					continue;
				vis[i] = true;
				temp[i] = f(a, vis, sum+a[i]);
				vis[i] = false;
			}
		}

		Arrays.sort(temp);

		return temp[len - 1];

	}

}
