public class PersonalWallet extends Wallet{
    public PersonalWallet(String id,double openingBalance , String pin) {
        super(id,openingBalance, pin);
    }
    @Override
    public double dailylimit() {
        return 25_000.0;
    }
    @override
    public boolean canPerform(String operation){
        return true;
    }
}
