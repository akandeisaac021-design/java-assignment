import java.util.Scanner;
import java.util.Random;


public class TaskFour{

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


while (guessedNumber !=randomNumber){
    System.out.println("You guessed in-correctly");
    System.out.print("re-enter a number from(1-20): ");
    guessedNumber =scanner.nextInt();
    
}


System.out.println("You guessed correctly: Good job my boy!!");


    }
}
