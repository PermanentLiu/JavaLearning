package tx;

import java.util.Scanner;
import java.util.function.IntPredicate;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();//字符串的个数
		in.nextLine();
		
		
		for (int t = 1; t <= num; t++) {
			String string = in.nextLine();
			
			char flag0 = '0';
			char flag1 = '1';
			
			for (int i = 1; i < string.length(); i++) {
				if (flag0 != '0') {
					if (flag1 != '1') {
						if (string.charAt(i) == flag1) {
							string = removeCharAt(string, i);
							i--;
						}
						else {
							flag0 = '0';
							flag1 = '1';
						}
					}
					else {
						if (string.charAt(i) == flag0) {
							string = removeCharAt(string, i);
							i--;
						}
						else {
							flag1 = string.charAt(i);
						}
					}
					
				}
				else {
					if (string.charAt(i) == string.charAt(i - 1)) {
						flag0 = string.charAt(i);
					}
					else {
						continue;
					}
				}
				
				
				
			}
			
			
			
			
			System.out.println(string);
			
		}
		
	}
	public static String removeCharAt(String s, int pos) {
	      return s.substring(0, pos) + s.substring(pos + 1);
	   }
	
}
