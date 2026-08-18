import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int time=1;
        Slot slot = new Slot(0,0,0);
        int maxtime=1;
        int refused=0,count=0;
        List<Vehicles> vehicles=new ArrayList<Vehicles>();
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
                    }
                    else if (field[0].equals("MAXSTAY")) {
                        int hours = Integer.parseInt(field[1]);
                        maxtime = hours;
                        // ... do something with hours ...
                    }
                    else if (field[0].equals("COUNT")) {

                        System.out.println(count);
                    } else if (field[0].equals("LEAVE")) {
                        int i;
                        for( i=0;i<vehicles.size();i++){
                            if(vehicles.get(i).plate.equals(field[1])){
                                if(Objects.equals(vehicles.get(i).slot, "BIKE")){slot.bike++;}
                                else if(Objects.equals(vehicles.get(i).slot, "REGULAR")){slot.regular++;}
                                else if (Objects.equals(vehicles.get(i).slot, "LARGE")) {slot.truck++;}
                                break;
                            }

                        }
                        if(i==vehicles.size()-1)System.out.println("NONE");
                    }
                    else if (field[0].equals("BILL")) {}
                    else if (field[0].equals("SLOT")) {
                        int i;
                        for( i=0;i<vehicles.size();i++){
                            if(vehicles.get(i).plate.equals(field[1])){System.out.println(vehicles.get(i).slot);break;}
                        }
                        if(i==vehicles.size()-1)System.out.println("NONE");
                    }
                    else if (field[0].equals("EARNED")) {}
                    else if(field[0].equals("FREE")) {
                        if(field[1].equals("BIKE"))System.out.println(slot.bike);
                        else if(field[1].equals("REGULAR"))System.out.println(slot.regular);
                        else if(field[1].equals("LARGE"))System.out.println(slot.truck);
                    }
                    else if (field[0].equals("PASSTIME")) {
                        int hours = Integer.parseInt(field[1]);
                        time += hours;
                        for (Vehicles vehicle : vehicles) {
                            vehicle.time=time;
                            if(vehicle.time>maxtime) vehicle.evict=true;
                        }

                    }
                    else if (field[0].equals("SLOTS")) {
                         slot = new Slot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));

                    }
                    else if (field[0].equals("BIKE")) {
                        Vehicles v=new Vehicles(field[1]);
                        if(field[1].equals(" "))System.out.println(slot.bike);

                        else vehicles.add(v);
                        if(slot.bike > 0){slot.bike --;count++;v.slot="BIKE";}
                        else if(slot.regular > 0){slot.regular--;count++;v.slot="REGULAR";}
                        else if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                        else {System.out.println(0);refused++;}

                    }
                    else if (field[0].equals("CAR")) { Vehicles v=new Vehicles(field[1]);
                        if(field[1].equals(" "))System.out.println(slot.bike);

                        else vehicles.add(v);
                        if(slot.regular > 0){slot.regular--;count++;v.slot="REGULAR";}
                        else if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                        else {System.out.println(0);refused++;}}

                    else if (field[0].equals("TRUCK")) { Vehicles v=new Vehicles(field[1]);
                        if(field[1].equals(" "))System.out.println(slot.bike);
                        else vehicles.add(v);
                        if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                        else {System.out.println(0);refused++;}}
                    else if (field[0].equals("REFUSED")) {System.out.println(refused);}
                    // ... one branch per keyword ...
                }
            }
        }
    