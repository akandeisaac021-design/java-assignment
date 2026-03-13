import java.util.Scanner;
import java.util.Arrays;

public class TaskTwo{
    public static void main (String[] args){

Scanner scanner =new Scanner(System.in);

int [] scores =new int [10];
int scoreCounter =0;

while (scoreCounter <10){
    System.out.print("Enter a score: ");
    int score =scanner.nextInt();
    scores[scoreCounter] =score;    
    scoreCounter++;

}
int scoreIndexCounter =0;
while (scoreIndexCounter <10){
    System.out.println(scores[scoreIndexCounter]);
    scoreIndexCounter++;

}    



    }
}
