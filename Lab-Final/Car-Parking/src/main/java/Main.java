import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String slotsLine = reader.readLine();
        String[] slotsParts = slotsLine.trim().split("\\s+");
        Map<Slot, Integer> capacity = new HashMap<>();
        capacity.put(Slot.BIKE, Integer.parseInt(slotsParts[1]));
        capacity.put(Slot.REGULAR, Integer.parseInt(slotsParts[2]));
        capacity.put(Slot.LARGE, Integer.parseInt(slotsParts[3]));

        String maxStayLine = reader.readLine();
        String[] maxStayParts = maxStayLine.trim().split("\\s+");
        int maxStay = Integer.parseInt(maxStayParts[1]);

        Park park = new Park(capacity, maxStay);
            Scanner input = new Scanner(System.in);
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] field = line.split(" ");
                String cmd=field[0];
                switch (cmd) {
                    case "END":
                        reader.close();
                        System.out.println(out);
                        return;

                    case "BIKE":
                    case "CAR":
                    case "TRUCK": {
                        String plate = field[1];
                        Scheme scheme = Scheme.valueOf(field[2]);
                        Vehicle vehicle;
                        switch (cmd) {
                            case "BIKE": vehicle = new Bike(plate, scheme); break;
                            case "CAR": vehicle = new Car(plate, scheme); break;
                            default: vehicle = new Truck(plate, scheme); break;
                        }
                        try {
                           park.arrive(vehicle);
                        } catch (NoPlateException | NoFreeSlotException e) {
                            park.recordRefusal();
                        }
                        break;
                    }
                    case "PASSTIME": {
                        int hours = Integer.parseInt(field[1]);
                        park.passTime(hours);
                        break;
                    }
                    case "LEAVE": {
                        String plate = field[1];
                        try {
                            park.leave(plate);
                        } catch (UnknownPlateException e) {
                            park.recordRefusal();
                        }
                        break;
                    }
                    case "BILL": {
                        String plate = field[1];
                        out.append(park.billQuery(plate)).append('\n');
                        break;
                    }
                    case "SLOT": {
                        String plate = field[1];
                        out.append(park.slotQuery(plate)).append('\n');
                        break;
                    }
                    case "FREE": {
                        Slot kind = Slot.valueOf(field[1]);
                        out.append(park.freeQuery(kind)).append('\n');
                        break;
                    }
                    case "COUNT":
                        out.append(park.count()).append('\n');
                        break;
                    case "EARNED":
                        out.append(park.earned()).append('\n');
                        break;
                    case "REFUSED":
                        out.append(park.refused()).append('\n');
                        break;


                }
            }
        System.out.print(out);
    }
}
