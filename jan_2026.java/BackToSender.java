import java.util.Scanner;

public class BackToSender{
    public static void main(String[] args){

Scanner scanner =new Scanner(System.in);

int basePay =5000;
int amountPerParcel =0;
int counter =0;

while (counter <500){
    System.out.print("Enter your successful deliveries: ");
    int successfulDeliveries =scanner.nextInt();
    while (successfulDeliveries <0 || successfulDeliveries >100){
        System.out.print("Re-enter a valid number: ");
        successfulDeliveries =scanner.nextInt();
    }

    if(successfulDeliveries < 50){
        amountPerParcel =160;
    }

    else if(successfulDeliveries >=50 && successfulDeliveries <=59){
        amountPerParcel =200;
    }

    else if(successfulDeliveries >=60 && successfulDeliveries <=69){
        amountPerParcel =250;
    }

    else if(successfulDeliveries >=70){
        amountPerParcel =500;
    }

    int daysWage =successfulDeliveries * amountPerParcel + basePay;
    System.out.printf("Today's wage is : %s \n", daysWage);


    String reRun ="""
    Do you wish to contine ?
            Press 1 To Continue
            Press 2 To End
    """;
    System.out.print(reRun);
    int reRunOption =scanner.nextInt();

    while (reRunOption <1 || reRunOption >2){
        System.out.print("Re-enter a valid value: "); 
        reRunOption =scanner.nextInt();
    }
        if(reRunOption ==1){
            System.out.println("Back To Sender");    }
        else if(reRunOption ==2){
            break;}    
        
}



    }
}
