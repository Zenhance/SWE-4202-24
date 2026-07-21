public abstract class Shape {

    private double height;
    private double width;
    public Shape(double height, double width){
        if(height <= 0.0 || width  <= 0.0)
            throw new ShapeException("Invalid size!");
        this.height = height;
        this.width = width;
    }

    public abstract double area();

    //public void paint(){}

    //public void draw(){}

    public String describe(){
        return "Height: "+height+", Width: "+width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
