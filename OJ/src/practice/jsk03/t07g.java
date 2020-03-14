package practice.jsk03;

import java.util.Scanner;

public class t07g {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[][] chessboard = new int[9][9];
		int[] dx = {-1,-1,1,1};
		int[] dy = {-1,1,1,-1};
		
		int[] chedx = {-1,0,1,0};
		int[] chedy = {0,1,0,-1};
		
		int[] hhdx = {-1,-1,1,1,-1,0,1,0};
		int[] hhdy = {-1,1,1,-1,0,1,0,-1};
		
		boolean flag = true;
		
		for(int i = 0; i < n; i++){
			String chess = scan.next();
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			if("B".equals(chess)){// 象
				if(chessboard[x][y] == 1){
					flag = false;
				}
				chessboard[x][y] = 2;//有棋
				for(int j = 0; j < 4; j++){
					int nx = x + chedx[j];
					int ny = y + chedy[j];
					for(;nx<=8 && ny<=8 && nx>=0 && ny>=0;){
						if(chessboard[nx][ny] == 2){
							flag = false;	
						}
						chessboard[nx][ny] = 1;
						nx += dx[j];
						ny += dy[j];
					}
				}
				
			}else if("R".equals(chess)){// 车
				if(chessboard[x][y] == 1){
					flag = false;
				}
				chessboard[x][y] = 2;
				for(int j = 0; j < 4; j++){
					int nx = x + chedx[j];
					int ny = y + chedy[j];
					for(;nx<=8 && ny<=8 && nx>=0 && ny>=0;){
						if(chessboard[nx][ny] == 2){
							flag = false;	
						}
						chessboard[nx][ny] = 1;
						nx += chedx[j];
						ny += chedy[j];
					}
				}
				
			}else{ // 皇后
				if(chessboard[x][y] == 1){
					flag = false;
				}
				chessboard[x][y] = 2;
				for(int j = 0; j < 8; j++){
					int nx = x + hhdx[j];
					int ny = y + hhdy[j];
					for(;nx<=8 && ny<=8 && nx>=0 && ny>=0;){
						if(chessboard[nx][ny] == 2){
							flag = false;	
						}
						chessboard[nx][ny] = 1;
						nx += hhdx[j];
						ny += hhdy[j];
					}
				}
				
				
			}
		}
		
		if(flag){
			System.out.println("Safe!");
		}else{
			System.out.println("Attack!");
		}
		
	}

}
