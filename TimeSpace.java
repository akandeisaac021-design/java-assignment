import java.util.Scanner;
public class TimeSpace{
public static void main(String []args){
Scanner input = new Scanner(System.in);
System.out.println("Input Seconds: ");
int secs =input.nextInt(); 
int mins =secs/60;
int hours =mins/60;
System.out.println("Time: ");
if(secs>=60){System.out.println(mins);}
else if(secs<60){System.out.println(secs);}
else if(mins>=60){System.out.print(hours);}
}
}
