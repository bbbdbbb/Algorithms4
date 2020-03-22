package Dome.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。
 * 日期/时间格式化子类（如 SimpleDateFormat）允许进行格式化（也就是日期 -> 文本）、解析（文本-> 日期）和标准化。  
 * 
 * DateFormat 只是一个抽象类，需要使用它的子类SimpleDateFormat 来创建对象
 * 		y  年 
 * 		M  年中的月份  
 * 		w  年中的周数  
 * 		D  年中的天数  
 * 		d  月份中的天数 
 * 		E  星期中的天数  
*    
* 项目名称：OJ   
* 类名称：dome03DateFormat   
* 类描述： java.text.DateFormat  
* 创建人：bbbdbbb   
* 创建时间：2020年3月22日 下午8:09:20   
* @version        
*/
public class dome03DateFormat {

	public static void main(String[] args) throws ParseException {

		dome01();
		
		dome02();
	}

	
	/*
	 * 使用DateFormat类中的方法parse，把文本 格式转化为 日期
	 * 使用步骤：
	 * 	1.创建SimpleDateFormat对象，在构造方法中传递指定的模式
	 *  2.调用SimpleDateFormat对象中的方法parse，把符合构造方法中模式的字符串  解析为Date日期
	 *  注意：
	 *  	parse方法声明了一个异常-->ParseException,if字符串不符合构造方法中模式，则抛出异常
	 */
	private static void dome02() throws ParseException {
		System.out.println("dome02:测试DateFormat类中的方法parse()");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒");
	
		String dStr = "2020年03月22日   20时21分20秒";
		Date date = sdf.parse(dStr);
		System.out.println(date);
		System.out.println(dStr);
	}


	/*
	 * 使用DateFormat类中的方法format，把日期格式转化为文本
	 * 使用步骤：
	 * 	1.创建SimpleDateFormat对象，在构造方法中传递指定的模式
	 *  2.调用SimpleDateFormat对象中的方法format，按照方法中指定的模式，把Date日期格式化符合模式的字符串
	 */
	private static void dome01() {

		System.out.println("dome01:测试DateFormat类中的方法format()");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒");
	
		Date date = new Date();
		String dStr = sdf.format(date);
		System.out.println(date);
		System.out.println(dStr);
	}

}
