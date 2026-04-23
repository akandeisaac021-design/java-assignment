import java.util.Scanner;
public class Area{
public static void main(String []args){
System.out.println("Area: ");
Scanner input = new Scanner(System.in);
System.out.println("Enter your length: ");
int length = input.nextInt();
System.out.println("Enter your breadth: ");
int width = input.nextInt();
int area = length * width;
System.out.println("Area");
System.out.println(area);
}
}
