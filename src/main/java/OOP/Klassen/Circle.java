package OOP.Klassen;

public final class Circle extends Shape{

    private int diameter;

    public Circle(final int x, final int y, final int diameter){
        super(x, y);
        this.diameter = diameter;
    }

    public void setDiameter(int diameter){
        this.diameter = diameter;
    }

    public int getDiameter(){
        return diameter;
    }

    @Override
    public int getPerimeter() {
        return 2*(int)Math.PI*diameter;
    }

    @Override
    public int getArea() {
        return (int) Math.pow(Math.PI,2);
    }
}
