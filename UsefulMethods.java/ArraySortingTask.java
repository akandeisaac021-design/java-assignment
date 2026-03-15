import java.util.Arrays;

public class ArraySortingTask{

    static int count;

    public static int[] evenNumberIdentifier(){

        int [] numbers ={2,1,6,3,4};

        int [] evenNumbers=new int[3];

        count =0;

        int evenArrayCount =0;
    
        while (count <5){
            if (numbers[count] %2 ==0){
                evenNumbers[evenArrayCount] =numbers[count];
                evenArrayCount++;
            }
            count++;
        }
        return evenNumbers;

    }


    public static int[] evenNumbersArraySorter(int []evenNumbers){

        count =0;

        while (count <3){

            if (evenNumbers[count] >evenNumbers[1] ){
                int tempSpace =evenNumbers[count];
                evenNumbers[count] =evenNumbers[1];
                evenNumbers[1] =tempSpace;

            }

            if (evenNumbers[count] >evenNumbers[2] ){
                int tempSpace =evenNumbers[count];
                evenNumbers[count] =evenNumbers[2];
                evenNumbers[2] =tempSpace;

            }    

            count++;
        }
        return evenNumbers;
    }
        




}
