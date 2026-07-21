public class Square extends Rectangle{
    private double side;
    public Square(double side){
        super(side,side);

    }

    @Override
    public void resize(double newW, double newL){
        if(newW != newL){
            throw new IllegalArgumentException("A square must have equal sides, got " + newW +"x"+ newL);
        }
        super.resize(newW,newL);
    }
    public void resize(double newSide) {
        resize(newSide,newSide);
    }
    @Override
    public void setLength(double newL){
        side=newL;
    }
    public void setWidth(double newW){
        side= newW;
    }
    public String describe() {
        return String.format("Side %.2f , area= %.2f",side,area());
    }

    public void setWidth(int i) {
    }
}
