import java.util.Scanner;
public class SquaresAndCubes{
public static void main(String []args){
System.out.println("Enter number: ");
Scanner input = new Scanner(System.in);
int number =input.nextInt();
int sqr =number*number;
int cube =number*number*number;
System.out.println("Square: ");
System.out.println(sqr);
System.out.println("Cube: ");
System.out.println(cube);
}
}
