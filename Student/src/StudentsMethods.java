public class StudentsMethods {

    public int calculateAge(int yearOfBirth){
        return 2026 - yearOfBirth;
    }

    public int calculateGPA(int total){
        return total * 5 /100;
    }

    public void registerForCourse(String [] desiredCourses, String [] offeredCourses){

        for (int desiredCoursesCount =0; desiredCoursesCount <desiredCourses.length; desiredCoursesCount++){

            for (int offeredCoursesCount=0; offeredCoursesCount < offeredCourses.length; offeredCoursesCount++) {

                if (desiredCourses[desiredCoursesCount] == offeredCourses[offeredCoursesCount]) {
                    //Call it from dictionary/hashmap and update is attendance by one
                    break;

                }
            }
        }
    }
}
