import java.util.ArrayList;

public class FireDrill {

    static void main(String[] args){

        ArrayList productInfo = new ArrayList();

        int sum =0;

        productInfo.add("Benz");
        productInfo.add("Lamborghini");
        productInfo.add("Buggati");


        productInfo.add("500");
        productInfo.add("700");
        productInfo.add("1000");

        for(int index =0; index <productInfo.size(); index++){

           String listElement =String.valueOf(productInfo.get(index));
           char firstChar=listElement.charAt(0);

            if(Character.isDigit(firstChar) ){
                sum +=Integer.parseInt(listElement);

            }else if (!listElement.equals("0")){
                System.out.println(productInfo.get(index));
            }

        }
        System.out.println(sum);

    }


}
