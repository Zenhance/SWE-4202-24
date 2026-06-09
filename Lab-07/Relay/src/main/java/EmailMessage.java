public class EmailMessage extends Notice{
    public EmailMessage(Recipient r, String body) {
        super(r,body);
    }

    @Override
    public double cost(){
        return 0.0;
    }

    @Override
    public String deliver(){
        return String.format(r.getName()+" "+r.getAddress()+" "+body);
    }

    @Override
    public String describe(){
        return "EMAIL is free";
    }
}
