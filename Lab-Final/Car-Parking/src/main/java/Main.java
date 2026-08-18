import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Slot> vehicles = new ArrayList<>();

        int total = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");


            switch(field[0]){
                case "END" -> {
                    break;
                }

                case "SLOTS" -> {
                    Bike.setSlotforBike(Integer.parseInt(field[1]));
                    Regular.setSlotforRegular(Integer.parseInt(field[2]));
                    Large.setSlotforLarge(Integer.parseInt(field[3]));
                }
                case "MAXSTAY" -> {
                    int hours = Integer.parseInt(field[1]);
                    Slot.setMAXSTAY(hours);
                }

                case "BIKE" -> {
                    if (Bike.getAvailableBike() > 0){
                        vehicles.add(new Bike(field[1], field[2], false));
                    }
                    else if (Regular.getAvailableRegular() > 0){
                        vehicles.add(new Regular(field[1], field[2], true));
                    }
                    else if (Large.getAvailableLarge() > 0){
                        vehicles.add(new Regular(field[1], field[2], true));
                    }
                    else Slot.refused();

                }

                case  "CAR" -> {
                    if (Regular.getAvailableRegular() > 0){
                        vehicles.add(new Regular(field[1], field[2], false));
                    }
                    else if (Large.getAvailableLarge() > 0){
                        vehicles.add(new Large(field[1], field[2],true));
                    }
                    else Slot.refused();
                }

                case "TRUCK" -> {
                    if (Large.getAvailableLarge() > 0){
                        vehicles.add(new Large(field[1], field[2],false));
                    }
                    else Slot.refused();
                }

                case "PASSTIME" -> {
                    for (Slot v : vehicles){
                        v.passtime(Integer.parseInt(field[1]) - 1);
                    }
                }

                case "LEAVE" -> {
                    for (Slot v: vehicles){
                        if (v.getLicense().equals(field[1])){
                            if (v instanceof Bike) Bike.freeUpSlot();
                            else if (v instanceof Regular) Regular.freeUpslot();
                            else Large.freeUpslot();

                            total += v.calculatefee();
                            vehicles.remove(v);
                            break;
                        }
                    }
                }

                case "BILL" -> {
                    for (Slot v : vehicles) {
                        if (v.getLicense().equals(field[1])) {
                            System.out.println(v.calculatefee());
                            break;
                        }
                    }
                }

                case "SLOT" -> {
                    String vehicleType = "";
                    for (Slot v : vehicles) {
                        if (v.getLicense().equals(field[1])) {
                            if (v instanceof Bike) System.out.println("BIKE");
                            else if (v instanceof Regular) System.out.println("REGULAR");
                            else System.out.println("LARGE");

                            break;
                        }
                    }
                }

                case "FREE" -> {
                    int res;
                    if(field[1].equals("BIKE")) res = Bike.getAvailableBike();
                    else if (field[1].equals("REGULAR")) res = Regular.getAvailableRegular();
                    else res = Large.getAvailableLarge();

                    System.out.println(res);
                }

                case "COUNT" -> {
                    System.out.println(Slot.getCount());
                }

                case "EARNED" -> {

                    System.out.println(total);
                }

                case "REFUSED" -> {
                    System.out.println(Slot.refused);
                }
            }
        }
    }
}