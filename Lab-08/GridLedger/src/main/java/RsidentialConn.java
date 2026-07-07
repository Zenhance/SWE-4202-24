public class RsidentialConn extends Connection{
    public RsidentialConn(double units){
        this.energy=units;
        this.fixed= 100;
        this.fuelPet = 0.05;
        this.taxPet=0.10;

        @Override
        public double energyCharge(){
            if(energy<=50) {return energy =3;}
            else if (energy<=100) {
                return 50*3 + (energy-50)*5;

            }
            else {
                return 50*3 + 50*5 + (energy-100)*7;
            }
        }

        @Override
                public double fixedCharge(){
            return fixed;
        }


    }
}
