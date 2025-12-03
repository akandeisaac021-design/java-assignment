import java.util.Scanner;
public class Distance{
public static void main(String []args){
Scanner input = new Scanner(System.in);
System.out.println("Distance in Kilometers: ");
int distance =input.nextInt();
System.out.println("Distance in Miles: ");
double miles =distance*0.621371;
System.out.println(miles);
}
}   
