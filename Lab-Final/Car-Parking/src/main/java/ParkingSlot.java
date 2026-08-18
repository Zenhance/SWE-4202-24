public class ParkingSlot {
    private String type;
    private Vehicle vehicles;

    public ParkingSlot(String type){
        this.type=type;
        this.vehicles = vehicles;

    }

    public String getType(){
        return type;
    }

    public boolean isFree(){
        return vehicles ==null;
    }

    public void park(Vehicle vehicle){
        this.vehicles =vehicle;
    }

    public void makeFree(){
        this.vehicles =null;
    }

    public int getFirstHourPrice(){
        if(type.equals("BIKE")){
            return 10;
        }
        else if(type.equals("REGULAR")){
            return 30;
        }
        else{return 50;}
    }

    public int getNextHourPrice(){
        if(type.equals("BIKE")){
            return 5;
        }
        else if(type.equals(("REGULAR"))){
            return 20;
        }
        else{return 40;}
    }
    public int getSurcharge(){
        if(type.equals("BIKE")){
            return 0;
        }
        else if(type.equals("REGULAR")){
            return 15;
        }
        else{return 25;}
    }
}
