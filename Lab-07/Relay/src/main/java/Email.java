public class Email extends Message{

    public Email(Recipient recipient,String bodytext){
        super(recipient,bodytext);
    }


    public String deliver(){
        return "EMAIL IS SENT TO"+recipient.getName()+"ADDRESS"+recipient.getAddress()+bodytext;

    }

    public double cost(){


    }

    public String describe(){


    }
}