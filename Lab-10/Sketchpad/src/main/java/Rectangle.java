public class Rectangle extends Shape{
    protected double width;
    protected double height;

    public Rectangle(double width, double height){
        if(width<=0 || height <=0){
            throw new IllegalArgumentException(String.format("Rectangle dimensions must be positive(got %.2fx5.2f", width, height));
        }
        this.width = width;
        this.height=height;

    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setWidth(double width){
        if(width <= 0){
            throw new IllegalArgumentException("Width must be positive(got " + width + ")");
        }

        this.width=width;
    }

    public void setHeight(double height){
        if(height <=0){
            throw new IllegalArgumentException("Height must be positive(got " + height + ")");
        }
        this.height=height;
    }

    @Override
    public double area(){
        return width*height;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException{
        checkFit(canvas);
        canvas.rectangle(width, height);
    }
}
