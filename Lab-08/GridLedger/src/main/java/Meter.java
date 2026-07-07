public class Meter {

    private int openingReading;
    private int closingReading;

    public Meter(int openingReading , int closingReading){

        if(openingReading < 0) {
            throw new IllegalArgumentException("Opening reading can't be negative");
        }

        if(openingReading > closingReading){
            throw new IllegalArgumentException("closingReading can't be less than openingReading");
        }


        this.closingReading = closingReading;
        this.openingReading = openingReading;




    }
}


