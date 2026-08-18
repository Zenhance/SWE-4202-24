import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        while (input.hasNextLine()){
            String line = input.nextLine().trim();
            if (line.isEmpty()){
                continue;
            }
            String[] field = line.split("\\s+");
            String command = field[0];
            if (command.equals("END")){
                break;
            }
            if (command.equals("SLOTS")) {
                int bikeSlots = Integer.parseInt(field[1]);
                int regularSlots = Integer.parseInt(field[2]);
                int largeSlots = Integer.parseInt(field[3]);
                parkingLot.setSlots(bikeSlots, regularSlots, largeSlots);
            }
            else if (command.equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                parkingLot.setMaxStay(hours);
            }
            else if (command.equals("BIKE")) {
                Vehicle vehicle = new Bike(field[1], field[2]);
                parkingLot.park(vehicle);
            }
            else if (command.equals("CAR")) {
                Vehicle vehicle = new Car(field[1], field[2]);
                parkingLot.park(vehicle);
            }
            else if (command.equals("TRUCK")) {
                Vehicle vehicle = new Truck(field[1], field[2]);
                parkingLot.park(vehicle);
            }
            else if (command.equals("SLOT")) {
                System.out.println(parkingLot.getSlot(field[1])
                );
            }
            else if (command.equals("FREE")) {
                System.out.println(parkingLot.getFreeSlots(field[1])
                );
            }
            else if (command.equals("COUNT")) {
                System.out.println(parkingLot.getCount());
            }
            else if (command.equals("REFUSED")) {
                System.out.println(parkingLot.getRefused());
            }
            else if (command.equals("BILL")) {
                Integer bill = parkingLot.getBill(field[1]);
                if (bill == null){
                    System.out.println("NONE");
                }else {
                    System.out.println(bill);
                }
            }
            else if (command.equals("LEAVE")) {
                parkingLot.leave(field[1]);
            }
            else if (command.equals("EARNED")) {
                System.out.println(parkingLot.getEarned());
            }
        }
    }
}







