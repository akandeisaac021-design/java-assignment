import java.util.Scanner;
import java.util.Random;


public class TaskTwo{
    public static void main(String [] args){

Scanner scanner =new Scanner(System.in);
Random random =new Random();

int min =1;
int max =20;

int randomNumber =random.nextInt(max -min +1) +min;


System.out.println("Guess a number from(1-20): ");
int guessedNumber =scanner.nextInt();

while (guessedNumber < 1 || guessedNumber >20){
    System.out.println("re-enter a valid number from(1-20)");
    guessedNumber =scanner.nextInt();
}


if (randomNumber !=guessedNumber){
    System.out.printf("The corrct answer is : " + randomNumber);
    System.out.println("You guessed in-correctly!!: The corrct answer is : " + randomNumber);
    
}


   }
}
