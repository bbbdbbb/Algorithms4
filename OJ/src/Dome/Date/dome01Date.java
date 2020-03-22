package Dome.Date;

import java.util.Date;
/**
 * Java类库分别包含两个与时间有关的类：
 * （1）用于表示时间点的Date类
 * （2）用于表示日历的LocalDate类
*    
*   （1）java.util.Date
*   		类 Date 表示特定的瞬间，精确到毫秒。 
*   		1 天 = 24 × 60 × 60 = 86400 秒 
*   		1秒  = 1000毫秒
*   		1天  = 86400000毫秒
*    
* 项目名称：OJ   
* 类名称：dome01Date   
* 类描述：Date类的dome   
* 创建人：bbbdbbb   
* 创建时间：2020年3月22日 下午7:41:29   
* @version
 */
public class dome01Date {

	public static void main(String[] args) {

		//dome01();
		dome02();
		dome03();
	}

	
	/*
	 * Date类的 getTime()方法
	 * 将当前Data对象转换成毫秒值（以1970年1月1日为原点）
	 */
	private static void dome03() {

		System.out.println("dome03:");
		
		Date date = new Date();
		System.out.println(date.getTime());
	}

	/*
	 * Date类的有参构造方法，传如一个long类型的毫秒值
	 * Date类会将传入的毫秒值 从1970年1月1日开始计算，转换成相应的日期
	 */
	private static void dome02() {

		System.out.println("dome02:");
		
		Date someday = new Date(0L);
		System.out.println(someday);
	}

	/*
	 * Date类的无参数构造方法，以当前时间点创建一个新对象
	 */
	private static void dome01() {
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());

	}

}
