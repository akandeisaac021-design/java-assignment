public class JavaCupcakes{

    public static boolean[] checkIfNumberIsEven(int [] numbers){

        boolean [] newArray =new boolean[numbers.length];

        for (int index =0; index <numbers.length; index++){
            if (numbers[index] %2 ==0){
                newArray[index] =true;
            }
            else{
                newArray[index] =false;
            }
        }      

        return newArray;
    }

    

    public static int [] doubleTheLengthAndDoubleTheValue(int [] numbers){

        int [] doubleSizeArray =new int[numbers.length *2];

        for (int index =0; index <numbers.length; index++){
            doubleSizeArray[index] =numbers[index];
        }

        for (int index =0 ;index <doubleSizeArray.length; index++){
            doubleSizeArray[index +numbers.length] =numbers[index] * 2;          
        }

        return doubleSizeArray;
    }

}
