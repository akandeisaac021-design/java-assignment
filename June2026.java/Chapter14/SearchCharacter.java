import java.util.Scanner;

public class SearchCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter character to search: ");
        char character = scanner.next().charAt(0);

        int index = text.indexOf(character);

        if (index >= 0){
            System.out.println("First occurrence at index: " + index);
        }
        else{
            System.out.println("Character not found.");
        }
    }
}
