public class PrimeNumberIdentifier{

    public static void main(int number){

        int divisor =2;
        int count =0;

        while (count <=number){
            if (number % count ==0){
                count++;        
            }

        } 
        if (count >1){
            System.out.println(number + "is not a prime number");
        }
        else{
            System.out.println(number + "is a prime number");
        }


    }
 } 
