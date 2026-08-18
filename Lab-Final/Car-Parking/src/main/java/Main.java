import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args){
        int time=1;
        Slot slot = new Slot(0,0,0);
        int maxtime=1;
        int refused=0,count=0;
        Fee fee=new Fee();
        List<Vehicles> vehicles=new ArrayList<>();

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
                                count--;
                                break;
                            }

                        }
                        if(i==vehicles.size()-1)System.out.println("NONE");
                    }
                    else if (field[0].equals("BILL")) {
                        int i;
                        for( i=0;i<vehicles.size();i++){
                            if(vehicles.get(i).plate.equals(field[1])){System.out.println(fee.Calcfee(vehicles.get(i)));break;}
                        }
                        if(i==vehicles.size()-1)System.out.println("NONE");
                    }
                    else if (field[0].equals("SLOT")) {
                        int i;
                        for( i=0;i<vehicles.size();i++){
                            if(vehicles.get(i).plate.equals(field[1])){System.out.println(vehicles.get(i).slot);break;}
                        }
                        if(i==vehicles.size()-1)System.out.println("NONE");
                    }
                    else if (field[0].equals("EARNED")) {
                        int earned=0;
                        for(int i=0;i<vehicles.size();i++){
                            earned+=fee.Calcfee(vehicles.get(i));
                        }
                        System.out.println(earned);
                    }
                    else if(field[0].equals("FREE")) {
                        if(field[1].equals("BIKE"))System.out.println(slot.bike);
                        else if(field[1].equals("REGULAR"))System.out.println(slot.regular);
                        else if(field[1].equals("LARGE"))System.out.println(slot.truck);
                    }
                    else if (field[0].equals("PASSTIME")) {
                        int hours = Integer.parseInt(field[1]);
                        for (Vehicles vehicle : vehicles) {
                            vehicle.time+=hours;
                            if(vehicle.time>maxtime) vehicle.time=max(vehicle.time,maxtime)+1;

                        }

                    }
                    else if (field[0].equals("SLOTS")) {
                         slot = new Slot(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));

                    }
                    else if (field[0].equals("BIKE")) {
                        Vehicles v=new Vehicles(field[1]);
                        try {
                            if(field[1].equals("-")) throw new noplates();
                        } catch (noplates e) {
                            refused++;
                        }
                        vehicles.add(v);
                        try{
                        if(slot.bike > 0){slot.bike --;count++;v.slot="BIKE";}
                        else if(slot.regular > 0){slot.regular--;count++;v.slot="REGULAR";}
                        else if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                        else throw new Slotsfull();
                        } catch (Slotsfull e) {
                            vehicles.remove(v);
                            refused++;
                            System.out.println(0);
                        }
                        v.scheme=field[2];
                    }
                    else if (field[0].equals("CAR")) { Vehicles v=new Vehicles(field[1]);
                        try {
                            if(field[1].equals("-")) throw new noplates();
                        } catch (noplates e) {
                            refused++;
                        }
                        vehicles.add(v);
                        try{
                            if(slot.regular > 0){slot.regular--;count++;v.slot="REGULAR";}
                            else if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                            else throw new Slotsfull();
                        } catch (Slotsfull e) {
                            vehicles.remove(v);
                            refused++;
                            System.out.println(0);
                        }
                        v.scheme=field[2];
                    }

                    else if (field[0].equals("TRUCK")) {
                        Vehicles v=new Vehicles(field[1]);
                        try {
                            if(field[1].equals("-")) throw new noplates();
                        } catch (noplates e) {
                            refused++;
                        }
                        vehicles.add(v);

                        try{
                            if(slot.truck > 0){slot.truck--;count++;v.slot="LARGE";}
                            else throw new Slotsfull();
                        } catch (Slotsfull e) {
                            vehicles.remove(v);
                            refused++;
                            System.out.println(0);
                        }
                        v.scheme=field[2];
                    }

                    else if (field[0].equals("REFUSED")) {System.out.println(refused);}
                    // ... one branch per keyword ...
                }
            }
        }
    