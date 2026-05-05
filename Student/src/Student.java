import java.util.Scanner;

public class Student{

    public static void main(String [] args){

        Scanner scanner =new Scanner(System.in);

        System.out.print("Enter your name ==> ");
        String name =scanner.nextLine().toUpperCase();

        System.out.print("Enter Your of Birth ==> ");
        int yearOfBirth =scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter Current Class ==> ");
        String currentClass =scanner.nextLine().toUpperCase();

        System.out.println("Enter your Home-Address ==> ");
        String homeAddress =scanner.nextLine().toLowerCase();

        System.out.println("Enter Your Phone Number ==> ");
        String phoneNumber =scanner.nextLine();

        int total =67;

        StudentsMethods studentinfo =new StudentsMethods();

        System.out.println("You are " + studentinfo.calculateAge(yearOfBirth) + "Years old");

        System.out.println("You have a g.p.a of " + studentinfo.calculateGPA(total));



    }
}