public class Circle extends Shape{
    private final double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Invalid radius");}
            this.radius=radius;
        }
        @Override
                public double area(){
            return Math.PI*radius*radius;
        }
        @Override
                public String describe(){
            return "Circle (radius= " + radius + ")";
        }

        @Override
                public void draw(Canvas canvas)
            throws ShapeException{
                if(radius<0.5) throw new ShapeTooSmallException
                    ("Circle too small");
          if(Math.PI*radius*radius>canvas.capacity()) throw new ShapeTooLargeException("Circle too large");

            canvas.circle(radius);
        }
    }

