package kenakata.exceptions;

public class CODLimitExceededException extends PaymentDeclinedException {
    public CODLimitExceededException(String message){
        super(message);
    }
}

// I guess I have to change the name of this class to CodCeilingExceededException
