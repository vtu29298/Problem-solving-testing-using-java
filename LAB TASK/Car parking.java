class ParkingSystem {
    int big;
    int medium;
    int small;

    ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } 
        else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } 
        else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingSystem parking = new ParkingSystem(1, 1, 0);

        System.out.println(parking.addCar(1));
        System.out.println(parking.addCar(2));
        System.out.println(parking.addCar(3));
        System.out.println(parking.addCar(1));
    }
}