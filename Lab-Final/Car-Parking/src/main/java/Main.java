import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParkingLot lot = new ParkingLot();

        while(input.hasNextLine()){
            String line=input.nextLine().trim();
            if(line.isEmpty()){
                continue;
            }

            String[] field=line.split(" ");
            String command=field[0];
            if(command.equals("END")) {
                break;
            }else if(command.equals("SLOTS")) {
                int bike=Integer.parseInt(field[1]);
                int regular=Integer.parseInt(field[2]);
                int large=Integer.parseInt(field[3]);
                lot.setSlots(bike,regular,large);
            }else if(command.equals("MAXSTAY")) {
                int hours=Integer.parseInt(field[1]);
                lot.setMaxStay(hours);
            }
            else if (command.equals("BIKE") || command.equals("CAR") || command.equals("TRUCK")) {
                String plate = field[1];
                Category category = Category.valueOf(field[2]);
                Vehicle vehicle = createVehicle(command, plate, category);
                lot.register(vehicle);
            }

            // questions that print an answer
            else if (command.equals("SLOT")) {
                SlotType slot = lot.slotOf(field[1]);
                if (slot == null) {
                    System.out.println("NONE");
                } else {
                    System.out.println(slot.name());
                }
            }
            else if(command.equals("FREE")) {
                SlotType type = SlotType.valueOf(field[1]);
                System.out.println(lot.freeCount(type));
            }
            else if(command.equals("COUNT")) {
                System.out.println(lot.parkedCount());
            }
            else if(command.equals("REFUSED")) {
                System.out.println(lot.refusedCount());
            }
            else if(command.equals("BILL")) {
                Integer bill = lot.billFor(field[1]);
                if(bill==null) {
                    System.out.println("NONE");
                }
                else{
                    System.out.println(bill);
                }
            }
        }
    }
}