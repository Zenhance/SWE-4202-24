import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int time=1;
        Slot slot = new Slot(0,0,0);
        int maxtime=1;
        plates plates = new plates();
    Scanner sc = new Scanner(System.in);
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
                        maxtime = hours;
                        // ... do something with hours ...
                    } else if (field[0].equals("COUNT")) {
                        System.out.println(/* the number you worked out */);
                    } else if (field[0].equals("LEAVE")) {
                        
                    }
                    else if (field[0].equals("BILL")) {}
                    else if (field[0].equals("SLOT")) {

                    }
                    else if (field[0].equals("EARNED")) {}
                    else if(field[0].equals("FREE")) {
                        if(field[1].equals("BIKE"))System.out.println(slot.bike);
                        else if(field[1].equals("REGULAR"))System.out.println(slot.regular);
                        else if(field[1].equals("LARGE"))System.out.println(slot.truck);
                    }
                    else if (field[0].equals("PASSTIME")) {
                        int hours = Integer.parseInt(field[1]);
                        time = hours;

                    }
                    else if (field[0].equals("SLOTS")) {
                         slot = new Slot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));

                    }
                    else if (field[0].equals("BIKE")) {
                        plates.plates.add(field[1]);
                    }
                    else if (field[0].equals("CAR")) {}
                    else if (field[0].equals("TRUCK")) {}
                    else if (field[0].equals("REFUSED")) {}
                    // ... one branch per keyword ...
                }
            }
        }
    