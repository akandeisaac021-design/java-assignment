import java.util.ArrayList;
import java.util.Random;

public class FireDrill2 {

    static void main(String[] args) {

        ArrayList numbers =new ArrayList();
        ArrayList wholeNumbers =new ArrayList();
        ArrayList decimalNumbers =new ArrayList();

        Random random =new Random();

        for (int index= 0; index <5; index++){
            numbers.add(random.nextInt(0, 10));
//            numbers.add(random.nextFloat(0, 1).%2F);
        }

        for (int index =0; index <numbers.size(); index++){

            int element = Integer.parseInt(String.valueOf(numbers.get(1)));

            if (element % 2 == 0) {
                wholeNumbers.add(element);

            }else{
                decimalNumbers.add(element);
            }
        }
    }
}