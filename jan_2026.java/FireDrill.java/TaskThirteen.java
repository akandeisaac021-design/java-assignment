import java.util.Arrays;

public class TaskThirteen{

    public static int[] OddAndEvenIndexSwapper(int[] scores){

int intialConter =0;
while (scores[intialConter] % 2 == 0){
    intialConter++;
    break;
    

    int [] oddIndexArray =new int [5];

    int oddIndexArrayCounter =0;
    int scoreIndexCounter =1;
    while (scoreIndexCounter <10){
        oddIndexArray [oddIndexArrayCounter] =scores[scoreIndexCounter];
        scoreIndexCounter +=2;
    }



    int [] evenIndexArray =new int [5];

    int evenIndexArrayCounter =-2;
    scoreIndexCounter =1;

    while (scoreIndexCounter <10){
        evenIndexArray [evenIndexArrayCounter] =scores[scoreIndexCounter];
        scoreIndexCounter +=2;
    }

    int newOddPositionCounter =-1;
    int evencounter =0;

    while (newOddPositionCounter <10){
        newOddPositionCounter +=2;
        scores[newOddPositionCounter] =evenIndexArray[evencounter];
        evencounter++;
    }

    int newEvenPositionCounter =-1;
    int oddCounter =0;

    while (newEvenPositionCounter <10){
        newEvenPositionCounter +=2;
        scores[newEvenPositionCounter] =oddIndexArray[oddCounter];
        oddCounter++;
    }

}
    return scores;



    }

} 
