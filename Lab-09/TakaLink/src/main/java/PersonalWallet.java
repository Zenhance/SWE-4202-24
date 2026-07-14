public final class  PersonalWallet extends Wallet {
    private static  final  double DAILY_LIMIT=25000.00;

    public PersonalWallet(String id,double openingBalance,String pin) {
        super(id,openingBalance,pin);
    }
    @override

    public double dailyLimit(){
        return DAILY_LIMIT;
    }

    @override
    public boolean allows(Operation operation){
        return operation !=null;
        
    }
}