package practice.jsk03;

public class t04 {

	public static void main(String[] args) {

		int count = 0;
		for(int a = 1; a<=6;a++){
			for(int b = 1; b <= 6 && a+b < 10; b++){
				for(int c = 1; c <= 6 && a+b+c < 10; c++){
					for(int d = 1; d <= 6 && a+b+c+d < 10; d++){
						for(int e = 1; e <= 6 && a+b+c+d+e <= 10; e++){
							if(a+b+c+d+e == 10){
								System.out.println(""+a+b+c+d+e);
								count++;
							}
						}
					}
				}
			}
		}
		
		
		System.out.println(count);
	}

}
