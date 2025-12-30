import java.util.Scanner;

public class Mortgage{
    public static void main(String[] args){

Scanner scanner =new Scanner(System.in);

System.out.print("Enter your principle: ");
int principle =scanner.nextInt();

System.out.print("Enter your annual Interest: ");
int annualInterest =scanner.nextInt();

System.out.print("Enter your duration: ");
int duration =scanner.nextInt();
 
System.out.print("Enter your rate: ");
int rate =scanner.nextInt();

double numerator =Math.pow(rate*( 1 + rate), duration);
double denominator =Math.pow((annualInterest + rate ), duration) -1;

double monthlyPaymentValue =principle * numerator / denominator;


System.out.println("Monthly payment value");
System.out.println(monthlyPaymentValue);

    }
}
