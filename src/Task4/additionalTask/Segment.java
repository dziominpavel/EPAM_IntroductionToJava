package Task4.additionalTask;

public class Segment {
    private Point pointOne;
    private Point pointTwo;
    private double lenght;

    public Segment() {
    }

    public Segment(Point pointOne, Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.lenght = Math.sqrt(Math.abs(Math.pow((pointOne.getX() - pointTwo.getX()), 2)
                - Math.pow((pointOne.getY() - pointTwo.getY()), 2)));
    }

    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
}
