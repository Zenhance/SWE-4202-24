public class AgentWallet extends Wallet{
    private static final double DAILY_LIMIT=200000.0;
    public AgentWallet(String id, double balance,String pin){
        super(id,balance,pin);
    }
    @Override
    public double getDailyLimit(){
        return DAILY_LIMIT;
    }

    @Override
    public void validateOperation(String transactionType)
        throws OperationNotAllowedException{

        }
}
