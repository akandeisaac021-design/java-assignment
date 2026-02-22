import java.util.Scanner;
import java.util.Arrays;

public class TaskEighteen{
    public static void main(String []args){


Scanner scanner =new Scanner(System.in);

System.out.print("Enter a number: ");
String number =scanner.nextLine();

int length =number.length();
int count =0;
int digit =0;

int [] digits =new int [length]; 
while (count <length){
    digits[count] =Integer.valueOf(number.charAt(count) - '0');
    digit +=Integer.valueOf(number.charAt(count) - '0');
    count++;
}
Arrays.sort(digits);

System.out.println(digits[count -1]);



    }
}
