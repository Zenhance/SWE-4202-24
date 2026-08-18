import java.util.*;

class BlankPlateException extends Exception
{

}
class NoSlotAvailableException extends Exception
{

}
class VehicleNotFoundException extends Exception
{

}

enum SlotType
{
    BIKE, REGULAR, LARGE
}

interface DiscountScheme
{
    int applyDiscount(int billAmount);
}

class NoneDiscount implements DiscountScheme
{
    public int applyDiscount(int b)
    {
        return b;
    }
}

class StudentDiscount implements DiscountScheme
{
    public int applyDiscount(int b)
    {
        return b - (20 * b / 100);
    }
}

class WeekendDiscount implements DiscountScheme
{
    public int applyDiscount(int b)
    {
        return Math.max(0, b - 10);
    }
}

class Vehicle
{
    private final String licensePlate;
    private final String vehicleType;
    private final SlotType parkedSlot;
    private final DiscountScheme discount;
    private final int entryTime;

    Vehicle(String licensePlate, String vehicleType, SlotType parkedSlot, DiscountScheme discount, int entryTime)
    {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.parkedSlot = parkedSlot;
        this.discount = discount;
        this.entryTime = entryTime;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public String getVehicleType()
    {
        return vehicleType;
    }

    public SlotType getParkedSlot()
    {
        return parkedSlot;
    }

    public DiscountScheme getDiscount()
    {
        return discount;
    }

    public int getEntryTime()
    {
        return entryTime;
    }


}
    class ParkingLot
    {
        private int maxStay = 0;
        private int currentTime = 0;
        private int totalEarned = 0;
        private int refusedCount = 0;
        private final Map<SlotType, Integer> capacities = new HashMap<>();
        private final Map<SlotType, Integer> occupancy = new HashMap<>();
        private final Map<String, Vehicle> registry = new LinkedHashMap<>();
        public void initSlots(int bike, int regular, int large)
        {
            capacities.put(SlotType.BIKE, bike);
            capacities.put(SlotType.REGULAR, regular);
            capacities.put(SlotType.LARGE, large);
            occupancy.put(SlotType.BIKE, 0);
            occupancy.put(SlotType.REGULAR, 0);
            occupancy.put(SlotType.LARGE, 0);
        }
        public void setMaxStay(int maxStay)
        {
            this.maxStay = maxStay;
        }
        public void parkVehicle(String type, String plate, String schemeStr)
                throws BlankPlateException, NoSlotAvailableException
        {
            if(plate.equals("-"))
            {
                refusedCount++;
                throw new BlankPlateException();
            }
            SlotType allocated = null;
            if(type.equals("BIKE"))
            {
                if(occupancy.get(SlotType.BIKE) < capacities.get(SlotType.BIKE))
                    allocated = SlotType.BIKE;
                else if(occupancy.get(SlotType.REGULAR) < capacities.get(SlotType.REGULAR))
                    allocated = SlotType.REGULAR;
                else if(occupancy.get(SlotType.LARGE) < capacities.get(SlotType.LARGE))
                    allocated = SlotType.LARGE;
            }
            else if(type.equals("CAR"))
            {
                if(occupancy.get(SlotType.REGULAR) < capacities.get(SlotType.REGULAR))
                    allocated = SlotType.REGULAR;
                else if(occupancy.get(SlotType.LARGE) < capacities.get(SlotType.LARGE))
                    allocated = SlotType.LARGE;
            }
            else if(type.equals("TRUCK"))
            {
                if(occupancy.get(SlotType.LARGE) < capacities.get(SlotType.LARGE))
                    allocated = SlotType.LARGE;
            }
            if(allocated == null)
            {
                refusedCount++;
                throw new NoSlotAvailableException();
            }
            DiscountScheme scheme;
            if(schemeStr.equals("STUDENT")) scheme = new StudentDiscount();
            else if(schemeStr.equals("WEEKEND")) scheme = new WeekendDiscount();
            else scheme = new NoneDiscount();
            registry.put(plate, new Vehicle(plate, type, allocated, scheme, currentTime));
            occupancy.put(allocated, occupancy.get(allocated) + 1);
        }
        public void advanceTime(int hours)
        {
            currentTime += hours;
            List<String> toEvict = new ArrayList<>();
            for(Vehicle v : registry.values())
            {
                if((currentTime - v.getEntryTime()) >= maxStay)
                {
                    toEvict.add(v.getLicensePlate());
                }
            }
            for(String plate : toEvict)
            {
                Vehicle v = registry.get(plate);
                int baseBill = calculateBaseFee(v, maxStay);
                int removalHours = (maxStay + 9) / 10;
                int removalCharge = removalHours * getFurtherHourRate(v.getParkedSlot());
                int finalBill = v.getDiscount().applyDiscount(baseBill + removalCharge);
                if(finalBill < 0) finalBill = 0;
                totalEarned += finalBill;
                occupancy.put(v.getParkedSlot(), occupancy.get(v.getParkedSlot()) - 1);
                registry.remove(plate);
            }
        }
        private int calculateBaseFee(Vehicle v, int hours)
        {
            if(hours == 0) hours = 1;
            int first = 0, further = 0, surcharge = 0;
            switch(v.getParkedSlot())
            {
                case BIKE ->
                {
                    first = 10;
                    further = 5;
                    surcharge = 0;
                }
                case REGULAR ->
                {
                    first = 30;
                    further = 20;
                    surcharge = 15;
                }
                case LARGE ->
                {
                    first = 50;
                    further = 40;
                    surcharge = 25;
                }
            }

            int total = first + (hours - 1) * further;
            boolean hasSurcharge = (v.getVehicleType().equals("BIKE") && v.getParkedSlot() != SlotType.BIKE) ||
                    (v.getVehicleType().equals("CAR") && v.getParkedSlot() != SlotType.REGULAR);
            if(hasSurcharge)
            {
                total += surcharge;
            }
            return total;
        }

        private int getFurtherHourRate(SlotType slot)
        {
            return (slot == SlotType.BIKE) ? 5 : (slot == SlotType.REGULAR) ? 20 : 40;
        }

        public void querySlot(String plate)
        {
            System.out.println(registry.containsKey(plate) ? registry.get(plate).getParkedSlot() : "NONE");
        }

        public void printFree(String type)
        {
            SlotType slot = SlotType.valueOf(type.toUpperCase());
            System.out.println(capacities.get(slot) - occupancy.get(slot));
        }

        public void printCount()
        {
            System.out.println(registry.size());
        }

        public void printRefused()
        {
            System.out.println(refusedCount);
        }

        public void queryBill(String plate)
        {
            if(!registry.containsKey(plate))
            {
                System.out.println("NONE"); return;
            }
            Vehicle v = registry.get(plate);
            int hours = currentTime - v.getEntryTime();
            System.out.println(v.getDiscount().applyDiscount(calculateBaseFee(v, hours)));
        }

        public void leaveVehicle(String plate) throws VehicleNotFoundException
        {
            if(!registry.containsKey(plate))
            {
                refusedCount++;
                throw new VehicleNotFoundException();
            }
            Vehicle v = registry.get(plate);
            int hours = currentTime - v.getEntryTime();
            int finalBill = v.getDiscount().applyDiscount(calculateBaseFee(v, hours));
            if(finalBill < 0) finalBill = 0;
            totalEarned += finalBill;
            occupancy.put(v.getParkedSlot(), occupancy.get(v.getParkedSlot()) - 1);
            registry.remove(plate);
        }
        public void printEarned()
        {
            System.out.println(totalEarned);
        }
    }

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ParkingLot system = new ParkingLot();
        while(input.hasNextLine())
        {
            String line = input.nextLine().trim();
            if(line.isEmpty())
            {
                continue;
            }
            String[] field = line.split(" ");
            String command = field[0].toUpperCase();
            if(command.equals("END"))
            {
                break;
            }
            try
            {
                switch (command)
                {
                    case "SLOTS" ->
                            system.initSlots(Integer.parseInt(field[1]), Integer.parseInt(field[2]), Integer.parseInt(field[3]));
                    case "MAXSTAY" ->
                            system.setMaxStay(Integer.parseInt(field[1]));
                    case "PASSTIME" ->
                            system.advanceTime(Integer.parseInt(field[1]));
                    case "SLOT" ->
                            system.querySlot(field[1]);
                    case "FREE" ->
                            system.printFree(field[1]);
                    case "COUNT" ->
                            system.printCount();
                    case "REFUSED" ->
                            system.printRefused();
                    case "BILL" ->
                            system.queryBill(field[1]);
                    case "LEAVE" ->
                            system.leaveVehicle(field[1]);
                    case "EARNED" ->
                            system.printEarned();
                    case "BIKE", "CAR", "TRUCK" ->
                    {
                        String plate = field[1];
                        String scheme = field[2];
                        system.parkVehicle(command, plate, scheme);
                    }
                    default ->
                    {
                    }
                }
            }
            catch(Exception e)
            {
            }
        }
        input.close();
    }
}
