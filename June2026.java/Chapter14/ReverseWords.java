import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        for (int index= words.length - 1; index >= 0; index--) {
            System.out.print(words[index] + " ");
        }

        scanner.close();
    }
}
