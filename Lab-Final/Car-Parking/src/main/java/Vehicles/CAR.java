package Vehicles;
import Refusals.NoSpaceAvailableException;
import Slots.*;

import static Records.slotCount.Count;
import static Records.slotCount.RefuseCount;

public class CAR implements Discountable{
    String numPlate;
    String scheme;
    public CAR(String numPlate,String scheme){
        this.numPlate=numPlate;
        this.scheme=scheme;
    }
    if(){
        Regular slot=new Regular(numPlate);
        Count();
    }
    else if(){
        Large slot=new Large(numPlate);
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
