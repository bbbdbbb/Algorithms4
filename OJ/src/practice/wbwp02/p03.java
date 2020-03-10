package practice.wbwp02;

/**     
* 类描述：   蓝桥杯周周练2 题目三  方格计数        
*/
public class p03 {

	public static void main(String[] args) {
		
		int count = 0;
		
		//计算第一象限有多少个完整的方格
		for(int x = 1; x <= 1000; x++){
			for(int y = 1; y <= 1000; y++){
				//判断第一象限的每一个方格的左上角到圆心的距离是不是小于半径
				if(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)) <= 1000){
					count++;
				}
			}
		}
		
		//第一象限的方格数乘以4
		System.out.println(4*count);
	}

}
