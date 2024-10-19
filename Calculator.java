import java.util.Scanner;

public class Calculator {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Calculator!");
    System.out.println("Enter two numbers");

    double num1 = scanner.nextDouble();
    double num2 = scanner.nextDouble();

    System.out.println("Select an operation: +, -, *, /");
    char operator = scanner.next().charAt(0);

    double result = 0;

    switch (operator) {
      case '+':
      result = num1 + num2;
      break;

      case '-':
      result = num1 = num2;
      break;
      case '*':
      result = num1 * num2;
      break;
      case '/':
      if (num2 == 0){
        System.out.println("ErrorL Cannot divide by zero!");
        return;
      }else{
        result = num1 / num2;
      }
      break;
      default:
      System.out.println("Error: Invalid operator!");
      return;
    }

    System.out.println("The result is: " + result);
    scanner.close();
  }
}