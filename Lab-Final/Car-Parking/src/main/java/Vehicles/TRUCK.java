package Vehicles;
import Slots.*;
import Refusals.NoSpaceAvailableException;
import static Records.slotCount.Count;
import static Records.slotCount.RefuseCount;

public class TRUCK implements Discountable{
    String numPlate;
    String scheme;
    public TRUCK(String numPlate,String scheme){
        this.numPlate=numPlate;
        this.scheme=scheme;
    }
    if(){
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
