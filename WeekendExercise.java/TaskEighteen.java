import java.util.Scanner;
public class TaskEighteen{
    public static void main(String []args){


Scanner scanner =new Scanner(System.in);

System.out.print("Enter a number: ");
String number =scanner.nextLine();

int length =number.length();
int count =0;
int digit =0;

while (count <length){
    digit +=Integer.valueOf(number.charAt(count) - '0');
    count++;
}

System.out.print(digit);



    }
}
