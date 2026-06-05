import java.util.ArrayList;
import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> strings = new ArrayList<>();

        int withSpecial = 0;
        int withoutSpecial = 0;



        while (true) {
            System.out.println("Enter \"stop\" to end :");
            String str = scanner.nextLine();

            if (str.equals("stop")){
                break;
            }

            strings.add(str);

            if (str.matches(".*[^a-zA-Z0-9 ].*")){
                withSpecial++;
            }
            else{
                withoutSpecial++;
            }

        }

        System.out.println("\nStrings:");

        for (String s : strings) {
            if (s.length() > 0) {
                String formatted =
                        Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();

                System.out.println(formatted);
            }
        }

        System.out.println("\nWith special characters: " + withSpecial);
        System.out.println("Without special characters: " + withoutSpecial);
    }
}
