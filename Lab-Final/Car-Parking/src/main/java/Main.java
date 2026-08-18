import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bikeSlots = 0;
        int regularSlots = 0;
        int largeSlots = 0;
        int maxStay = 0;
        ParkingLot parkingLot = null;
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] field = line.split(" ");
            if (field[0].equals("END")) {
                break;
            }
            if (field[0].equals("SLOTS")) {
                bikeSlots = Integer.parseInt(field[1]);
                regularSlots = Integer.parseInt(field[2]);
                largeSlots = Integer.parseInt(field[3]);
            }
            else if (field[0].equals("MAXSTAY")) {
                maxStay = Integer.parseInt(field[1]);
                parkingLot = new ParkingLot(bikeSlots, regularSlots, largeSlots, maxStay);
            }
            else {
                try {
                    switch (field[0]) {
                        case "BIKE":
                            Vehicle bike = new Motorcycle(field[1], field[2]);
                            parkingLot.arrive(bike);
                            break;

                        case "CAR":
                            Vehicle car = new Car(field[1], field[2]);
                            parkingLot.arrive(car);
                            break;

                        case "TRUCK":
                            Vehicle truck = new Truck(field[1], field[2]);
                            parkingLot.arrive(truck);
                            break;

                        case "PASSTIME":
                            int hours = Integer.parseInt(field[1]);
                            parkingLot.passTime(hours);
                            break;

                        case "LEAVE":
                            parkingLot.leave(field[1]);
                            break;

                        case "BILL":
                            System.out.println(parkingLot.bill(field[1]));
                            break;

                        case "SLOT":
                            System.out.println(parkingLot.slot(field[1]));
                            break;

                        case "FREE":
                            System.out.println(parkingLot.free(field[1]));
                            break;

                        case "COUNT":
                            System.out.println(parkingLot.count());
                            break;

                        case "EARNED":
                            System.out.println(parkingLot.getEarned());
                            break;

                        case "REFUSED":
                            System.out.println(parkingLot.getRefused());
                            break;
                    }
                } catch (ParkingException e) {
                    parkingLot.addRefusal();
                    if (field[0].equals("BILL") || field[0].equals("SLOT")) {
                        System.out.println("NONE");
                    }
                }
            }
        }
        }
    }