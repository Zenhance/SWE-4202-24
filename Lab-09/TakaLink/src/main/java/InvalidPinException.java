
public class InvalidPinException extends TransactionException {

        public InvalidPinException(Wallet fromId) {
            super("Wrong PIN offered for wallet " + fromId.getId());
        }
    }


