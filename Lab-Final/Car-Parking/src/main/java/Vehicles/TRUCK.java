package Vehicles;
import Slots.*;
import Refusals.NoSpaceAvailableException;

import static Records.slotCount.*;

public class TRUCK implements Discountable{
    String numPlate;
    String scheme;
    Large slot;
    public TRUCK(String numPlate,String scheme,Large slot){
        this.numPlate=numPlate;
        this.scheme=scheme;
        this.slot=slot;
    }


    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
