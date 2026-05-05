public class BikeSystem{

    public static int turnOnBike(int bikeStatus){

        if (bikeStatus ==0){
            bikeStatus =1;
        }

        return bikeStatus;
    }

    
    public static int turnOffBike(int bikeStatus){

        if (bikeStatus ==1){
            bikeStatus =0;
        }

        return bikeStatus;
    }

    public static int accelerate(int bikeStatus, int currentSpeed){

        if (bikeStatus ==1){
            return currentSpeed + identifyCurrentGearSpeed(bikeStatus, currentSpeed);
        }
        return -1;
    }
    

    public static int deccelerate(int bikeStatus, int currentSpeed){

        if (bikeStatus ==1){

            if (currentSpeed >0) return currentSpeed - identifyCurrentGearSpeed(bikeStatus, currentSpeed);
        }
        return -1;
    }
    

    public static int identifyCurrentGearSpeed(int bikeStatus, int currentSpeed) {

        if (bikeStatus == 1) {
            if (currentSpeed >0 && currentSpeed <= 20) return 1;
            if (currentSpeed >= 21 && currentSpeed <= 30) return 2;
            if (currentSpeed >= 31 && currentSpeed <= 40) return 3;
            if (currentSpeed >= 41) return 4;
        }
        return -1;
    }
}
