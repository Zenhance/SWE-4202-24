public abstract class Connection {
    private Meter meter;

    public Connection(Meter meter){
        this.meter=meter;
    }

    public int energyCharge(){
        return 0;
    }
    public int fixedCharge(){
      return 0;
    }
    public int fuelSurcharge(){
        return 0;
    }
    public int tax(){
        return 0;
    }

}
