package com.zr.test1;
import java.util.*;
public class TestYMD {
	public static void main(String[] args) 
	{
		String str;
		
		
		try(Scanner scanner=new Scanner(System.in))
		{
			str=scanner.nextLine();
			String year=str.substring(0, 4);
			String month=str.substring(4,6);
			String day=str.substring(6,8);
			if(str.length()!=8)
				throw new Exception("The length must be 8.");
			if(Integer.parseInt(year)<1000||Integer.parseInt(year)>9999)
				throw new Exception("The year must be 1000-9999.");
				
			if(Integer.parseInt(month)>12||Integer.parseInt(month)<01)
				throw new Exception("Month Error.");
			switch (Integer.parseInt(month))
			{
				case 1:case 3:case 5:case 7:case 8:case 10:case 12:
					if(Integer.parseInt(day)>31||Integer.parseInt(day)<01)
						throw new Exception("Day Error.");
					break;
				case 4:case 6:case 9:case 11:
					if(Integer.parseInt(day)>30||Integer.parseInt(day)<01)
						throw new Exception("Day Error.");
					break;
				case 2:
					if((Integer.parseInt(year)%4==0 && Integer.parseInt(year)%100!=0)||Integer.parseInt(year)%400==0)
					{
						if(Integer.parseInt(day)>29)
							throw new Exception("Day Error.");
					}
					else 
						if(Integer.parseInt(day)>28)
							throw new Exception("Day Error.");
					break;
				default:
					break;
			}
			System.out.println("year="+year+",month="+month+",day="+day);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}


