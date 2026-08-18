public class Settlementrun {
}
import java.util.*;

// --- Core Models ---
enum SpotType {
    BIKE, REGULAR, LARGE, NONE
}

enum VehicleType {
    BIKE, CAR, TRUCK
}

enum PassType {
    NONE, STUDENT, WEEKEND
}

class Spot {
    private SpotType type;
    private boolean isOccupied;
    private String vehicleReg;

    public Spot(SpotType type) {
        this.type = type;
        this.isOccupied = false;
        this.vehicleReg = "";
    }

    public SpotType getType() { return type; }
    public boolean isOccupied() { return isOccupied; }
    public String getVehicleReg() { return vehicleReg; }

    public void occupy(String vehicleReg) {
        this.isOccupied = true;
        this.vehicleReg = vehicleReg;
    }

    public void vacate() {
        this.isOccupied = false;
        this.vehicleReg = "";
    }
}

class Vehicle {
    private String regNum;
    private VehicleType vType;
    private PassType pass;
    private int entryTime;
    private SpotType assignedSpot;

    public Vehicle(String regNum, VehicleType vType, PassType pass, int entryTime) {
        this.regNum = regNum;
        this.vType = vType;
        this.pass = pass;
        this.entryTime = entryTime;
        this.assignedSpot = SpotType.NONE;
    }

    public String getRegNum() { return regNum; }
    public VehicleType getVType() { return vType; }
    public PassType getPass() { return pass; }
    public int getEntryTime() { return entryTime; }
    public SpotType getAssignedSpot() { return assignedSpot; }

    public void setAssignedSpot(SpotType spotType) {
        this.assignedSpot = spotType;
    }
}

// System Manager
class ParkingSystem {
    private List<Spot> bikeSpots = new ArrayList<>();
    private List<Spot> regularSpots = new ArrayList<>();
    private List<Spot> largeSpots = new ArrayList<>();

    private Map<String, Vehicle> activeVehicles = new HashMap<>();

    private int maxStay = 0;
    private int currentTime = 0;
    private int totalEarned = 0;
    private int refusedCount = 0;

    public void setSlots(int b, int r, int l) {
        bikeSpots.clear();
        regularSpots.clear();
        largeSpots.clear();

        for (int i = 0; i < b; i++) bikeSpots.add(new Spot(SpotType.BIKE));
        for (int i = 0; i < r; i++) regularSpots.add(new Spot(SpotType.REGULAR));
        for (int i = 0; i < l; i++) largeSpots.add(new Spot(SpotType.LARGE));
    }

    public void setMaxStay(int ms) {
        this.maxStay = ms;
    }

    public void addVehicle(String typeStr, String regNum, String passStr) {
        if (regNum.equals("-") || regNum.trim().isEmpty()) {
            refusedCount++;
            return;
        }

        VehicleType vt = VehicleType.valueOf(typeStr);
        PassType pass = parsePassType(passStr);
        SpotType assigned = SpotType.NONE;

        // Try to park vehicle based on type priorities
        if (vt == VehicleType.BIKE) {
            if (findAndOccupy(bikeSpots, regNum)) assigned = SpotType.BIKE;
            else if (findAndOccupy(regularSpots, regNum)) assigned = SpotType.REGULAR;
            else if (findAndOccupy(largeSpots, regNum)) assigned = SpotType.LARGE;
        } else if (vt == VehicleType.CAR) {
            if (findAndOccupy(regularSpots, regNum)) assigned = SpotType.REGULAR;
            else if (findAndOccupy(largeSpots, regNum)) assigned = SpotType.LARGE;
        } else if (vt == VehicleType.TRUCK) {
            if (findAndOccupy(largeSpots, regNum)) assigned = SpotType.LARGE;
        }

        if (assigned != SpotType.NONE) {
            Vehicle v = new Vehicle(regNum, vt, pass, currentTime);
            v.setAssignedSpot(assigned);
            activeVehicles.put(regNum, v);
            System.out.println(assigned);
        } else {
            refusedCount++;
        }
    }

    private boolean findAndOccupy(List<Spot> spots, String regNum) {
        for (Spot spot : spots) {
            if (!spot.isOccupied()) {
                spot.occupy(regNum);
                return true;
            }
        }
        return false;
    }

    private PassType parsePassType(String passStr) {
        if ("STUDENT".equalsIgnoreCase(passStr)) return PassType.STUDENT;
        if ("WEEKEND".equalsIgnoreCase(passStr)) return PassType.WEEKEND;
        return PassType.NONE;
    }

    public void getSlotOfVehicle(String regNum) {
        if (activeVehicles.containsKey(regNum)) {
            System.out.println(activeVehicles.get(regNum).getAssignedSpot());
        } else {
            System.out.println("NONE");
        }
    }

    public void countFreeSpots(String spotTypeStr) {
        SpotType st = SpotType.valueOf(spotTypeStr);
        List<Spot> targetList = null;

        if (st == SpotType.BIKE) targetList = bikeSpots;
        else if (st == SpotType.REGULAR) targetList = regularSpots;
        else if (st == SpotType.LARGE) targetList = largeSpots;

        long count = 0;
        if (targetList != null) {
            count = targetList.stream().filter(s -> !s.isOccupied()).count();
        }
        System.out.println(count);
    }

    public void printActiveCount() {
        System.out.println(activeVehicles.size());
    }

    public void printRefusedCount() {
        System.out.println(refusedCount);
    }

    private int calculateBill(Vehicle v) {
        int duration = currentTime - v.getEntryTime();
        int baseRate = 0;

        switch (v.getVType()) {
            case BIKE: baseRate = 5; break;
            case CAR: baseRate = 15; break;
            case TRUCK: baseRate = 25; break;
        }

        int total = duration * baseRate;

        // Pass discount policies
        if (v.getPass() == PassType.STUDENT) {
            total = total / 2; // 50% discount
        } else if (v.getPass() == PassType.WEEKEND) {
            total = Math.max(0, total - 10);
        }

        return total;
    }

    public void printBill(String regNum) {
        if (activeVehicles.containsKey(regNum)) {
            System.out.println(calculateBill(activeVehicles.get(regNum)));
        } else {
            System.out.println(0);
        }
    }

    public void vehicleLeave(String regNum) {
        if (activeVehicles.containsKey(regNum)) {
            Vehicle v = activeVehicles.get(regNum);
            int bill = calculateBill(v);
            totalEarned += bill;

            // Free up spot
            List<Spot> targetList = null;
            if (v.getAssignedSpot() == SpotType.BIKE) targetList = bikeSpots;
            else if (v.getAssignedSpot() == SpotType.REGULAR) targetList = regularSpots;
            else if (v.getAssignedSpot() == SpotType.LARGE) targetList = largeSpots;

            if (targetList != null) {
                for (Spot spot : targetList) {
                    if (spot.isOccupied() && regNum.equals(spot.getVehicleReg())) {
                        spot.vacate();
                        break;
                    }
                }
            }
            activeVehicles.remove(regNum);
        }
    }

    public void passTime(int hours) {
        currentTime += hours;
    }

    public void printEarned() {
        System.out.println(totalEarned);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem system = new ParkingSystem();

        while (scanner.hasNext()) {
            String cmd = scanner.next();
            if ("END".equals(cmd)) {
                break;
            }

            switch (cmd) {
                case "SLOTS":
                    int b = scanner.nextInt();
                    int r = scanner.nextInt();
                    int l = scanner.nextInt();
                    system.setSlots(b, r, l);
                    break;
                case "MAXSTAY":
                    system.setMaxStay(scanner.nextInt());
                    break;
                case "BIKE":
                case "CAR":
                case "TRUCK":
                    String reg = scanner.next();
                    String pass = scanner.next();
                    system.addVehicle(cmd, reg, pass);
                    break;
                case "SLOT":
                    system.getSlotOfVehicle(scanner.next());
                    break;
                case "FREE":
                    system.countFreeSpots(scanner.next());
                    break;
                case "COUNT":
                    system.printActiveCount();
                    break;
                case "REFUSED":
                    system.printRefusedCount();
                    break;
                case "BILL":
                    system.printBill(scanner.next());
                    break;
                case "PASSTIME":
                    system.passTime(scanner.nextInt());
                    break;
                case "LEAVE":
                    system.vehicleLeave(scanner.next());
                    break;
                case "EARNED":
                    system.printEarned();
                    break;
            }
        }
        scanner.close();
    }
}