

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot park = new ParkingLot();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String command = parts[0];

            if (command.equals("END")) {
                break;
            }

            try {
                switch (command) {
                    case "SLOTS" -> park.setupSlots(
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3])
                    );
                    case "MAXSTAY" -> park.setMaxStay(Integer.parseInt(parts[1]));
                    case "BIKE", "CAR", "TRUCK" -> handleEntry(park, command, parts[1], parts[2]);
                    case "PASSTIME" -> park.passTime(Integer.parseInt(parts[1]));
                    case "LEAVE" -> park.leaveVehicle(parts[1]);
                    case "BILL" -> System.out.println(park.getBill(parts[1]));
                    case "SLOT" -> System.out.println(park.getSlotKind(parts[1]));
                    case "FREE" -> System.out.println(park.getFreeCount(SlotKind.valueOf(parts[1])));
                    case "COUNT" -> System.out.println(park.getActiveCount());
                    case "EARNED" -> System.out.println(park.getTotalEarned());
                    case "REFUSED" -> System.out.println(park.getTotalRefused());
                }
            } catch (ParkRefusalException e) {
                park.incrementRefused();
            }
        }
        scanner.close();
    }

