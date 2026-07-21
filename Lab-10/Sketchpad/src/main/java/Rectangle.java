public class Rectangle extends Shape {
    double i,j;
    public Rectangle(double i, double j) {
        super();
        try {this.i=i;this.j=j;}
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
    }
        public double area() {
        return i*j;
    }

        public String describe() {
        return "This is a Rectangle with width and height " +i+j +"And Area"+this.area();
    }
}
