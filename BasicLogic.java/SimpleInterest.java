import java.util.Scanner;
public class SimpleInterest{
public static void main(String []args){
Scanner input = new Scanner(System.in);
System.out.println("Enter your principal: ");
double principal =input.nextDouble();
System.out.println("Enter your rate: ");
double rate =input.nextDouble();
System.out.println("Enter your time: ");
int time =input.nextInt();
double simpleinterest =principal*rate*time/100;
System.out.println(simpleinterest);
}
} 



