//application from Jakc Zhao
//wocao
public class LeapYear{
	public static void main(String[]args){
		int year=2010;
		if (args.length!=0)
			year=Integer.parseInt(args[0]);
		if((year%4==0 && year%100!=0)||(year%400==0))
			System.out.println(year+"is LeapYear");
		else
			System.out.println(year+"is not LeapYear");
	}
}