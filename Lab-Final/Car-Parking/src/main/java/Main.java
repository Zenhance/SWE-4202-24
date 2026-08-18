
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        List<Slot> vehicles = new ArrayList<>();
        boolean end=false;
        int total = 0;


        Scanner input = new Scanner(System.in);
        while (!end && input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");


            switch(field[0]){
                case "END":
                    end=true;
                    break;



                case "MAXSTAY":
                    int hours = Integer.parseInt(field[1]);
                    Slot.setMAXSTAY(hours);


                case "BIKE":
                    if (Bike.getBikeSlot() > 0){
                        vehicles.add(new Bike(field[1], field[2]));

                    }
                    else if (Regular.getRegularSlot() > 0){
                        vehicles.add(new Regular(field[1], field[2]));
                    }
                    else if (Truck.getTruckSlot() > 0){
                        vehicles.add(new Regular(field[1], field[2]));
                    }
                    else Slot.refused();



                case  "CAR":
                    if (Regular.getRegularSlot() > 0){
                        vehicles.add(new Regular(field[1], field[2]));
                    }
                    else if (Truck.getTruckSlot() > 0){
                        vehicles.add(new Truck(field[1], field[2]));
                    }
                    else Slot.refused();


                case "TRUCK":
                    if (Truck.getTruckSlot() > 0){
                        vehicles.add(new Truck(field[1], field[2]));
                    }
                    else Slot.refused();


                case "PASSTIME":
                    for (Slot v : vehicles){
                        v.setPASSTIME(Integer.parseInt(field[1]));
                    }


                case "LEAVE":
                    for (Slot v: vehicles){
                        if (v.getNumPlate().equals(field[1])){
                            if (v instanceof Bike) Bike.free();
                            else if (v instanceof Regular) Regular.free();
                            else Truck.free();

                            vehicles.remove(v);
                            break;
                        }
                    }


                case "BILL":
                    for (Slot v : vehicles) {
                        if (v.getNumPlate().equals(field[1])) {
                            if (v instanceof Bike){
                                System.out.println(v.bikeBill);
                            }
                            else if (v instanceof Regular){
                                System.out.println(v.reglarBill);
                            }
                            else{
                                System.out.println(v.truckBill);
                            }
                            break;
                        }
                    }


                case "SLOT":
                    String vehicleType;
                    for (Slot v : vehicles) {
                        if (v.getNumPlate().equals(field[1])) {
                            if (v instanceof Bike){
                                vehicleType="Bike";
                            }
                            else if (v instanceof Regular){
                                vehicleType="Regular";
                            }
                            else {
                            vehicleType="Large";
                            }

                            break;
                        }
                    }


                case "FREE":
                    int res;
                    for (Slot v : vehicles) {
                        if (v.getNumPlate().equals(field[1])) {
                            if(field[1].equals("BIKE")) res = Bike.getBikeSlot();
                            else if (field[1].equals("REGULAR")) res = Regular.getRegularSlot();
                            else res = Truck.getTruckSlot();

                            System.out.println(res);
                            break;
                        }
                    }


                case "COUNT":
                    System.out.println(Slot.getSlot());


                case "EARNED":
                    for (Slot v : vehicles){
                        total += v.getEarnings();
                    }
                    System.out.println(total);


                case "REFUSED":
                    System.out.println(Slot.refused());

            }
        }
    }
}