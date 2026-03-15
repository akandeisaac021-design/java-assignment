public class VowelsAndConsonant{

    public static int vowelsCounter(String name){
        
        name =name.toUpperCase();

        String vowels ="AEIOU";

        int vowelCount =0;

        for(int index =0; index <name.length(); index++){

            for(int vowelsIndex =0; vowelsIndex <vowels.length(); vowelsIndex++){

                if (name.charAt(index) ==vowels.charAt(index)){
                    vowelCount++;
                    break;
                }
 
            }
        }
            return vowelCount;
    }


   public static int consonantCounter(String name){
        
        name =name.toUpperCase();

        String consonant ="AEIOU";

        int consonantCount =0;

        for(int index =0; index <name.length(); index++){

            for(int consonantIndex =0; consonantIndex <consonant.length(); consonantIndex++){

                if (name.charAt(index) !=consonant.charAt(index)){
                    consonantCount++;
                    break;
                }
 
            }
        }
            return consonantCount;
    }



}
