import java.util.Arrays;

public class TaskFive{
    

    public static int[] TakeAndGiveOdd(int[] scores){
int [] oddIndexArray =new int [5];

int oddIndexArrayCounter =0;
int scoreIndexCounter =1;
while (scoreIndexCounter <10){
    oddIndexArray [oddIndexArrayCounter] =scores[scoreIndexCounter];
    scoreIndexCounter +=2;
}
    return oddIndexArray;


    }


}
