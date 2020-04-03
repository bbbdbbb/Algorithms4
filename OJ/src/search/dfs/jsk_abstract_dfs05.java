package search.dfs;

import java.util.Scanner;

/**  ���������������
 *  ����ͳ�������������������� 
 *  https://www.jisuanke.com/course/6497/341081
 *  
 *  ��Ŀ������������ 
 *  һ��������ÿ���ո�ķ�����ͬ������������£�
6  6  6  6  6  6  6  6  6  
6  7  7  7  7  7  7  7  6  
6  7  8  8  8  8  8  7  6  
6  7  8  9  9  9  8  7  6  
6  7  8  9  10 9  8  7  6  
6  7  8  9  9  9  8  7  6  
6  7  8  8  8  8  8  7  6  
6  7  7  7  7  7  7  7  6  
6  6  6  6  6  6  6  6  6 

  *  �����ܷ���Ϊ �����е�ÿһ�����������Ӧ�ķ����ĳ˻�֮��
  *  ���ܷ��������ֵ��
  *  
  *   ���룺
0 0 0 0 0 0 0 0 0
0 0 3 0 0 0 9 0 0
7 9 0 0 0 2 0 1 3
0 0 9 1 5 0 0 0 0
0 7 4 0 2 6 1 3 9
0 0 6 0 0 0 0 0 0
6 0 0 0 0 7 0 0 0
3 1 0 4 0 5 7 9 6
0 0 7 0 0 1 0 4 0

  *   �����   
2864

*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_abstract_dfs05   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��2�� ����4:56:38   
* @version        
*/
public class jsk_abstract_dfs05 {

	public static int[][] score = new int[9][9];
	public static int[][] map = new int[9][9];
	public static boolean[][] row = new boolean[9][10];
	public static boolean[][] col = new boolean[9][10];
	public static boolean[][] rea = new boolean[9][10];
	
	public static int max;
	private static boolean flag;
	
	public static void main(String[] args) {


		for(int i = 0; i <= 4; i++){
			for(int j = 0; j <= 4; j++){
				if(i == 0 || j == 0){
					score[i][j] = 6;
					score[i][8-j] = 6;
					score[8-i][j] = 6;
					score[8-i][8-j] = 6;
				}else if(i == 1 || j == 1){
					score[i][j] = 7;
					score[i][8-j] = 7;
					score[8-i][j] = 7;
					score[8-i][8-j] = 7;
				}else if(i == 2 || j == 2){
					score[i][j] = 8;
					score[i][8-j] = 8;
					score[8-i][j] = 8;
					score[8-i][8-j] = 8;
				}else if(i == 3 || j == 3){
					score[i][j] = 9;
					score[i][8-j] = 9;
					score[8-i][j] = 9;
					score[8-i][8-j] = 9;
				}else{
					score[i][j] = 10;
				}
			}
		}
		
		//���� score�����Ƿ���ȷ�洢����
//		for(int i = 0; i < 9; i++){
//			for(int j = 0; j < 9; j++){
//				if(score[i][j] == 10){
//					System.out.print(score[i][j] + " ");
//				}else{
//					System.out.print(score[i][j] + "  ");
//				}
//				
//			}
//			System.out.println();
//		}
		
		//��ȡ����
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				map[i][j] = scan.nextInt();
				if(map[i][j] != 0){
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					rea[i/3*3+j/3][map[i][j]] = true;
				}
			}
		}
		
		dfs(0,0);
		if(flag){
			System.out.println(max);
		}else{
			System.out.println(-1);
		}
		
	}

	private static void dfs(int r, int c) {

		if(r == 9){
			int num = score();//����
			max = Math.max(max, num);
			flag = true;
			return;
		}
		
		if(c == 9){
			dfs(r + 1, 0);
			return;
		}
		
		if(map[r][c] != 0){
			dfs(r, c + 1);
			return;
		}
		
		for(int i = 1; i <= 9; i++){
			if(!row[r][i] && !col[c][i] && !rea[r/3*3+c/3][i]){
				map[r][c] = i;
				row[r][i] = true;
				col[c][i] = true;
				rea[r/3*3+c/3][i] = true;
				
				dfs(r, c + 1);
				map[r][c] = 0;
				row[r][i] = false;
				col[c][i] = false;
				rea[r/3*3+c/3][i] = false;
			}
		}
		
	}

	private static int score() {

		int sum = 0;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				sum = sum + map[i][j] * score[i][j];
			}
		}
		
		return sum;
	}

}
