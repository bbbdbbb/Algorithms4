package Test;

import collection.Date;

public class readDatesTest {
	
	public static void main(String[] args) {
		Date[] dates = Date.readDates("test-data\\readDatesTest_file.txt");
		for(int i=0;i<dates.length;i++){
			System.out.println(dates[i]);
		}
	}

}
