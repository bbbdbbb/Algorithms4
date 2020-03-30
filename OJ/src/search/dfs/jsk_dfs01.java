package search.dfs;

import java.util.Scanner;

/** dfs,�Թ�
 * ������������������һ��
 * �й����塰�����ա�
 * https://www.jisuanke.com/course/6497
*    
* ��Ŀ���ƣ�OJ   
* �����ƣ�jsk_dfs01   
* ��������   
* �����ˣ�bbbdbbb   
* ����ʱ�䣺2020��3��30�� ����2:24:41   
* @version        
*/
public class jsk_dfs01 {
	
	public static char[][] maze   = new char[10][9];
	public static boolean[][] vis = new boolean[10][9];
	public static int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	public static boolean flag = false;

	public static void main(String[] args) {		

		Scanner scan = new Scanner(System.in);
		//�ӿ���̨��ȡ����
		int x = 0, y = 0;//��¼��������
		for(int i = 0; i < 10; i++){
			//��ȡ  ��
			String str = scan.next();
			//��str�е�Ԫ�طֱ𴢴浽 maze����i���е�ÿһ��
			for(int j = 0; j < 9; j++){
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == 'S'){
					x = i;
					y = j;
				}
			}
		}
		
		dfs(x,y);
		if(flag){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
		for(int i = 0; i < 10; i++){
			for(char ch : maze[i]){
				System.out.print(ch);
			}
			System.out.println();
		}
		
		
	}


	private static void dfs(int x, int y) {
		
		//��maze[x][y]����Ϊ�Ѿ��߹��ı��
		vis[x][y] = true;
//		maze[x][y] = 'm';
		
		if(flag){
			return;
		}
		
		if(maze[x][y] == 'T'){
			flag = true;
			return;
		}
		

		
		//�������
		for(int i = 0; i < 8; i++){
			//�����һ���������������
			int tx = x + dir[i][0];
			int ty = y + dir[i][1];
			if(in(tx,ty) && maze[tx][ty] != '#' && !vis[tx][ty]){
				dfs(tx,ty);
			}
		}
		
//		//��ǰλ���������ʧ�ܣ�����ǰλ��״̬�ָ�Ϊû�з���
//		vis[x][y] = false;
//		maze[x][y] = '.';
//		
//		return;
	}


	private static boolean in(int tx, int ty) {
		return tx >= 0 && tx < 10 && ty >= 0 && ty < 9;
	}
	
	

}
