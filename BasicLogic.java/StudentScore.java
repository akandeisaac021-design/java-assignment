import java.util.Scanner;
public class StudentScore{
public static void main (String [] args){
System.out.print("Enter your first score: ");
Scanner input = new Scanner(System.in);
int score1 =input.nextInt();
System.out.print("Enter your second score: ");
int score2 =input.nextInt();
System.out.print("Enter your third score: ");
int score3 =input.nextInt();
System.out.println("Total scores:");
int total =score1+score2+score3;
System.out.println(total);
System.out.print("Average score: ");
double avg = total/3;
System.out.print(avg);
}
}
