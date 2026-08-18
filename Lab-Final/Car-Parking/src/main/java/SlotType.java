public enum SlotType {
    BIKE(10,5,0),
    REGULAR(30,20,15),
Large(50,40,25)
    };
private final int firstHour;
private final int furtherHour;
private final int surcharge;
public SlotType(int firstHour,int furtherHour, int surcharge){
this.firstHour=firstHour;
this.furtherHour= furtherHour;
this.surcharge= surcharge;
}
public int getFirstHour(){
    return firstHour;
        }
public int getFurtherHour(){
    return firstHour;
}
public int getSurcharge(){
    return surcharge;
}

