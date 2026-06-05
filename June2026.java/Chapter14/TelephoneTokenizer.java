import java.util.Scanner;

public class TelephoneTokenizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number ((555) 555-5555): ");
        String phone = scanner.nextLine();

        String areaCode = phone.substring(1, 4);
        String firstThree = phone.substring(6, 9);
        String lastFour = phone.substring(10);

        String fullNumber = areaCode + firstThree + lastFour;

        System.out.println("Area Code: " + areaCode);
        System.out.println("Number: " + fullNumber);
    }
}
