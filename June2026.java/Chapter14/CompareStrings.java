import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First string: ");
        String str1 = scanner.nextLine();

        System.out.print("Second string: ");
        String str2 = scanner.nextLine();

        System.out.print("Starting index: ");
        int start = scanner.nextInt();

        System.out.print("Number of characters: ");
        int length = scanner.nextInt();

        boolean equal = str1.regionMatches(
                true, start,
                str2, start,
                length);

        if (equal)
            System.out.println("Compared portions are equal.");
        else
            System.out.println("Compared portions are not equal.");

        scanner.close();
    }
}
