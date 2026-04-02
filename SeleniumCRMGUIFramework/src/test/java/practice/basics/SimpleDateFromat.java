package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFromat {

	public static void main(String[] args) {
	
	Date dateObj=new Date();
				
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String actDate=sim.format(dateObj);
	System.out.println("Actual Date:"+actDate);
	
	SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=sim1.getCalendar();
    cal.add(Calendar.DAY_OF_MONTH,30);
    String dataRequries=sim.format(cal.getTime());
    System.out.println("Before Date:"+dataRequries);			
	}
}
