public class Mean{

    public static double meanMethod(int[] numbers){
        int indexCounter =0;
        int sumOfNumbers =0;
        double mean =0.00;


        while (indexCounter <=numbers.length){
            sumOfNumbers +=numbers[indexCounter];
            indexCounter++;
        }

        mean =sumOfNumbers /numbers.length;

        return mean;
    }
}

