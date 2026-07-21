public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle (int width, int height){
       this.width=width;
       this.height=height;
    }

    private void validate(double value,String name){
        if(value<=0){
            throw new IllegalArgumentException("Rectangle"+name+"must be positve");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area(){
        return width*height;
    }

    public String describe(){
        return null;
    }
}
