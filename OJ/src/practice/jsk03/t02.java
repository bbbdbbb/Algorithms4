package practice.jsk03;

public class t02 {

	public static void main(String[] args) {
		
		int[][] nums = new int[21][21];

		for(int i=1; i <= 20; i++){
			for(int j = 1; j <= 20; j++){
				if(j == 1){
					nums[i][j] = 1;
				}
				if(j == i){
					nums[i][j] = 1;
				}else if(j > i){
					nums[i][j] = 0;
				}else{
					nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
				}
				
			}
			
		}
		
		
		for (int i = 1; i < 21; i++) {
			for (int j = 1; j < 21; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}

}
