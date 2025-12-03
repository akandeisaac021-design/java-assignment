import java.util.Scanner;
public class AreaOfRectangle{
public static void main(String []args){
System.out.println("Area of rectangle: ");
Scanner input = new Scanner(System.in);
System.out.println("Enter your length: ");
int length = input.nextInt();
System.out.println("Enter your breadth: ");
int breadth = input.nextInt();
int area = length * breadth;
System.out.print(area);
}
}
