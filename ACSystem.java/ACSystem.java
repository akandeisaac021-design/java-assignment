public class ACSystem{

    public static int putOnTheAC(int aCStatus){

        if (aCStatus ==0){
            return aCStatus +=1;

        }
            return -1;
    }


    public static int putOffTheAC(int aCStatus){
        
        if (aCStatus ==1){
            return aCStatus-=1;

        }
        return -1;
    }

    public static int decreaseTheaCTemperature(int aCStatus, int aCTemperature){

        if (aCStatus ==1){
            if (aCTemperature >16){

                return aCTemperature -1;
            }
        }
        return -1;
    }


    public static int IncreaseTheaCTemperature(int aCStatus, int aCTemperature){
    
        if (aCStatus ==1){
            if (aCTemperature <31){

                return aCTemperature + 1;
            }
        }
        return -1;
    }

    public static int DecreaseACToMinimumTemperature(int aCStatus, int aCTemperature){

        if (aCStatus ==1){

            if (aCTemperature >16){

                return aCTemperature - (aCTemperature - 16);
            

            }
        }
        return -1;

    }

    public static int IncreaseACToMaximumTemperature(int aCStatus, int aCTemperature){

        if (aCStatus ==1){

            if (aCTemperature <31){

                return aCTemperature + (31 - aCTemperature);               
            }
        }

    return -1;
    }

}
