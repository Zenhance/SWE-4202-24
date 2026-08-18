import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
        List<Slot> slots = new ArrayList<>();
        Map<String, Vehicle> vehicles = new HashMap<>();
        int maxStay;
        int totalEarnings = 0;
        int refusedCount = 0;
        int currentTime = 0;


        void parkVehicle(Vehicle v) {
            Slot chosen = null;
            for (Slot s : slots) {
                if (!s.occupied && canFit(v.type, s.slotType)) {
                    chosen = s;
                    break;
                }
            }
            if (chosen == null) {
                System.out.println("REFUSED " + v.id);
                refusedCount++;
            } else {
                chosen.occupied = true;
                v.slot = chosen;
                v.entryTime = currentTime;
                vehicles.put(v.id, v);
                System.out.println("PARKED " + v.id + " IN " + chosen.slotType);
            }
        }


        void freeSlots() {
            long free = slots.stream().filter(s -> !s.occupied).count();
            System.out.println("FREE " + free);
        }


        void countRefused() {
            System.out.println("REFUSED " + refusedCount);
        }


        void billVehicle(String id, int rate) {
            Vehicle v = vehicles.get(id);
            if (v == null) {
                System.out.println("NO VEHICLE " + id);
                return;
            }
            int hours = currentTime - v.entryTime;
            int bill = hours * rate;
            System.out.println("BILL " + id + " " + bill);
        }


        void passTime(int hours) {
            currentTime += hours;
        }


        void leaveVehicle(String id, int rate) {
            Vehicle v = vehicles.remove(id);
            if (v == null) {
                System.out.println("NO VEHICLE " + id);
                return;
            }
            int hours = currentTime - v.entryTime;
            int bill = hours * rate;
            totalEarnings += bill;
            v.slot.occupied = false;
            System.out.println("LEFT " + id + " BILL " + bill);
        }


        void earned() {
            System.out.println("EARNED " + totalEarnings);
        }


        boolean canFit(String vehicleType, String slotType) {
                switch (vehicleType) {
                    case "BIKE" : return slotType.equals("BIKE") || slotType.equals("REGULAR") || slotType.equals("LARGE");
                    case "CAR"  : return slotType.equals("REGULAR") || slotType.equals("LARGE");
                    case "TRUCK":  return slotType.equals("LARGE");
                    default: return false;
                }
            }
    }
