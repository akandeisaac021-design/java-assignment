import java.util.Scanner;
public class TaskThirteen{
    public static void main(String []args){


Scanner scanner =new Scanner(System.in);

System.out.print("Enter your name: ");
String name =scanner.nextLine().toLowerCase();

int index =0;
int count =0;

while (index <name.length()){
    if (name.charAt(index) =='e'){
        count +=1;
    }
index++;

}

System.out.println(count);
}
}
