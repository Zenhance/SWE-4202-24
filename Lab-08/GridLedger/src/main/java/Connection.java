public abstract class Connection {
     protected Meter meter;
     protected double fuelPercentage = 0.1;
     protected static final double TAX_RATE = 0.05;

     public Connection(Meter meter) {
         this.meter = meter;
     }
            public abstract double energyCharge();
            public abstract double fixedCharge ();

            public double fuelSurcharge () {
                return energyCharge()+ fuelPercentage;
          }

            public double tax () {
                return (energyCharge()+ fuelPercentage)*TAX_RATE;
        }
            public double total () {
                return energyCharge()+ fixedCharge() + fuelSurcharge() + tax();
             }

             public void setFuelSurcharge(double fuelPercentage) {
                this.fuelPercentage = fuelPercentage;
             }

             public Meter getMeter() {
                return meter;
             }
        }
