package groupFour;

import java.util.ArrayList;
import java.util.List;

public class HugeInteger {

    public int[] parse(String numbers) {

        if(numbers.matches("[^0-9]+ {1,40}")){
            throw new IllegalArgumentException("input cannot be empty");
        }

        int [] hugeIntegerArray = new int[numbers.length()];

//        List<Integer> hugeIntegerArray = new ArrayList<>();

        for(int count = 0; count < numbers.length(); count ++){

            hugeIntegerArray[count] = numbers.charAt(count) - '0';
        }
        return hugeIntegerArray;
    }

    public String toString(int [] numbers){

        String result ="[";

        for(int count =0; count < numbers.length; count++){
            result +=String.valueOf(numbers[count]);
            if (count < numbers.length-1){
                result +=", ";
            }
        }

        result +="]";
        return result;
    }

    public boolean isEqualTo(int [] array1, int [] array2){

        return array1 == array2;
    }

    public boolean isNotEqualTo(int [] array1, int [] array2){
        return array1 != array2;
    }

    /*isGreaterThan,isLessThan,isGreaterThanOrEqualsTo,isLessThanOrEqualsTo,addition,subtraction,?constructor*/


}
