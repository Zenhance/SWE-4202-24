public abstract class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double width,double height){
        if(width<=0 || height<=0){
            throw new IllegalArgumentException( "Width and height must be greater than zero" );
        }
        this.width=width;
        this.height=height;
    }
    public void setWidth(double width){
        if(width<=0){throw new IllegalArgumentException("Width must be greater than zero");}
        this.width=width;
    }

    public void setHeight(double height){
        if(height<=0){throw new IllegalArgumentException("Height must be greater than zero");}
        this.height= height;
    }

    public double area(double width, double height){
        return width*height;
    }
    @Override
    public String describe(){
        return String.format("Rectangle:width=%0.1f,height=%0.1f",width,height);
    }
}


