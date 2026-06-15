public class ChapterFourteenContinued{

    public static int LastIndex(String text, char target){

        for (int index =text.length()-1; index >-1; index--){if (text.charAt(index) ==target){return index;}}

        return -1;

    }

     public static void wordsEndingED (String sentence) {
            String[] words = sentence.split(" ");

            for (String word : words) {
                if (word.matches(".*ED")) { System.out.println(word); }
            }
        }

    public static void capitalWords(String sentence){

        String [] words =sentence.split(" ");

        for (String word : words ){if (word.matches("[A-Z].*")){System.out.println(word);}}



    }

}
