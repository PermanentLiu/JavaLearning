import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input a calculation");
		String calculation = scanner.nextLine();
		char char1 = calculation.charAt(0);
		char operation = calculation.charAt(1);
		char char2 = calculation.charAt(2);
		
		int num1 = (int)char1 - 48;
		int num2 = (int)char2 - 48;
		
		switch (operation)
		{
		case '+':
			Jia cal1 = new Jia();
			cal1.getNumber(num1, num2);
			System.out.println(calculation + " = " + cal1.setNumber());
			break;
		case '-':
			Jian cal2 = new Jian();
			cal2.getNumber(num1, num2);
			System.out.println(calculation + " = " + cal2.setNumber());
			break;
		case '*':
			Cheng cal3 = new Cheng();
			cal3.getNumber(num1, num2);
			System.out.println(calculation + " = " + cal3.setNumber());
			break;
		case '/':
			Chu cal4 = new Chu();
			cal4.getNumber(num1, num2);
			System.out.println(calculation + " = " + cal4.setNumber());
			break;
		default:
			System.out.println("Error!");
			break;
		}
		
		
		
		
		
		
		
		
		scanner.close();
	}
}
