public class Variance{

    public static double varianceMethod(int[] numbers, int mean){
        int indexCounter =0;
        int sumOfSquares =0;
        int length =numbers.length;
        int sumOfDeviationsSquared =0;

        while (indexCounter <=length){
            int deviations =(numbers[indexCounter] - mean);

            int deviatonSquared =(numbers[indexCounter] - mean) * (numbers[indexCounter] - mean);

            sumOfDeviationsSquared +=deviatonSquared;

            indexCounter +=1;
        }

        double variance =(sumOfSquares /length);

        return variance;
    }   
}
