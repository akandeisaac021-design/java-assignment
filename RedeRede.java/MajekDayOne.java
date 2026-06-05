import java.util.Scanner;

public class MajekDayOne{

    public static void main (String [] args){


        String [] names ={"john", "taiwo", "ene", "ganiu", "victor"};

        for(int index =0; index <5; index++){

            String tempspace =names[names.length-1-index];
            names[names.length-1-index] =names[index];
            names[index] =tempspace;
        }


        String [] newNames =new String [8];


        Scanner scanner =new Scanner(System.in);

        for (int index=0; index <names.length; index++){
            if (index<names.length){newNames[index] =names[index];}
            else {newNames[index] =scanner.nextLine();}
        }

        
        int count =0;


        for(String name :newNames ){
            for (int index =0; index <name.length(); index++){
                count++;   
            }
        }

        char [] letters =new char [count];
        int letterIndex =0;

        for(String name :newNames ){
            for (int index =0; index <name.length(); index++){
                letters[letterIndex] =name.charAt(index);
                letterIndex++;
            }
        }
    }
} 
