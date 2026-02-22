public class FirstTenNaturalNumbers{
    public static void main(String []args){

int start =1;
int stop =11;
int product =1;

while (start <stop){
    product *=start;
    start++;
}
System.out.println(product);
    }
}