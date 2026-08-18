public  class Connection {
    private static final double fuelpercent=0.10;
    private static final double taxpercent=0.05;
    private Meter meter;
    public Connection(Meter meter){
        this.meter=meter;
    }

     public Meter getMeter(){
        return meter;
     }


    public double energyCharge(){
        return 0.7;
    };
    public  double fixedCharge(){
        return 5.0;
    };
    public double fuelSurcharge(){
        return energyCharge()* Connection.fuelpercent;}
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*taxpercent;
    }
    public double sum(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }


    public double total() {
        return 8.0;
    }
}
