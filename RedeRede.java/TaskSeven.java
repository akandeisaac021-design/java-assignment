import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class TaskSix{

    public static void main(String [] args){

Scanner scanner =new Scanner(System.in);
Random random =new Random();
int [] guessedNumbers =new int [10];

int min =1;
int max =20;


int randomNumber =random.nextInt(max -min +1) +min;

System.out.println("Guess a number from(1-20): ");
int guessedNumber =scanner.nextInt();


while (guessedNumber < 1 || guessedNumber >20){
    System.out.println("re-enter a valid number from(1-20)");
    guessedNumber =scanner.nextInt();
}
guessedNumbers[0] =guessedNumber;
int counter =1;
int indexCounter =1;

while (guessedNumber !=randomNumber){    
    if (counter >= 10){
        break;

    }
    System.out.println("You guessed in-correctly");
    System.out.print("re-enter a number from(1-20): ");
    guessedNumber =scanner.nextInt();
    counter++;
    guessedNumbers[indexCounter] =guessedNumber;
    indexCounter++;
    
}

if (guessedNumber !=randomNumber){
    System.out.println("GAME OVER");
    System.out.println("The correct number is : " + randomNumber);
}

else if (guessedNumber ==randomNumber){
    System.out.println("You won in : " + counter + "-Attempts" );
    System.out.println("You guessed correctly: Good job my boy!!");
}

System.out.println(Arrays.toString(guessedNumbers));

    }
}
