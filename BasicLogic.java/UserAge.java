import java.util.Scanner;
public class UserAge{
public static void main (String [] arg){
System.out.print("Enter your age: ");
Scanner input = new Scanner(System.in);
int age = input.nextInt();
System.out.print("Age next year: ");
int agenextyear= age + 1;
System.out.print(agenextyear);
}
}
