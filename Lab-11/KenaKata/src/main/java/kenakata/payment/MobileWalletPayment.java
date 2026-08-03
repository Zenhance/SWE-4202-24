package kenakata.payment;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.PaymentDeclinedException;



public class MobileWalletPayment implements PaymentMethod {
    private final Wallet wallet;

    public MobileWalletPayment(Wallet wallet){

        this.wallet=wallet;//depends on available wallet balance
    }
    @Override
    public void authorise(long amount) throws PaymentDeclinedException{
        if(wallet.balance()<amount){
            throw new EmptyWalletException("Wallet balance too low");
        }
        wallet.debit(amount);
    }

}
