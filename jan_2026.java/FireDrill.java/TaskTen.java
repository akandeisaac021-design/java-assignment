import java.util.Arrays;

public class TaskTen{

    public static int MinimumOfTaskFour(int [] evenIndexArray){

int counter =0;

while (counter <5){

    if (evenIndexArray[counter] >evenIndexArray[1] ){
        int tempSpace =evenIndexArray[counter];
        evenIndexArray[counter] =evenIndexArray[1];
        evenIndexArray[1] =tempSpace;

    }

    if (evenIndexArray[counter] >evenIndexArray[2] ){
        int tempSpace =evenIndexArray[counter];
        evenIndexArray[counter] =evenIndexArray[2];
        evenIndexArray[2] =tempSpace;

    }    

    if (evenIndexArray[counter] >evenIndexArray[3] ){
        int tempSpace =evenIndexArray[counter];
        evenIndexArray[counter] =evenIndexArray[3];
        evenIndexArray[3] =tempSpace;

    }    

    if (evenIndexArray[counter] >evenIndexArray[4] ){
        int tempSpace =evenIndexArray[counter];
        evenIndexArray[counter] =evenIndexArray[4];
        evenIndexArray[4] =tempSpace;

    }    

    if (evenIndexArray[counter] >evenIndexArray[5] ){
        int tempSpace =evenIndexArray[counter];
        evenIndexArray[counter] =evenIndexArray[5];
        evenIndexArray[5] =tempSpace;

    }    
    counter++;
}



    return evenIndexArray[5];


    }
}
