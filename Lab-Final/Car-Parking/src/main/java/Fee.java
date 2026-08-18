import java.util.Objects;

import static java.lang.Math.max;

public class Fee {
    int[] hour1 ={10,30,50};
    int[] further={5,20,40};
    int[] sur={0,15,25};
    public int Calcfee(Vehicles vehicle) {
        int fee=0;
        if (vehicle.slot.equals("BIKE")) {
            fee = hour1[0] + max(0,further[0] * (vehicle.time - 1)) + sur[0];
        } else if (Objects.equals(vehicle.slot, "REGULAR")) {
            fee = hour1[1] + max(0,further[1] * (vehicle.time - 1)) + sur[1];
        } else if (vehicle.slot.equals("LARGE")) {
            fee = hour1[2] + max(0,further[2] * (vehicle.time - 1))+ sur[2];
        }
        if (vehicle.scheme.equals("STUDENT")) {
            fee = fee - fee * 2;
        } else if (vehicle.scheme.equals("WEEKEND")) {
            fee = max(0, fee - 10);
        }
        return fee;
    }
}

