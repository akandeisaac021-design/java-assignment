import java.util.Scanner;

public class WordLengthMethod{
    public static int wordLength(String[] args){

Scanner scanner =new Scanner(System.in);
System.out.print("Enter a word: ");
String word = scanner.nextLine();
    
int wordLength =word.length();

System.out.println(wordLength);
    return wordLength
    }
}
