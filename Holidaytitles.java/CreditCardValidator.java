import java.util.Scanner;
import java.util.Arrays;

public class CreditCardValidator{
    public static void main (String [] args){

Scanner scanner =new Scanner(System.in);
int module =10;
int position =2;
int counter  =1;
int evenOrOdd = position % 2;
int addEven =0;
int addOdd =0;

System.out.print("Enter your Credit card number: ");
    String creditCardNumber =scanner.nextLine();
    int length =creditCardNumber.length();    

while (length < 13 || length > 16){
    System.out.print("Invalid renter your Credit card number: ");
    creditCardNumber =scanner.nextLine();
    int newLength =creditCardNumber.length();
    length =newLength;
}

long cardNumber =Long.parseLong(creditCardNumber);
int method =(int)(cardNumber % module);


if (length ==13 ){
    while (position <=13){
        int digit =method / counter;

    if (evenOrOdd ==0){
        int doubleEven =digit * 2;      
        if (doubleEven >9){
            int singleEvenDigit = doubleEven % 10 + (doubleEven % 10) / 10;                        
            addEven +=singleEvenDigit;}
        else if (doubleEven <=9){ 
            addEven +=digit;}

    }

    

    else if (evenOrOdd ==1){
        int doubleOdd =digit * 2 ;
        if (doubleOdd >9){
            int singleOddDigit = doubleOdd % 10 + (doubleOdd % 10) / 10;
            addOdd +=singleOddDigit;}
        else if (doubleOdd <=9){ 
            addOdd +=digit;}

    }

     
        position +=1;
        counter *=10;
    }         
}


else if(length == 14){
    while (position <=14){
        int digit =method / counter;
        
        if (evenOrOdd ==0){
            int doubleEven =digit * 2;      
            if (doubleEven >9){
                int singleEvenDigit = doubleEven % 10 + (doubleEven % 10) / 10;                       
                addEven +=singleEvenDigit;}
            else if (doubleEven <=9){ 
                addEven +=digit;}

        }

        else if (evenOrOdd ==1){
            int  doubleOdd =digit * 2;
            if (doubleOdd >9){
                int singleOddDigit = doubleOdd % 10 + (doubleOdd % 10) / 10;
                addOdd +=singleOddDigit;}
            else if (doubleOdd <=9){ 
                addOdd +=digit;}

        }
         
            position +=1;
            counter *=10;
    }         
}

else if(length == 15){
    while (position <=15){
        int digit =method / counter;
        
    if (evenOrOdd ==0){
        int doubleEven =digit * 2 ;      
        if (doubleEven >9){
            int singleEvenDigit = doubleEven % 10 + (doubleEven % 10) / 10;                         
            addEven +=singleEvenDigit;}
        else if (doubleEven <=9){ 
            addEven +=digit;}

    }
    
    else if (evenOrOdd ==1){
        int doubleOdd =digit * 2 ;
        if (doubleOdd >9){
            int singleOddDigit = doubleOdd % 10 + (doubleOdd % 10) / 10;
            addOdd +=singleOddDigit;}
        else if (doubleOdd <=9){ 
            addOdd +=digit;}

    }

        
        position +=1;
        counter *=10;
         
    }
}

else if(length == 16){
    while (position <=16){
        int digit =method / counter;

    if (evenOrOdd ==0){
        int doubleEven =digit * 2;      
        if (doubleEven >9){
            int singleEvenDigit = doubleEven % 10 + (doubleEven % 10) / 10;                        
            addEven +=singleEvenDigit;}
        else if (doubleEven <=9){ 
            addEven +=digit;}

    }

    

    else if (evenOrOdd ==1){
        int  doubleOdd =digit * 2;
        if (doubleOdd >9){
            int singleOddDigit = doubleOdd % 10 + (doubleOdd % 10) / 10;
            addOdd +=singleOddDigit;}
        else if (doubleOdd <=9){ 
            addOdd +=digit;}

    }

     
        position +=1;
        counter *=10;
         
    }
}


int total =addOdd + addEven;


if (total % 10 ==0){
    String cardValidity ="Valid";
    System.out.print("Valid");}

else if (total % 10 !=0){
    String cardValidity ="Invalid";
    System.out.print("Invalid");}





String[] validitys = new String [10];





    }

}
