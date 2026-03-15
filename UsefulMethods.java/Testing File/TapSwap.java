public class TapSwap{

    public int[] tapSwapper(){
        int [] numbers ={ 5, 7, 6, 3, 2, 4};

        int index =0;

        int length =numbers.length;

        while(index +1 <=length){
            int temporaryStorage =numbers[index +1];

            numbers[index] =numbers[index +1];

            numbers[index+1] =numbers[temporaryStorage];

            index +=2;
        }

    return numbers;
    }


}
