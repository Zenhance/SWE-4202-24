package Vehicles;
import Records.slotCount;
import Refusals.NoSpaceAvailableException;
import Slots.*;

import static Records.slotCount.*;

public class BIKE implements Discountable{
    String numPlate;
    String scheme;
    Regular regularslot;
    Bike bikeslot;
    Large largeslot;
    public BIKE(String numPlate,String scheme,Bike slot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.bikeslot=slot;
    }
    public BIKE(String numPlate,String scheme,Regular slot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.regularslot=slot;
    }
    public BIKE(String numPlate,String scheme,Large slot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.largeslot=slot;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
