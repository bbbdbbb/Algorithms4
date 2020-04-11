package practice.jsk05;

public class t01 {
    public static void main(String[] args) {
    	int n = 998244353;
       for(int k = 29; k > 0; k--){
    	   if(n % 10 == 0){
    		   n = n / 10;
    	   }else{
    		   n--;
    	   }
       }
       System.out.println(n);
        
    }
}
