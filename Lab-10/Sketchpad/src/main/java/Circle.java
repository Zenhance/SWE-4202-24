public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Invalid radius");
            this.radius=radius;
        }
        @Override
                public double area(){
            return Math.PI*radius*radius;
        }
        @Override
                public String description(){
            return "Circle (radius= " + radius + ")";
        }

        @Override
                public void draw(Canvas canvas){
            throws ShapeException{
                if(radius<0.5) throw new ShapeTooSmallException
                    ("Circle too small");
            }

            canvas.drawCircle(radius);
        }
    }
}
