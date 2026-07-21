public abstract class Shape {

    protected double height;
    protected double width;
    public Shape(double height, double width){
        if(height <= 0.0 || width  <= 0.0)
            throw new ShapeException("Invalid size!");
        this.height = height;
        this.width = width;
    }

    public abstract int area();

    public String describe(){
        return "Area: "+area();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}


