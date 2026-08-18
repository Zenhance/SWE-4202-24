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
            } else if (field[0].equals("MAXSTAY")) {
                int hours = Integer.parseInt(field[1]);
                // ... do something with hours ...
                Vehicle.maxHours = hours;
            } else if (field[0].equals("COUNT")) {
                System.out.println(/* the number you worked out */);
            } else if (field[0].equals("SLOT")) {
                if(field.length <= 2){
                    Vehicle v = Vehicle.search(field[1]);
                    if(v!=null) {
                        Slot s = new Slot(v);
                    }
                }

            }
            // ... one branch per keyword ...

        }
    }
}