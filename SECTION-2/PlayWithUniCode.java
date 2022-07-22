import java.lang.*;
class PlayWithUniCode
{
	public static void main(String args[])
	{
		//visit unicode.org
		
		char x = 0X0980;
		System.out.println(x);
		
		// bengali
		
		for(char c = 0X0980; c <= 0X09FF; c++)
		{
			System.out.print(c + " ");
		}
		
		// myName
		
		String myName = "Subhankar";
		System.out.println("");
		System.out.println(myName);		
		System.out.println("");
		
		char S = 0X09B6;
		char u = 0X09C1;
		char bh = 0X09AD;
		char an = 0X0999;
		char ka = 0X0995;
		char r = 0X09B0;
		
		System.out.print(S);
		System.out.print(u);
		System.out.print(bh);
		System.out.print(an);
		System.out.print(ka);
		System.out.print(r);
		System.out.println("");
	}
}
