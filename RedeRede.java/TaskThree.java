import java.util.Scanner;
import java.util.Random;


public class TaskThree{

    public static void main (String [] args){
Scanner scanner =new Scanner(System.in);
Random random =new Random();

int min =1;
int max =20;

int randomNumber =random.nextInt(max -min +1) +min;


System.out.println("Guess a number from(1-20): ");
int guessedNumber =scanner.nextInt();

while (guessedNumber < 1 || guessedNumber >20){
    if (guessedNumber >20){
        System.out.print("Input too high");
        System.out.println("re-enter a valid number from(1-20)");
        guessedNumber =scanner.nextInt();
    }
    else if ( guessedNumber <1){
        System.out.print("Input too low");
        System.out.println("re-enter a valid number from(1-20)");
        guessedNumber =scanner.nextInt();

    }

}

if (randomNumber !=guessedNumber){
    System.out.println("You guessed in-correctly!!: The corrct answer is : " + randomNumber);
    
}





    }

}
