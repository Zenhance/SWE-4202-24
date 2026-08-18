import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = null;
        Bike bike = null;
        Car car = null;
        Truck truck = null;
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            } else if (field[0].equals("SLOTS")) {
                parkingLot = new ParkingLot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                parkingLot.setMaxHours(hours);
            } else if (field[0].equals("BIKE")) {
                try {
                    if (field.length == 1 || field.length == 2) {
                        throw new IllegalArgumentException("No numberPlate");
                    }

                    String plate = field[1];
                    String discount =  field[2];
                    bike = new Bike(plate, discount);
                    parkingLot.addVehicle(bike);
                } catch (IllegalArgumentException e) {
                    parkingLot.refused++;
                }
            }else if (field[0].equals("CAR")) {
                try {
                    if (field.length == 1 || field.length == 2) {
                        throw new IllegalArgumentException("No numberPlate");
                    }

                    String plate = field[1];
                    String discount =  field[2];
                    car = new Car(plate, discount);
                    parkingLot.addVehicle(car);
                } catch (IllegalArgumentException e) {
                    parkingLot.refused++;
                }
            }else if (field[0].equals("TRUCK")) {
                try {
                    if (field.length == 1 || field.length == 2) {
                        throw new IllegalArgumentException("No numberPlate");
                    }

                    String plate = field[1];
                    String discount =  field[2];
                    truck = new Truck(plate, discount);
                    parkingLot.addVehicle(truck);
                } catch (IllegalArgumentException e) {
                    parkingLot.refused++;
                }
            }else if (field[0].equals("PASSTIME")) {
                int hours = Integer.parseInt(field[1]);
            }else if (field[0].equals("LEAVE")) {
                String plate = field[1];

            }else if (field[0].equals("BILL")) {

            }else if (field[0].equals("SLOT")) {

            }else if (field[0].equals("FREE")) {
                String slot = field[1];
                if(slot.equals("BIKE")) {
                    System.out.println(parkingLot.bikeCapacity);
                }else if (slot.equals("REGULAR")) {
                    System.out.println(parkingLot.regularCapacity);
                }else if (slot.equals("LARGE")) {
                    System.out.println(parkingLot.largeCapacity);
                }

            }else if (field[0].equals("COUNT")) {
                System.out.println(parkingLot.count);

            }else if (field[0].equals("EARNED")) {
                System.out.println(parkingLot.earned);
            }else if (field[0].equals("REFUSED")) {
                System.out.println(parkingLot.refused);
            }

        }
    }
}