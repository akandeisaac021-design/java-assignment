import java.util.Scanner;
import java.util.ArrayList;

public class StudentGrade{
    public static void main(String[] args){

ArrayList<Integer> studentsScores =new ArrayList<>();
ArrayList<String> studentsNames =new ArrayList<>();
ArrayList<Integer> storeStudentTotal =new ArrayList<>();
ArrayList<Integer> storeNumberOfSubjectsOffered =new ArrayList<>();
ArrayList<Double> storeAverage =new ArrayList<>();
ArrayList<String> subjectNames =new ArrayList<>();

Scanner scanner =new Scanner(System.in);

int studentsScore;

System.out.println("Student Grade System: ");

System.out.println("Enter number of Students: ");
int numberOfStudents =scanner.nextInt();

System.out.println("Enter number of subjects: ");
int numberOfSubjects =scanner.nextInt();
scanner.nextLine();

int subjectCounter=0;

while (subjectCounter <numberOfSubjects){
    System.out.println("Enter the subject names: ");
    String subjectName =scanner.nextLine();
    subjectCounter++;
    subjectNames.add(subjectName);
    
}



for(int studentCounter =1; studentCounter <=numberOfStudents; studentCounter++){
    System.out.print("Enter Student's name: ");
    String studentsName =scanner.nextLine();
    scanner.nextLine();
    studentsNames.add(studentsName);
    

    System.out.print("Enter amount of subjects offered: ");
    int amountOfSubjectsOffered =scanner.nextInt(); 
    storeNumberOfSubjectsOffered.add(amountOfSubjectsOffered);
    
    
    for(int subjectScoreCounter =1;  subjectScoreCounter <=amountOfSubjectsOffered; subjectCounter++){
        System.out.print("Enter Score for subject" + subjectScoreCounter + ": ");
        studentsScore =scanner.nextInt();
        subjectScoreCounter++;


        while(studentsScore <0 ){
            System.out.println("Invalid Score");
            System.out.println("Please re-enter Students Score: ");
            studentsScore =scanner.nextInt();
        }    
        studentsScores.add(studentsScore);
        
        int studentTotal =0;
        studentTotal +=studentsScore;
        storeStudentTotal.add(studentTotal);
        double averageScore =(double)(studentTotal / amountOfSubjectsOffered);
        
        storeAverage.add(averageScore);

    }




}




System.out.println("=======================================================================================================================");
String tableFormatLineOne ="Student Name---------------------";
while (subjectCounter <numberOfSubjects){
    tableFormatLineOne =subjectNames.get(subjectCounter) + "--------------------";
    subjectCounter++;
}



System.out.println(tableFormatLineOne);



























    }
}
