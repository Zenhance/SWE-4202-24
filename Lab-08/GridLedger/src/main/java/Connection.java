public abstract class Connection {
     protected Meter meter;
     protected double fualPercentage = 0.1;
     protected static final double TAX_RATE = 0.05;

     public Connection(Meter meter) {
         this.meter = meter;
     }
            public abstract double energyCharge();
            public abstract double fixedCharge ();

            public double fuelSurcharge () {
                return energyCharge()+ fualPercentage;
          }

            public double tax () {
                return (energyCharge()+ fualPercentage)*TAX_RATE;
        }
            public double total () {
                return energyCharge()+ fixedCharge() + fuelSurcharge() + tax();
             }
        }
