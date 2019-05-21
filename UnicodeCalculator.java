package unicodecalculator;
import java.util.Scanner;
import java.lang.Math;

public class UnicodeCalculator {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input the first string:");
		var s1 = s.nextLine();
		System.out.println("Input the second string:");
		var s2 = s.nextLine();
		s.close();

		var r1 = 0;
		for (int i = 0; i < s1.length(); i++) {
			r1 += s1.charAt(i);
		}

		var r2 = 0;
		for (int i = 0; i < s2.length(); i++) {
			r2 += s2.charAt(i);
		}

	    System.out.println("Absolute difference between the unicode values of each string: " + Math.abs(r2-r1));
	}
}
