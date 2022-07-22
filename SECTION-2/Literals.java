import java.lang.*;

class Literals
{
	public static void main(String args[])
	{
		byte b = 10;
		byte b1 = 0b1010;
		byte b2 = 012;
		byte b3 = 0XA;
		long l = 9999999999L;
		float f = 10.2f;
		double d = 10.256d;
		//for long number we can use underscore(_) for readability [like : 10,400]
		int val = 10_400;
		System.out.println("from decimal : " + b);
		System.out.println("from binary : " + b1);
		System.out.println("from octal : " + b2);
		System.out.println("from hexadecimal : " + b3);
		System.out.println("from long : " + l);
		System.out.println("from float : " + f);
		System.out.println("from double : " + d);
		System.out.println("readability : " + val);
	}
}
