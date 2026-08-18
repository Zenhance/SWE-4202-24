import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int maxBikeSlots = 0;
    private static int maxRegularSlots = 0;
    private static int maxLargeSlots = 0;

    private static final List<Slot> activeSlots = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String command = scanner.next();

            switch (command) {
                case "SLOTS" -> {
                    maxBikeSlots = scanner.nextInt();
                    maxRegularSlots = scanner.nextInt();
                    maxLargeSlots = scanner.nextInt();
                }
                case "MAXSTAY" -> {
                    int hours = scanner.nextInt();
                    Slot.setMaxStay(hours);
                }
                case "BIKE" -> admitVehicle("BIKE", scanner.next(), scanner.next());
                case "CAR" -> admitVehicle("CAR", scanner.next(), scanner.next());
                case "TRUCK" -> admitVehicle("TRUCK", scanner.next(), scanner.next());
                case "PASSTIME" -> passTime(scanner.nextInt());
                case "LEAVE" -> leave(scanner.next());
                case "BILL" -> printBill(scanner.next());
                case "SLOT" -> printSlotKind(scanner.next());
                case "FREE" -> printFreeSlots(scanner.next());
                case "COUNT" -> System.out.println(activeSlots.size());
                case "EARNED" -> System.out.println(Slot.getTotalEarned());
                case "REFUSED" -> System.out.println(Slot.getTotalDeclined());
                case "END" -> {
                    return;
                }
            }
        }
    }

    private static void admitVehicle(String vehicleType, String plate, String scheme) {

        if ("-".equals(plate)) {
            Slot.incrementDeclined();
            return;
        }

        int occupiedBike = 0;
        int occupiedRegular = 0;
        int occupiedLarge = 0;

        for (Slot s : activeSlots) {
            if (s instanceof Bike) occupiedBike++;
            else if (s instanceof Regular) occupiedRegular++;
            else if (s instanceof Large) occupiedLarge++;
        }

        Slot allocatedSlot = null;

        if ("BIKE".equals(vehicleType)) {
            if (occupiedBike < maxBikeSlots) {
                allocatedSlot = new Bike(plate, scheme);
            } else if (occupiedRegular < maxRegularSlots) {
                allocatedSlot = new Regular(plate, scheme);
                allocatedSlot.setSurchargeApplied(true);
            } else if (occupiedLarge < maxLargeSlots) {
                allocatedSlot = new Large(plate, scheme);
                allocatedSlot.setSurchargeApplied(true);
            }
        } else if ("CAR".equals(vehicleType)) {
            if (occupiedRegular < maxRegularSlots) {
                allocatedSlot = new Regular(plate, scheme);
            } else if (occupiedLarge < maxLargeSlots) {
                allocatedSlot = new Large(plate, scheme);
                allocatedSlot.setSurchargeApplied(true);
            }
        } else if ("TRUCK".equals(vehicleType)) {
            if (occupiedLarge < maxLargeSlots) {
                allocatedSlot = new Large(plate, scheme);
            }
        }


        if (allocatedSlot == null) {
            Slot.incrementDeclined();
        } else {
            activeSlots.add(allocatedSlot);
        }
    }

    private static void passTime(int hours) {
        List<Slot> evictedSlots = new ArrayList<>();

        for (Slot s : activeSlots) {
            s.timeSpent(hours);
            if (s.getHours() >= Slot.getMaxStay()) {
                evictedSlots.add(s);
            }
        }

        int maxStay = Slot.getMaxStay();
        int removalHours = (maxStay + 9) / 10;
        int totalBilledHours = maxStay + removalHours;

        for (Slot s : evictedSlots) {
            int evictionBill = calculateEvictionBill(s, totalBilledHours);
            Slot.addEarned(evictionBill);
            activeSlots.remove(s);
        }
    }

    private static int calculateEvictionBill(Slot slot, int totalHours) {
        int baseFee = 0;
        int surchargeFee = 0;
        int effectiveHours = (totalHours == 0) ? 1 : totalHours;

        if (slot instanceof Bike) {
            baseFee = 10 + (effectiveHours - 1) * 5;
            surchargeFee = 0;
        } else if (slot instanceof Regular) {
            baseFee = 30 + (effectiveHours - 1) * 20;
            surchargeFee = slot.isSurchargeApplied() ? 15 : 0;
        } else if (slot instanceof Large) {
            baseFee = 50 + (effectiveHours - 1) * 40;
            surchargeFee = slot.isSurchargeApplied() ? 25 : 0;
        }

        return slot.applySchemeDiscount(baseFee + surchargeFee);
    }

}