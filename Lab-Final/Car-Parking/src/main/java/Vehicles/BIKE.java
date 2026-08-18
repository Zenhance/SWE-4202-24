package Vehicles;
import Refusals.NoPlateException;
import Refusals.NoSpaceAvailableException;
import Slots.*;
import Records.*;
import Slots.slotCount;

import static Records.slotCount.Count;
import static Records.slotCount.RefuseCount;

public class BIKE implements Discountable{
    String numPlate;
    String scheme;
    if(bikeCount()>0){
        Bike slot = new Bike();
        Count();
    }
    else if(regularCount()>0){
        Regular slot=new Regular();
        Count();
    }
    else if(largeCount()>0){
        Large slot=new Large();
        Count();
    }
    else{
        RefuseCount();
        throw new NoSpaceAvailableException("No Space is Availabe");

    }
    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
