package Vehicles;
import Refusals.NoSpaceAvailableException;
import Slots.*;

import static Records.slotCount.*;

public class CAR implements Discountable{
    String numPlate;
    String scheme;
    Regular regularSlot;
    Large largeSlot;
    public CAR(String numPlate,String scheme,Regular regularslot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.regularSlot=regularslot;
    }
    public CAR(String numPlate,String scheme,Large largeSlot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.regularSlot=regularSlot;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
