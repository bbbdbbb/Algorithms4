package dp.unknow;

import java.util.Scanner;

/**	�����ѧϰ���� ��ʼ��̬�滮   
 * 	����  ����> ���·��
 * 	https://www.jisuanke.com/course/6497/341107
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dp05   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��14�� ����4:04:20   
* @version        
*/
public class jsk_dp05 {

	private static int[][] map;
	private static int[][] f;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n+10][m+10];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int v = sc.nextInt();
		int c = sc.nextInt();
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		f = new int[n+10][m+10];
		f[x][y] = v;
		
		//����
		for(int i = x; i >= 1; i--){
			for(int j = y; j >= 1; j--){
				if(i == x && j == y){//��������㣬ֱ������
					continue;
				}else if(i == x){//�� ��������еĵ���г�ʼ��
					f[i][j] = f[i][j + 1] + map[i][j];
				}else if(j == y){//ÿ���µ�һ�У��Ͷ� �������ͬһ�еĵ���г�ʼ��
					f[i][j] = f[i + 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j + 1], f[i + 1][j]) + map[i][j];
				}
				
//				if(f[i][j] <= 0){//����һ�Σ��Ͱ�����ֵ����Ϊ�ǳ�С���������ܸ���
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//ֱ�Ӹ�ֵΪ������Ҳ���У������һ������Ҳ�Ǹ���������������ӻᵼ�� ������������һ��������
				//����Ӧ�ÿ���һ�����ʵĸ�����Ϊ ����������
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//����
		for(int i = x; i >= 1; i--){
			for(int j = y; j <= m; j++){
				if(i == x && j == y){//��������㣬ֱ������
					continue;
				}else if(i == x){//�� ��������еĵ���г�ʼ��
					f[i][j] = f[i][j - 1] + map[i][j];
				}else if(j == y){//ÿ���µ�һ�У��Ͷ� �������ͬһ�еĵ���г�ʼ��
					f[i][j] = f[i + 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]) + map[i][j];
				}
				
				
//				if(f[i][j] <= 0){//����һ�Σ��Ͱ�����ֵ����Ϊ�ǳ�С���������ܸ���
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//ֱ�Ӹ�ֵΪ������Ҳ���У������һ������Ҳ�Ǹ���������������ӻᵼ�� ������������һ��������
				//����Ӧ�ÿ���һ�����ʵĸ�����Ϊ ����������
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//����
		for(int i = x; i <= n; i++){
			for(int j = y; j >= 1; j--){
				if(i == x && j == y){//��������㣬ֱ������
					continue;
				}else if(i == x){//�� ��������еĵ���г�ʼ��
					f[i][j] = f[i][j + 1] + map[i][j];
				}else if(j == y){//ÿ���µ�һ�У��Ͷ� �������ͬһ�еĵ���г�ʼ��
					f[i][j] = f[i - 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j + 1], f[i - 1][j]) + map[i][j];
				}
				
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		//����
		for(int i = x; i <= n; i++){
			for(int j = y; j <= m; j++){
				if(i == x && j == y){//��������㣬ֱ������
					continue;
				}else if(i == x){//�� ��������еĵ���г�ʼ��
					f[i][j] = f[i][j - 1] + map[i][j];
				}else if(j == y){//ÿ���µ�һ�У��Ͷ� �������ͬһ�еĵ���г�ʼ��
					f[i][j] = f[i - 1][j] + map[i][j];
				}else{
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]) + map[i][j];
				}
				
//				if(f[i][j] <= 0){//����һ�Σ��Ͱ�����ֵ����Ϊ�ǳ�С���������ܸ���
//					f[i][j] = Integer.MIN_VALUE;
//				}
				//ֱ�Ӹ�ֵΪ������Ҳ���У������һ������Ҳ�Ǹ���������������ӻᵼ�� ������������һ��������
				//����Ӧ�ÿ���һ�����ʵĸ�����Ϊ ����������
				if(f[i][j] <= 0){
					f[i][j] = -100000000;
				}
				if(f[i][j] > c){
					f[i][j] = c;
				}
			}
		}
		
		
		int max = Math.max(Math.max(f[1][1], f[1][m]), Math.max(f[n][1], f[n][m]));
		if(max <= 0){
			System.out.println(-1);
		}else{
			System.out.println(max);
		}
		
	}

}
