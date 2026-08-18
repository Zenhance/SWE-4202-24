public  class Slot {
    private final slottype type;
    private vehicles vehicle;

    public Slot(slottype type) {
        this.type = type;
    }

    public slottype getType() {
        return this.type;
    }

    public vehicles getVehicle() {
        return this.vehicle;
    }
    public void setVehicle(vehicles vehicle) {
         this.vehicle=vehicle;
    }
    public boolean isFree(){
        return vehicle ==null;
    }
    public void park(vehicles vehicle){
        this.vehicle=vehicle;
    }
    public void remove(vehicles vehicle){
        this.vehicle=null;
    }


}
