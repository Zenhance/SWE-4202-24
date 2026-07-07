public class Connection {
    private String customerType;
            private boolean subsided;
            public Connection (String customerType){
                this.customerType=customerType;
                        this.subsided=false;
            }
            public String getCustomerType(){
                return customerType;
            }
            public void setCustomerType(String customerType){
                this.customerType=customerType;
            }
            public boolean isSubsided(){
                return subsided;
            }
            public void setSubsided(boolean subsided){
                this.subsided=subsided;
            }
            public double getFixedCharge(){
                switch (customerType){
                    case "RESIDENTIAL":
                        return 100.0;
                    case "INDUSTRIAL":
                        return 2000.0;
                    case "COMMERCIAL":
                        return  500.0;
                    default:
                        return 0.0;
                }
            }
}
