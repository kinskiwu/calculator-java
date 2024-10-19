import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Calculator!");

    boolean continueCalculations = true;

    while(continueCalculations) {
      try {
        double num1 = getNumber(scanner, "Enter the first number: ");
        double num2 = getNumber(scanner, "Enter the second number: ");
        char operator = getOperator(scanner);

        double result = performOperation(num1, num2, operator);
        System.out.println("The result is: " + result);

        continueCalculations = askContinue(scanner);
      } catch(InputMismatchException e){
        System.out.println("Error: Please enter valid numbers!");
        scanner.next();
      } catch(ArithmeticException e){
        System.out.println(e.getMessage());
      }
    }

    System.out.println("Thank you for using the calculator. Bye!");
    scanner.close();
  }

  private static double getNumber(Scanner scanner, String message){
    System.out.print(message);

    while(!scanner.hasNextDouble()){
      System.out.println("Invalid input. Please enter a valid number.");
      scanner.next();
    }
    return scanner.nextDouble();
  }

  private static char getOperator(Scanner scanner){
    System.out.print("Select an operation (+, -, *, /, %, ^): ");
    char operator = scanner.next().charAt(0);
    while("+-*/%^".indexOf(operator) == -1){
      System.out.print("Invalid operator. Please enter one of +, -, *, /, %, ^: ");
      operator = scanner.next().charAt(0);
    }
    return operator;
  }

  private static double performOperation(double num1, double num2, char operator){
      switch (operator) {
        case '+':
        return num1 + num2;
      case '-':
        return  num1 = num2;
      case '*':
        return num1 * num2;
      case '/':
        if(num2 == 0) throw new ArithmeticException("Error: Cannot divide by zero!");
        return num1 / num2;
      case '%':
        if(num2 == 0) throw new ArithmeticException("Error: Cannot modulus with zero!");
        return num1 % num2;
      case '^':
        return Math.pow(num1, num2);
      default:
       throw new IllegalArgumentException("Error: Invalid operator!");
    }

  }

  private static boolean askContinue(Scanner scanner){
    System.out.print("Do you want to run another calculation? (yes/no): ");
    String response = scanner.next().trim().toLowerCase();
    while(!response.equals("yes") && !response.equals("no")){
      System.out.print("Invalid response. Please enter 'yes' or 'no' to continue.");
      response = scanner.next().trim().toLowerCase();
    }
    return response.equals("yes");
  }
}
