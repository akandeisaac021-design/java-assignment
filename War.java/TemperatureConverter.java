//Collects a degree in celsius and 

public class TemperatureConverter{

    public static double celsiusToFarenheit(int celcius){

        double Farenheit=0;

        int celciusStart =0;

        int celsiusStop =celcius;

        System.out.println("celcius----->Farenheit");

        while (celciusStart <=celsiusStop){

            Farenheit =celciusStart * 9/5 +32;

            System.out.println(celciusStart + "-------->" +Farenheit);

            celciusStart +=2;
        }

        return Farenheit;
    }

}
