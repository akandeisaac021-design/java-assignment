public class MidDayTask{


    public static int[] squareArray(int [] numbers){

        for (int index =0; index < numbers.length; index++){

            numbers[index] =numbers[index] * numbers[index];      

        }

        sortArray(numbers);

        return numbers;
               
    }



    public static int [] sortArray(int [] numbers){

       int count =0;

       int [] newNumbers =new int [numbers.length];

        while (count <numbers.length){

            if (newNumbers[count] >newNumbers[count +1] ){
                int tempSpace =newNumbers[count];
                newNumbers[count] =newNumbers[count +1];
                newNumbers[count +1] =tempSpace;

            }
        }
        return newNumbers;
    }


}
