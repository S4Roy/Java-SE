import java.lang.*;
import java.util.*;

class ReadingFromKeyboard{
		public static void main(String args[]){
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name");
		name = sc.nextLine();
		System.out.println("Welcome "+name);
	}
}
