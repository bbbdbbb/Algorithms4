package chapter1;

/**   
*    
* 项目名称：Algorithms4   
* 类名称：P1_3_16   
* 类描述： 练习1.3.16,使用1.3.1.5节中的readInts()作为模板为Date编写一个静态方法readDates()，
* 		从标准输入中读取由练习1.2.19的表格所指定的格式的多个日期并返回一个它们的数组。  
* 
* 		可以先看看我collection包里Date类的实现
* 		再看看我Test包里的readDatesTest，那里有readDates()的测试案例
* 
* 创建人：bbbdbbb   
* 创建时间：2020年2月8日 下午8:43:42   
* @version        
*/
public class P1_3_16 {
//	package collection;
//
//	import edu.princeton.cs.algs4.In;
//	import edu.princeton.cs.algs4.Queue;
//
//	public class Date {
//		private final int month;
//		private final int day;
//		private final int year;
//		
//		public Date(int m,int d,int y){
//			month = m;
//			day = d;
//			year = y;
//		}
//		public Date(String date){
//			String[] fields = date.split("/");
//			month = Integer.parseInt(fields[0]);
//			day = Integer.parseInt(fields[1]);
//			year = Integer.parseInt(fields[2]);
//			
//		}
//		
//		public String toString(){
//			return ""+year+"-"+month+"-"+day;
//		}
//		public int compareTo(Date when) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//		public static Date[] readDates(String fileName){
//			In in = new In(fileName);
//			Queue<String> q = new Queue<String>();
//			while(!in.isEmpty())
//				q.enqueue(in.readString());
//			
//			int N = q.size();
//			Date[] a = new Date[N];
//			for(int i=0;i<N;i++){
//				a[i] = new Date(q.dequeue());
//			}
//			return a;
//		}
//	}


	
	
	
//	package Test;
//
//	import collection.Date;
//
//	public class readDatesTest {
//		
//		public static void main(String[] args) {
//			Date[] dates = Date.readDates("test-data\\readDatesTest_file.txt");
//			for(int i=0;i<dates.length;i++){
//				System.out.println(dates[i]);
//			}
//		}
//
//	}

}
