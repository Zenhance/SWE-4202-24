public abstract class Squre extends Rectangle{
    public double side;
    public Squre(double side){
       super(side,side);
    }
    @Override
    public void setWidth(double side){
        super.setWidth(side);
    }

    public void setHeight(double side){
        super.setHeight(side);
    }
@Override
    public String describe(){
        return String.format("Squre(side=%0.1f),width");
}
}
