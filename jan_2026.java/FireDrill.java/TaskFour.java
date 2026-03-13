import java.util.Arrays;

public class TaskFour{
    

    public static int[] TakeAndGiveEven(int[] scores){


int [] evenIndexArray =new int [5];

int evenIndexCounter =-2;
int scoreIndexCounter =1;

while (scoreIndexCounter <10){
    evenIndexArray [scoreIndexCounter] =scores[evenIndexCounter];
    scoreIndexCounter +=2;
}
    return evenIndexArray;


    }


}
