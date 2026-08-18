
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarPark carPark = new CarPark();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");
            String command = field[0];

            if (command.equals("END")) {
                break;
            }

            try {
                switch (command) {
                    case "SLOTS":
                        carPark.initializeSlots(
                                Integer.parseInt(field[1]),
                                Integer.parseInt(field[2]),
                                Integer.parseInt(field[3])
                        );
                        break;

                    case "MAXSTAY":
                        carPark.setMaxStay(Integer.parseInt(field[1]));
                        break;

                    case "BIKE":
                        carPark.processArrival(VehicleType.BIKE, field[1], SchemeType.valueOf(field[2]));
                        break;

                    case "CAR":
                        carPark.processArrival(VehicleType.CAR, field[1], SchemeType.valueOf(field[2]));
                        break;

                    case "TRUCK":

                        carPark.processArrival(VehicleType.TRUCK, field[1], SchemeType.valueOf(field[2]));
                        break;

                    case "PASSTIME":
                        carPark.passTime(Integer.parseInt(field[1]));
                        break;

                    case "LEAVE":
                        carPark.processDeparture(field[1]);
                        break;

                    case "BILL":
                        System.out.println(carPark.getBillEstimateForPlate(field[1]));
                        break;

                    case "SLOT":
                        System.out.println(carPark.getSlotTypeForPlate(field[1]));
                        break;

                    case "FREE":
                        SlotType sType = SlotType.valueOf(field[1]);
                        System.out.println(carPark.getFreeSlotsCount(sType));
                        break;

                    case "COUNT":
                        System.out.println(carPark.getActiveVehiclesCount());
                        break;

                    case "EARNED":
                        System.out.println(carPark.getRunningTotalEarned());
                        break;

                    case "REFUSED":
                        System.out.println(carPark.getRefusalCount());
                        break;

                    default:
                        break;
                }
            } catch (ParkingRefusalException e) {

                carPark.incrementRefusal();
            }
        }
        input.close();
    }
}



