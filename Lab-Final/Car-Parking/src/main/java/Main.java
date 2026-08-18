import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingSlot parkingLot = null;
        Bike bike = null;
        Car car = null;
        Truck truck = null;
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            ParkingSlot SLOT =new ParkingSlot(1,2,3);
            System.out.println("BIKE"+" /n"+"REGULAR" +"/n"+
                    "LARGE");
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("SLOTS")) {
                parkingLot = new ParkingSlot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
//                parkingLot.setMaxHours(hours);
            } else if (field[0].equals("BIKE")) {
                String plate = field[1];
                String discount =  field[2];
                bike = new Bike(plate, discount);
//                parkingLot.addVehicle(bike);
            }else if (field[0].equals("CAR")) {
                String plate = field[1];
                String discount =  field[2];
                car = new Car(plate, discount);
//                parkingLot.addVehicle(car);
            }else if (field[0].equals("TRUCK")) {
                String plate = field[1];
                String discount =  field[2];
                truck = new Truck(plate, discount);
//                parkingLot.addVehicle(truck);
            }else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
            }else if (field[0].equals("LEAVE")) {
                String plate = field[1];


            }else if (field[0].equals("COUNT")) {
                assert parkingLot != null;
                System.out.println(parkingLot != null ? parkingLot.getCount() : 0);


            }

        }
    }
}