import java.util.Scanner;

public class PigLatin{

    public static String printLatinWord(String word) {
        return word.substring(1) + word.charAt(0) + "ay";
    }

    public static void printLatin(String sentence) {
        String[] words = sentence.split(" ");

        for (String word : words) {
            System.out.print(printLatinWord(word) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();

        System.out.println("Pig Latin:");
        printLatin(sentence);

    }
}
