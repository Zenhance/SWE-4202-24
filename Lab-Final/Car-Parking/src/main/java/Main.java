import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CarPark park = null;

        while (input.hasNextLine()) {

            String line = input.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] field = line.split("\\s+");

            if (field[0].equals("END")) {
                break;
            }

            else if (field[0].equals("SLOTS")) {

                park = new CarPark(Integer.parseInt(field[1]),
                        Integer.parseInt(field[2]),
                        Integer.parseInt(field[3]));
            }

            else if (field[0].equals("MAXSTAY")) {

                int hours = Integer.parseInt(field[1]);
                park.setMaxStay(hours);
            }

            else if (field[0].equals("BIKE")) {

                try {

                    park.addVehicle(
                            new Motorcycle(field[1],
                                    field[2]));

                } catch (NoPlateException |
                         NoSlotException e) {

                    park.addRefusal();
                }
            }

            else if (field[0].equals("CAR")) {

                try {

                    park.addVehicle(
                            new Car(
                                    field[1],
                                    field[2]
                            )
                    );

                } catch (NoPlateException |
                         NoSlotException e) {

                    park.addRefusal();
                }
            }

            else if (field[0].equals("TRUCK")) {

                try {

                    park.addVehicle(
                            new Truck(
                                    field[1],
                                    field[2]
                            )
                    );

                } catch (NoPlateException |
                         NoSlotException e) {

                    park.addRefusal();
                }
            }

            else if (field[0].equals("PASSTIME")) {

                park.passTime(
                        Integer.parseInt(field[1])
                );
            }

            else if (field[0].equals("BILL")) {

                try {
                    System.out.println(park.bill(field[1]));

                } catch (VehicleNotFoundException e) {

                    park.addRefusal();
                    System.out.println("NONE");
                }
            }

            else if (field[0].equals("SLOT")) {

                try {
                    System.out.println(park.slot(field[1]));
                } catch (VehicleNotFoundException e) {

                    park.addRefusal();
                    System.out.println("NONE");
                }
            }

            else if (field[0].equals("LEAVE")) {

                try {
                    park.leave(field[1]);
                } catch (VehicleNotFoundException e) {

                    park.addRefusal();
                }
            }

            else if (field[0].equals("FREE")) {

                System.out.println(park.free(field[1]));
            }

            else if (field[0].equals("COUNT")) {

                System.out.println(park.count());
            }

           else if(field[0].equals("EARNED")){

                System.out.println(park.earned());
            }

            else if (field[0].equals("REFUSED")) {

                System.out.println(park.refused());
            }
        }
    }
}