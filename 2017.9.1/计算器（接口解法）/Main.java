import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	String formula;
    	char op;
    	float x1;
    	float x2;
//    	float result;
    	
    	System.out.println("Please input the formula");
    	formula = scanner.nextLine();
    	formula = formula.replace(" ","");
    	x1 = Float.parseFloat(String.valueOf(formula.charAt(0)));
    	x2 = Float.parseFloat(String.valueOf(formula.charAt(2)));
    	op = formula.charAt(1);
    	
    	switch (op)
		{
		case '+':
			Calculator add = new Calculator();
			add.Add(x1, x2);
			break;
		case '-':
			Calculator minus = new Calculator();
			minus.Minus(x1, x2);
			break;
		case '*':
			Calculator multiply = new Calculator();
			multiply.Multiply(x1, x2);
			break;
		case '/':
			Calculator devede = new Calculator();
			devede.Devide(x1, x2);
			break;
		default:
			System.out.println("Error input!");
			break;
		}
    	
    	scanner.close();
    }
}
