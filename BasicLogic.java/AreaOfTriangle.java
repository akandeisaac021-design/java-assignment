import java.util.Scanner;
public class AreaOfTriangle{
public static void main(String []args){
System.out.println("Area of triangle: ");
Scanner input = new Scanner(System.in);
System.out.println("Enter your base: ");
int base = input.nextInt();
System.out.println("Enter your height: ");
int height = input.nextInt();
double area = 0.5*base*height;
System.out.print("area");
System.out.print(area);
}
}
