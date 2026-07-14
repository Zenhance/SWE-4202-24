public class PersonalWallet extends Wallet{
    private static final double DAILY_LIMIT=25000;
    public PersonalWallet(String id, double balance, String pin){
        super(id,balance,pin);
    }
    @Override
    public double getDailyLimit(){
        return DAILY_LIMIT;
    }
    @Override
    public void validateOperation(String transactionType){
        throws OperationNotAllowedException{

        }
    }
}
