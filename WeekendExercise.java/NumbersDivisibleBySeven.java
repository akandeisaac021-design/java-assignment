public class NumbersDivisibleBySeven{
    public static void main(String []args){

int start =1;
int stop =101;
int divisible =0;

while (start <stop){
    if (start %7 ==0){
        divisible +=1;
        // System.out.println(start);
    }
start++;
}
System.out.println(divisible);











    }
    
}
