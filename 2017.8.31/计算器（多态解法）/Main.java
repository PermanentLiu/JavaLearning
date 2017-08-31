import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String formula;
		float x1;
		float x2;
		float result = 0;
//		char op;
		char temp;
		
		
		System.out.println("Press 'q' to leave this programme");
		System.out.println("Please input the formula");
		formula = scanner.nextLine();
		x1 = Float.parseFloat(String.valueOf(formula.charAt(0)));
		x2 = Float.parseFloat(String.valueOf(formula.charAt(2)));
		temp = formula.charAt(1);
		switch(temp)
		{
		case '+':
			Calculator add = new Add(x1, x2);
			result = add.back();
			break;
		case '-':
			Calculator minus = new Minus(x1, x2);
			result = minus.back();
			break;
		case '*':
			Calculator multiply = new Multiply(x1, x2);
			result = multiply.back();
			break;
		case '/':
			Calculator devide = new Devide(x1, x2);
			result = devide.back();
			break;
		default:
			Calculator calculator = new Calculator(x1, x2);
			calculator.back();
		}
		System.out.println("the result is " + result);
		
		
		scanner.close();
	}
}
