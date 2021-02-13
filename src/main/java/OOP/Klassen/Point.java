package OOP.Klassen;

import java.util.Objects;

public class Point {

    public static final int QUADRANT_0 = 0;
    public static final int QUADRANT_1 = 1;
    public static final int QUADRANT_2 = 2;
    public static final int QUADRANT_3 = 3;
    public static final int QUADRANT_4 = 4;

    private int x;
    private int y;

    /**
     * Konstruktor der Pointklasse.
     *
     * @param x
     * @param y
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy-Konstruktor, der einen bestehenden Punkt kopiert.
     *
     * @param point
     */
    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    @Override
    public String toString() {
        return "Point(" + x + "/" + y + ")";
    }

    @Override
    public final boolean equals(final Object object){
        if(object == this){
            return true;
        }
        if(!(object instanceof Point)){
            return false;
        }
        final Point other = (Point) object;
        return(this.x==other.x) && (this.y==other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }


    public int bestimmeQuadrant() { // sobald ein Punkt auf einer Achse oder sogar auf beiden liegt, ist er im Quadrant 0
        int quadrant = QUADRANT_0;
        if (x != 0 && y != 0) {
            if (x >= 0) {
                if (y >= 0) {
                    quadrant = QUADRANT_1;
                } else {
                    quadrant = QUADRANT_4;
                }
            } else if (y >= 0) {
                quadrant = QUADRANT_2;
            } else {
                quadrant = QUADRANT_3;
            }
        }
        return quadrant;
    }

    public void moveRelative(final int moveX, final int moveY) {
        this.x = +moveX;
        this.y = +moveY;
    }

    public void moveRelative(Point moveVector) {
        this.x = +moveVector.getX();
        this.y = +moveVector.getY();
    }

    public void moveRelative(final double moveWinkel, final int moveBetrag) {
        this.x = +(int) Math.cos(Math.toRadians(moveWinkel)) * moveBetrag;
        this.y = +(int) Math.sin(Math.toRadians(moveWinkel)) * moveBetrag;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
