public abstract Class Connection
        {

            private Meter meter;
            private static final double FUEL_DEFAULT = 0.10;
            private static final double TAX_RATE = 0.05;


            private Connection (Meter meter)
            {
                this.meter=meter;

            }
            public abstract double energyCharge();
            public abstract double fixedCharge();

            public double fuelSurcharge()
            {
                return energyCharge()*FUEL_DEFAULT;
            }
            public double tax()
            {
                return (energyCharge() + fixedCharge() + fuelSurcharge())*TAX_RATE;
            }

                }

