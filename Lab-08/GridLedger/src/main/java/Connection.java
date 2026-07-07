public abstract class Connection {
    protected Meter meter;
    protected double fuelRate=0.0;


    Connection(Meter meter) {
        if(meter==null){
            throw new IllegalArgumentException("Meter is null");
        }
        this.meter=meter;
    }
  void  setFuelRate(double fuelRate) {
        this.fuelRate=fuelRate;
  }

    abstract double energyCharge();
    abstract double fixedCharge();


    double fuelSurcharge() {
        return energyCharge()*fuelRate/100;
    }

    double tax(){
        double subtotal= energyCharge() + fixedCharge() + fuelSurcharge();
        return subtotal*0.05;
    }

    double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();


    }


}
