import java.util.Scanner;
public class TaskTwelve{
    public static void main(String []args){


Scanner scanner =new Scanner(System.in);

System.out.print("Enter your name: ");
String name =scanner.nextLine().toLowerCase();

int index =0;
while (index <name.length()){
    System.out.println(name.charAt(index));
    index++;
}
    }
}
