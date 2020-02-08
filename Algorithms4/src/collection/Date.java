package collection;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Date {
	private final int month;
	private final int day;
	private final int year;
	
	public Date(int m,int d,int y){
		month = m;
		day = d;
		year = y;
	}
	public Date(String date){
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
		
	}
	
	public String toString(){
		return ""+year+"-"+month+"-"+day;
	}
	public int compareTo(Date when) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Date[] readDates(String fileName){
		In in = new In(fileName);
		Queue<String> q = new Queue<String>();
		while(!in.isEmpty())
			q.enqueue(in.readString());
		
		int N = q.size();
		Date[] a = new Date[N];
		for(int i=0;i<N;i++){
			a[i] = new Date(q.dequeue());
		}
		return a;
	}
}
