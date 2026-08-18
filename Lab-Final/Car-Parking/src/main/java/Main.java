import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Parkinglot lot= new Parkinglot();

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");
            String command = field[0];

            if (command.equals("END")) {
                break; }
                else if (command.equals("SLOTS")) {
                    int bike = Integer.parseInt(field[1]);
                    int regular = Integer.parseInt(field[2]);
                    int large = Integer.parseInt(field[3]);
                    lot.setSlots(bike, regular, large);
            } else if (command.equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);

                lot.setMaxStay(hours);
            } else if (command.equals("COUNT")) {
                System.out.println(lot.parkedCount());


            }
                else if(command.equals("PASSTIME"){

            }

            else if(command.equals("LEAVE")){


            }

            else if(command.equals("TRUCK")){


            }
            // ... one branch per keyword ...
        }
    }
}