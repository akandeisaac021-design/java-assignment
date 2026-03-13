import java.util.Scanner;

public class WordMultiplier{
    public static void main(String[] args){

Scanner scanner =new Scanner(System.in);
System.out.print("Enter a word: ");
String word = scanner.nextLine();
    
System.out.print("Enter a multiple: ");
int multiple =scanner.nextInt();



int wordLength =word.length();
int expectedWordAmount =wordLength * multiple;

String newWord =" ";
int counter =0;
int multipleCounter =0;

int newWordLength =newWord.length();

while(newWordLength< expectedWordAmount){
    while(multipleCounter < multiple){
        newWord =newWord + word.charAt(counter);
        newWordLength =newWord.length();
        multipleCounter +=1;
    }
    multipleCounter =0;
    counter++;
}
System.out.println(newWord);



    }
}
