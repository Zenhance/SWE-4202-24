package kenakata.exception;

public class AlreadyReturnedException {
    public AlreadyReturnedException(String label){
        super("Line has already been returned: "+label);
    }
}
