package search.dfs;

import java.util.Scanner;

/**  ���������������
 *  ����ͳ�������������������� 
 *  https://www.jisuanke.com/course/6497/341080
 *  
 *  ��Ŀ������
 *  ��һ��9*9����������д���еĿո�ʹ��ÿһ��,ÿһ���Լ�ÿһ�� 3*3��С����û���ظ�����
 *  
 *  ���룺

* 2 6 * * * * * *
* * * 5 * 2 * * 4
* * * 1 * * * * 7
* 3 * * 2 * 1 8 *
* * * 3 * 9 * * *
* 5 4 * 1 * * 7 *
5 * * * * 1 * * *
6 * * 9 * 7 * * *
* * * * * * 7 5 *


 * �����
1 2 6 7 3 4 5 9 8
3 7 8 5 9 2 6 1 4
4 9 5 1 6 8 2 3 7
7 3 9 4 2 5 1 8 6
8 6 1 3 7 9 4 2 5
2 5 4 8 1 6 3 7 9
5 4 7 2 8 1 9 6 3
6 1 3 9 5 7 8 4 2
9 8 2 6 4 3 7 5 1
 
 
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_abstract_dfs04   
* �������������ѧϰ����-������������ڶ���-����     
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��4��1�� ����9:53:10   
* @version        
*/
public class jsk_abstract_dfs04 {
	
	public static char[][] map = new char[9][9];
	public static boolean[][] row = new boolean[9][10];
	public static boolean[][] col = new boolean[9][10];
	public static boolean[][] rea = new boolean[9][10];
	private static boolean flag;
	public static void main(String[] args) {

		int x = -1;
		int y = -1;//��¼���
		Scanner scan = new Scanner(System.in);
		//��������   ->  ������ȡ����
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				map[i][j] = scan.next().charAt(0);
				if(x == -1 && y == -1 && map[i][j] == '*'){
					x = i;
					y = j;
				}else if(map[i][j] >= '0' && map[i][j] <= '9'){
					int num = map[i][j] - '0';
					row[i][num] = true;
					col[j][num] = true;
					rea[i/3*3 + j/3][num] = true;
				}
			}
		}
		

		dfs(x,y);

		
	}

	private static void dfs(int r, int c) {
		//System.out.println(r + "  " + c);
		if(flag){
			return;
		}
		
		if(r == 9 && c ==0){//�ҵ� һ��  ��д�����ķ�ʽ  �ͱ��� ץס���Ὣ���ӡ����Ȼ��ʹ��flag����Ϊflag,Ҳ��ʹ������map[]�еĴ𰸱��޸�
			flag = true;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(j<8)
						System.out.print(map[i][j] + " ");
					else
						System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		if(map[r][c] != '*'){
			int tc = c,tr = r;
			if(tc == 8){
				tr++;
				tc = 0;
			}else{
				tc++;
			}
			dfs(tr,tc);
			
			//   !!!  ����  ��������
			//   ��һ������ʱ��û�������if��������ʱ�� ʹ��return
			//   ������� ȱ��return��� �ᵼ�� �����е� �������ֱ����ģ��Ӷ���������ȷ���
			
			//   ���ﲻreturn����������ִ�е������forѭ���У���һ��map[r][c]���ܿ��������֡�9��
			//   ����map[r][c]�����ϣ����ϣ������ŷ����ж�û�����֡�5����
			//   ��ô�ͻὫԭ�������֡�9���ı�Ϊ���֡�5��
			//	 ���ӣ�map[4][5]
			//   
			return;
			//System.out.println("����û��return��  " + r + " " + c);
		}
		
		int i = 1;
		for(; i <= 9; i++){
			
			if(check(r,c,i)){//������λ�ÿ�����������i
				//System.out.println("��������� " + r + " " + c + " " + i);
				map[r][c] = (char) ('0' + i);
				row[r][i] = true;
				col[c][i] = true;
				rea[r/3*3 + c/3][i] = true;
				//��׮���鿴������Ϣ  ������� ȱ��return��� �ᵼ�� �����е� �������ֱ����ģ��Ӷ���������ȷ���  ���ӣ�map[4][5]
//				if(r == 4 && c == 5){
//					for(int i1 = 0; i1 < 9; i1++){
//						for(int j = 0; j < 9; j++){
//							if(j<8)
//								System.out.print(map[i1][j] + " ");
//							else
//								System.out.print(map[i1][j]);
//						}
//						System.out.println();
//					}
//				}
				
				int tc = c;
				int tr = r;
				if(tc == 8){
					tr++;
					tc = 0;
				}else{
					tc++;
				}
				
				//System.out.println(tr + " " + tc + " " + i);
				dfs(tr,tc);
				
				map[r][c] = '*';
				row[r][i] = false;
				col[c][i] = false;
				rea[r/3*3 + c/3][i] = false;
			}
			
		}
	}

	private static boolean check(int r, int c, int i) {
		return  !row[r][i] && !col[c][i] && !rea[r/3*3 + c/3][i];
	}

}
