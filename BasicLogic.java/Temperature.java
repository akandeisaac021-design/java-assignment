import java.util.Scanner;
public class Temperature{
public static void main(String [] args){
System.out.println("Enter the temperature in kelvin: ");
Scanner input = new Scanner(System.in);
double temperature = input.nextDouble();
System.out.println("Temperature in celsius: ");
double celsiustemp = 273.15 + temperature;
System.out.println(celsiustemp);
System.out.println("Temperature in farenheit: ");
double farenheittemp = celsiustemp * 9/5 +32;
System.out.println(farenheittemp);
}
}
