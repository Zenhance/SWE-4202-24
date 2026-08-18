import exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;
            }
            ArrayList<Slot> slots = new ArrayList<>();
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            switch (field[0]) {
                case "SLOTS" -> {
                    int bike = Integer.parseInt(field[1]);
                    int regular = Integer.parseInt(field[2]);
                    int large = Integer.parseInt(field[3]);
                    createSlots(slots, bike, regular, large);
                }
                case "MAXSTAY" -> {
                    int hours = Integer.parseInt(field[1]);
                    Vehicle.setMaxTimeStay(hours);
                }
                case "BIKE" -> {
                    for (int i = 0; i < slots.size(); i++) {
                        if (slots.get(i).isFree()) {
                            slots.get(i).equiped();
                            try {
                                vehicles.add(new Motorcycle(field[1], field[2]));
                                vehicles.get(vehicles.size()-1).park();
                                vehicles.get(vehicles.size()-1).setSlotType(slots.get(i));
                            }
                            catch (NullPointerException | NoPlateException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                case "CAR" -> {
                    for (int i = 0; i < slots.size(); i++) {
                        if (!(slots.get(i) instanceof BikeSlot) && slots.get(i).isFree()) {
                            slots.get(i).equiped();
                            try {
                                vehicles.add(new Car(field[1], field[2]));
                                vehicles.get(vehicles.size()-1).park();
                                vehicles.get(vehicles.size()-1).setSlotType(slots.get(i));
                            }
                            catch (NullPointerException | NoPlateException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                case "TRUCK" -> {
                    for (int i = 0; i < slots.size(); i++) {
                        if (slots.get(i) instanceof LargeSlot && slots.get(i).isFree()) {
                            slots.get(i).equiped();
                            try {
                                vehicles.add(new Truck(field[1], field[2]));
                                vehicles.get(vehicles.size()-1).park();
                                vehicles.get(vehicles.size()-1).setSlotType(slots.get(i));
                            }
                            catch (NullPointerException | NoPlateException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                case "COUNT" -> {
                    System.out.println(vehicles.size());
                }
                case "PASSTIME" -> {
                    for (Vehicle v : vehicles) {
                        v.timePassed(Integer.parseInt(field[1]));
                    }
                }
                case "LEAVE" -> {
                    try {
                        int leavingCarIndex = isVehicleInPark(vehicles, field[2]);
                        vehicles.remove(leavingCarIndex);

                    } catch (UnknownPlateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "BILL" -> {
                    try {
                        int billingCarIndex = isVehicleInPark(vehicles, field[2]);
                        int bill = vehicles.get(billingCarIndex).getSlotType().totalCharge();
                        System.out.println(bill);
                    } catch (UnknownPlateException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case "SLOT" -> {

                }
            }
        }
    }

    public static void createSlots(ArrayList<Slot> list, int bike, int regular, int large) {
        for (int i = 0; i < bike; i++) {
            list.add(new BikeSlot());
        }
        for (int i = 0; i < regular; i++) {
            list.add(new RegularSlot());
        }
        for (int i = 0; i < large; i++) {
            list.add(new LargeSlot());
        }
    }

    public static int isVehicleInPark(ArrayList<Vehicle> vehicles, String plate) throws UnknownPlateException {
        boolean vehicleInPark = false;
        int vehicleIndex = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPlate().equals(plate)) {
                vehicleInPark = true;
                vehicleIndex = i;
                break;
            }
        }
        if (!vehicleInPark)
            throw new UnknownPlateException("Plate is not in the park");
        return vehicleIndex;
    }


}