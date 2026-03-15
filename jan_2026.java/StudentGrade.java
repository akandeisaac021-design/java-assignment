import java.util.Scanner;
import java.util.ArrayList;

public class StudentGrade {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentTotals = new ArrayList<>();
        ArrayList<Integer> subjectsPerStudent = new ArrayList<>();
        ArrayList<Double> studentAverages = new ArrayList<>();
        ArrayList<String> subjectNames = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade System ===");

        System.out.print("Enter number of students: ");
        int totalStudents = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int totalSubjects = scanner.nextInt();
        scanner.nextLine();

        for (int subjectIndex =0; subjectIndex < totalSubjects; subjectIndex++) {
            System.out.print("Enter subject name: ");
            subjectNames.add(scanner.nextLine());
        }

        for (int studentIndex = 1; studentIndex <= totalStudents; studentIndex++) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            studentNames.add(studentName);

            System.out.print("Enter number of subjects offered: ");
            int subjectsOffered = scanner.nextInt();
            subjectsPerStudent.add(subjectsOffered);

            int totalScore = 0;

            for (int subjectIndex = 1; subjectIndex <= subjectsOffered; subjectIndex++) {
                System.out.print("Enter score for subject " + subjectIndex + ": ");
                int subjectScore = scanner.nextInt();

                while (subjectScore < 0) {
                    System.out.println("Invalid score. Please re-enter: ");
                    subjectScore = scanner.nextInt();
                }

                totalScore += subjectScore;
            }

            double averageScore = (double) totalScore / subjectsOffered;
            studentTotals.add(totalScore);
            studentAverages.add(averageScore);

            scanner.nextLine();
        }

        System.out.println("===================================================================");
        System.out.print("Student Name\t");

        for (String subject : subjectNames) {
            System.out.print(subject + "\t");
        }

        System.out.println("Total\tAverage");

        for (int studentIndex =0; studentIndex <totalStudents; studentIndex++) {
            System.out.print(studentNames.get(studentIndex) + "\t");
 
            System.out.print(studentTotals.get(studentIndex) + "\t");
            System.out.println(studentAverages.get(studentIndex));
        }

    }
}
