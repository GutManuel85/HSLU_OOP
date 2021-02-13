package OOP.Klassen;

public class Square extends Shape{

    private int sideLength;

    public Square(int x, int y, int sideLength){
        super(x,y);
        this.sideLength = sideLength;
    }

    @Override
    public int getPerimeter(){
       return 4*sideLength;
    }

@Override
    public int getArea(){
        return (int) Math.pow(sideLength, 2);
    }
}
