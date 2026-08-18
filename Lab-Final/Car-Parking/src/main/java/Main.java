import java.util.Scanner;

import Parking.CarPark;
import Slot.Slot;
import Slot.SlotType;
import Slot.DiscountScheme;

import Vehicle.Vehicle;
import Vehicle.Motorcycle;
import Vehicle.Car;
import Vehicle.Truck;

import Exception.NoPlateException;
import Exception.NoSlotException;
import Exception.UnknownPlateException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Slot> slots = new ArrayList<>();

        String[] slotCommand = scanner.nextLine().split(" ");

        int bikeSlots = Integer.parseInt(slotCommand[1]);
        int regularSlots = Integer.parseInt(slotCommand[2]);
        int largeSlots = Integer.parseInt(slotCommand[3]);

        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new Slot(SlotType.BIKE));
        }

        for (int i = 0; i < regularSlots; i++) {
            slots.add(new Slot(SlotType.REGULAR));
        }

        for (int i = 0; i < largeSlots; i++) {
            slots.add(new Slot(SlotType.LARGE));
        }

        String maxStayCommand = scanner.nextLine().trim();
        int maxStay = Integer.parseInt(maxStayCommand.split(" ")[1]);

        CarPark carPark = new CarPark(slots, maxStay);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(" ");

            String command = parts[0];

            try {

                if (command.equals("BIKE")) {

                    String plate = parts[1];
                    DiscountScheme scheme =
                            DiscountScheme.valueOf(parts[2]);

                    Vehicle vehicle =
                            new Motorcycle(plate, scheme);

                    carPark.parkVehicle(vehicle);

                }

                else if (command.equals("CAR")) {

                    String plate = parts[1];
                    DiscountScheme scheme =
                            DiscountScheme.valueOf(parts[2]);

                    Vehicle vehicle =
                            new Car(plate, scheme);

                    carPark.parkVehicle(vehicle);

                }

                else if (command.equals("TRUCK")) {

                    String plate = parts[1];
                    DiscountScheme scheme =
                            DiscountScheme.valueOf(parts[2]);

                    Vehicle vehicle =
                            new Truck(plate, scheme);

                    carPark.parkVehicle(vehicle);

                }

                else if (command.equals("SLOT")) {

                    String plate = parts[1];

                    System.out.println(
                            carPark.getSlotType(plate)
                    );
                }

                else if (command.equals("FREE")) {

                    SlotType type =
                            SlotType.valueOf(parts[1]);

                    System.out.println(
                            carPark.getFreeSlots(type)
                    );
                }

                else if (command.equals("COUNT")) {

                    System.out.println(
                            carPark.getVehicleCount()
                    );
                }

                else if (command.equals("REFUSED")) {

                    System.out.println(
                            carPark.getRefused()
                    );
                }

                else if (command.equals("BILL")) {

                    String plate = parts[1];

                    System.out.println(
                            carPark.getBill(plate)
                    );
                }

                else if (command.equals("PASSTIME")) {

                    int hours =
                            Integer.parseInt(parts[1]);

                    carPark.passTime(hours);
                }

                else if (command.equals("LEAVE")) {

                    String plate = parts[1];

                    System.out.println(
                            carPark.leaveVehicle(plate)
                    );
                }

                else if (command.equals("EARNED")) {

                    System.out.println(
                            carPark.getEarned()
                    );
                }

                else if (command.equals("END")) {

                    break;
                }

            } catch (NoPlateException
                     | NoSlotException
                     | UnknownPlateException e) {

                carPark.incrementRefused();
            }
        }

        scanner.close();
    }
}