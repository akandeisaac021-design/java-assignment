import java.util.Scanner;

public class StudentsMethods {

    short age;
    
    public void calculateAge(int yearOfBirth){
        age = 2026 - yearOfBirth;
    }

    public void calculateGPA(int total){
        double gpa =total * 5 /100;
    }

    public void registerForCourse( String [] offeredCourses, int amountOfDesiredCourses){

        String [] desiredCourses = new String [amountOfDesiredCourses];

        for (int desiredCoursesCount =0; desiredCoursesCount <amountOfDesiredCourses; desiredCoursesCount++){

            System.out.print("Enter course name ==> ");

            Scanner scanner =new Scanner(System.in);
            String courseName =scanner.nextLine();

            for (int offeredCoursesCount=0; offeredCoursesCount < offeredCourses.length; offeredCoursesCount++) {

                if (courseName.equals(offeredCourses[offeredCoursesCount])) {
                    //Call it from dictionary/hashmap and update is attendance by one
                    desiredCourses[desiredCoursesCount] =courseName;
                    break;

                }
            }
        }
    }
}
