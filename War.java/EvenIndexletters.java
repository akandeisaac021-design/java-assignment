public class EvenIndexletters{

    public static String findMyEvenIndexLetters(String name){
            String newWord ="";
            String userInput =name;
            int length =userInput.length();

        for(int index=1; index <length; index +=2){
            newWord +=userInput.charAt(index);
            
        }
        System.out.print(newWord);

        return newWord;
    

    }


}
