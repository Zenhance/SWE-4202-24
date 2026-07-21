public class Circle extends Shape {
    double radius;
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String describe() {
        return "This is a Circle with radius " + radius+"And Area"+this.area();
    }

    public Circle(double i){
        super();
        try {radius=i;}
        catch(Exception e) {
            if(e instanceof IllegalArgumentException)
            {
                System.out.println("Invalid shape");
            }
            if(e instanceof CheckedExceptions)
            {
                System.out.println("this shape cannot be drawn right now");
            }


    }
}}
