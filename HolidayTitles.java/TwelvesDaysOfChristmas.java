import java.util.Scanner;


public class TwelvesDaysOfChristmas{
    public static void main (String [] args){

Scanner scanner =new Scanner(System.in);

    String twelveDaysOfChristmas ="""
        Press 1 For The first day of christmas
        Press 2 For The second day of christmas
        Press 3 For The third day of christmas
        Press 4 For The fourth day of christmas
        Press 5 For The fifth day of christmas
        Press 6 For The sixth day of christmas
        Press 7 For The seventh day of christmas
        Press 8 For The eighth day of christmas
        Press 9 For The ninth day of christmas
        Press 10 For The tenth day of christmas
        Press 11 For The eleventh day of christmas
        Press 12 For The twelveth day of christmas
    """;
    System.out.println(twelveDaysOfChristmas);
    int twelveDaysOfChristmasChoice =scanner.nextInt();
    switch(twelveDaysOfChristmasChoice){
        case 1 ->{
            System.out.println("First verse");
            String firstDayOfChristmasVerse ="""
                On the first day of Christmas
                My True love gave to me
                A partridge in a pear tree        
                """;
            System.out.println(firstDayOfChristmasVerse);
        }
        case 2 ->{
            System.out.println("The second day of christmas");
            String secondDayOfChristmas ="""
                On the second day of Christmas
                My True love gave to me
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(secondDayOfChristmas);
        }

        case 3 ->{
            System.out.println("The third day of christmas");
            String thirdDayOfChristmas ="""
                On the third day of Christmas
                My True love gave to me
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(thirdDayOfChristmas);
        }

        case 4 ->{
            System.out.println("The fourth day of christmas");
            String fourthDayOfChristmas ="""
                On the fourth day of Christmas
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree

                """;
            System.out.println(fourthDayOfChristmas);
        }

        case 5 ->{
            System.out.println("The fifth day of christmas");
            String fifthDayOfChristmas =""" 
                On the fifth day of Christmas
                My True love gave to me
                Five golden rings 
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree

                """;
            System.out.println(fifthDayOfChristmas);
        }
            
        case 6 ->{
            System.out.println("The sixth day of christmas");
            String sixthDayofChristmas ="""
                On the sixth day of Christmas
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(sixthDayofChristmas);   

        }

        case 7 ->{
            System.out.println("The seventh day of christmas");
            String seventhDayofChristmas ="""
                On the seventh day of Christmas
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(seventhDayofChristmas);   

        }

        case 8 ->{
            System.out.println("The eighth day of christmas");
            String eighthDayofChristmas ="""
                On the eighth day of Christmas
                Eight maids are milking
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(eighthDayofChristmas);   

        }

        case 9 ->{
            System.out.println("The ninth day of christmas");
            String ninthDayofChristmas ="""
                On the ninth day of Christmas
                Nine ladies dancing
                Eight maids are milking
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(ninthDayofChristmas);   

        }

        case 10 ->{
            System.out.println("The tenth day of christmas");
            String tenthDayofChristmas ="""
                On the tenth day of Christmas
                Ten lords a leaping
                Nine ladies dancing
                Eight maids are milking
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(tenthDayofChristmas);   

        }

        case 11 ->{
            System.out.println("The eleventh day of christmas");
            String eleventhDayofChristmas ="""
                On the eleventh day of Christmas
                Ten lords a leaping
                Nine ladies dancing
                Eight maids are milking
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(eleventhDayofChristmas);   

        }        

        case 12 ->{
            System.out.println("The twelveth day of christmas");
            String twelvethDayofChristmas ="""
                On the twelveth day of Christmas
                Ten lords a leaping
                Nine ladies dancing
                Eight maids are milking
                Seven swans a Swimming
                Six geese a laying
                Five golden rings
                My True love gave to me
                Four calling birds
                Three french hens
                Two turtle doves
                And a partridge in a pear tree
                """;
            System.out.println(twelvethDayofChristmas);   
        
        }

       default->System.out.println("Invalid choice!");



}








}
}
