public abstract class Square extends Rectangle{

    public Square(double width){

        super(width,width);
    }

    @Override
    public void setWidth(double width){
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public String describe(){
        return String.format("Square(%.2f, %.2f)", getWidth(), getHeight());
    }


    }


}
