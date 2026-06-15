package file;

import java.io.*;
import java.util.Scanner;

public class CustomFileReader {


    public static byte[] readDataFrom(String fileLocation) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileLocation);
            byte[] data = fileInputStream.readAllBytes();
            fileInputStream.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readDataFrom(Scanner scanner){
        StringBuilder data = new StringBuilder();
        while(scanner.hasNextLine())
            data.append(scanner.nextLine());
        return data.toString();
    }

    public static void writeDataTo(String fileName, String text){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName,true);
            fileOutputStream.write(text.getBytes());
            System.out.println("Success");
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static byte[] bufferReader(String fileName){

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();

            byte [] result = line.getBytes();
            System.out.println(line);
            bufferedReader.close();
            return result;
//            while((line = bufferedReader.readLine()) != null){
//                result
//                System.out.println(line);
//            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    static void printStream(){
        try{
        String text ="I am Isaac";
        PrintStream printStream =new PrintStream(text);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}