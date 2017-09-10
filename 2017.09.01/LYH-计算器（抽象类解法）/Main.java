import java.util.Scanner;
import java.util.StringJoiner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String formula;
		float x1;
		float x2;
		float result = 0;
		char temp;
		
		formula = scanner.nextLine();
		x1 = Float.parseFloat(String.valueOf(formula.charAt(0)));
		x2 = Float.parseFloat(String.valueOf(formula.charAt(2)));
		temp = formula.charAt(1);
		
		switch (temp)
		{
		case '+':
			Calculator add = new Add();
			result = add.operate(x1, x2);
			break;
		case '-':
			Calculator minus = new Minus();
			result = minus.operate(x1, x2);
			break;
		case '*':
			Calculator mutiply = new Mutiply();
			result = mutiply.operate(x1, x2);
			break;
		case '/':
			Calculator devide = new Devide();
			result = devide.operate(x1, x2);
			break;
		default:
			System.out.println("Error input!");
			break;
		}
		
		System.out.println("The result is " + result);
		
		
		scanner.close();
	}
}
