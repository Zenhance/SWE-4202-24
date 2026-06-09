public class Email extends Notice{
    public Email(Recipent recipent ,String text){
        super(recipent,text);
    }
    @Override
    public String deliver(){
        return "To: " + recipent.getName() + " (" + recipent.getAdrress() +" )" +test;
    }
    @Override
    public double price(){
        return 0.0;
    }
    @Override
    public String describe(){
        return "Email to "+recipent.getName();
    }

}