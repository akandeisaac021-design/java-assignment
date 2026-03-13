import java.util.Arrays;

public class TaskNine{

    public static int MinimumOfTaskFour(int [] oddIndexArray){

int counter =0;

while (counter <5){

    if (oddIndexArray[counter] >oddIndexArray[1] ){
        int tempSpace =oddIndexArray[counter];
        oddIndexArray[counter] =oddIndexArray[1];
        oddIndexArray[1] =tempSpace;

    }

    if (oddIndexArray[counter] >oddIndexArray[2] ){
        int tempSpace =oddIndexArray[counter];
        oddIndexArray[counter] =oddIndexArray[2];
        oddIndexArray[2] =tempSpace;

    }    

    if (oddIndexArray[counter] >oddIndexArray[3] ){
        int tempSpace =oddIndexArray[counter];
        oddIndexArray[counter] =oddIndexArray[3];
        oddIndexArray[3] =tempSpace;

    }    

    if (oddIndexArray[counter] >oddIndexArray[4] ){
        int tempSpace =oddIndexArray[counter];
        oddIndexArray[counter] =oddIndexArray[4];
        oddIndexArray[4] =tempSpace;

    }    

    if (oddIndexArray[counter] >oddIndexArray[5] ){
        int tempSpace =oddIndexArray[counter];
        oddIndexArray[counter] =oddIndexArray[5];
        oddIndexArray[5] =tempSpace;

    }    
    counter++;
}



    return oddIndexArray[0];


    }
}
