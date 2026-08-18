import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    enum VehicleType {
        BIKE,
        CAR,
        TRUCK
    }

    enum SlotType {
        BIKE,
        REGULAR,
        LARGE
    }

    enum DiscountType {
        NONE,
        STUDENT,
        WEEKEND
    }


    public static class Vehicle {
        String numPlate;
        VehicleType type;
        SlotType slotType;
        DiscountType discountType;

        int entryHour;

        Vehicle(String numPlate, VehicleType type, SlotType slotType, DiscountType discountType, int entryHour) {
            this.numPlate = numPlate;
            this.type = type;
            this.slotType = slotType;
            this.discountType = discountType;
            this.entryHour = entryHour;
        }

        int calculateBill(int currentHour, int maxStay) {
            int totalHour = currentHour - entryHour;

            int firstHourFee = switch (slotType) {
                case BIKE -> 10;
                case REGULAR -> 30;
                case LARGE -> 50;
            };

            int furtherHourFee = switch (slotType) {
                case BIKE -> 5;
                case REGULAR -> 20;
                case LARGE -> 40;
            };

            int surcharge = switch (slotType) {
                case BIKE -> 0;
                case REGULAR -> 5;
                case LARGE -> 15;
            };

            int totalFee = firstHourFee + (totalHour - 1)*furtherHourFee + surcharge;

            double discount = switch (discountType) {
                case NONE -> 0;
                case STUDENT -> 0.2 * totalFee;
                case WEEKEND -> 10;
            };

            int bill = (int) Math.round(totalFee - discount);

            if (bill < 0) {
                throw new IllegalArgumentException("Bill can not be less than zero.");
            }

            return bill;
        }
    }

    public static void main(String[] args){

        List<Vehicle> parkedVehicles = new ArrayList<>();

        int maxStay = Integer.MAX_VALUE;
        int refused = 0;
        int currentTime = 0;

        int totalEarned = 0;


        int bikeCap = 0, regCap = 0, largeCap = 0;
        int bikeOcc = 0, regOcc = 0, largeOcc = 0;

        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");

            if (field[0].equals("END")) {
                break;

            } else if (field[0].equals("SLOTS")) {
                bikeCap = Integer.parseInt(field[1]);
                regCap = Integer.parseInt(field[2]);
                largeCap = Integer.parseInt(field[3]);
            }

            else if (field[0].equals("MAXSTAY")) {
                maxStay = Integer.parseInt(field[1]);

            }

            else if (field[0].equals("BIKE") || field[0].equals("CAR") || field[0].equals("REGULAR")) {

                VehicleType vType = VehicleType.valueOf(field[0]);
                String numPlate = field[1];
                DiscountType discountType = DiscountType.valueOf(field[2]);

                SlotType assigned = null;

                if (vType == VehicleType.BIKE) {
                    if (bikeOcc < bikeCap) {
                        assigned = SlotType.BIKE;
                        bikeOcc++;
                    } else if (regOcc < regCap) {
                        assigned = SlotType.REGULAR;
                        regOcc++;

                    } else if (largeOcc < largeCap) {
                        assigned = SlotType.LARGE;
                        largeOcc++;
                    }
                } else if (vType == VehicleType.CAR) {
                    if (regOcc < regCap) {
                        assigned = SlotType.REGULAR;
                        regOcc++;
                    } else if (largeOcc < largeCap) {
                        assigned = SlotType.LARGE;
                        largeOcc++;
                    }
                } else if (vType == VehicleType.TRUCK) {
                    if (largeOcc < largeCap) {
                        assigned = SlotType.LARGE;
                        largeOcc++;
                    }
                }

                if (assigned != null) {
                    parkedVehicles.add(new Vehicle(numPlate, vType, assigned, discountType, currentTime ));
                } else {
                    refused++;
                }

            }


            else if (field[0].equals("COUNT")) {
                System.out.println(parkedVehicles.size());

            } else if (field[0].equals("FREE")) {
                SlotType st = SlotType.valueOf(field[1]);

                if (st==SlotType.BIKE) System.out.println(bikeCap - bikeOcc);
                else if (st == SlotType.REGULAR) {
                    System.out.println(regCap - regOcc);
                } else if (st == SlotType.LARGE) {
                    System.out.println(largeCap - largeOcc);
                }

            } else if (field[0].equals("EARNED")) {
                System.out.println(totalEarned);
            }

            else if (field[0].equals("REFUSED")) {
                System.out.println(refused);
            }

            else if (field[0].equals("BILL")) {
                Vehicle v = findVehicle(parkedVehicles, field[1]);

                System.out.println(v != null ? v.calculateBill(currentTime, maxStay) : 0);
            }

            else if (field[0].equals("SLOT")) {
                Vehicle v = findVehicle(parkedVehicles, field[1]);

                System.out.println(v != null ? v.slotType :SlotType.LARGE);
            }
            else if (field[0].equals("LEAVE")) {
                Vehicle v = findVehicle(parkedVehicles, field[1]);

                parkedVehicles.remove(v);
            }

            else if (field[0].equals("PASSTIME")) {
                int passedHour = Integer.parseInt(field[1]);

                currentTime += passedHour;
            }


        }
    }

    private static Vehicle findVehicle(List<Vehicle> list, String numPlate) {
        for (Vehicle v : list) {
            if (v.numPlate.equals(numPlate))
                return v;
        }
        return null;

    }
}