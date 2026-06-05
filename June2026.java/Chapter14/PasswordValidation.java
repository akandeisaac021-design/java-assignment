import java.util.Scanner;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean validLength =password.length() >=8 && password.length() <= 15;

        boolean startsWithLetter =Character.isLetter(password.charAt(0));

        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)){
                hasUppercase = true;
            }

            if (Character.isDigit(ch)){
                hasDigit = true;
            }

        }

        if (validLength && startsWithLetter && hasUppercase && hasDigit){
            System.out.println("Valid Password");
        }
        else{
            System.out.println("Invalid Password");
        }
    }
}
