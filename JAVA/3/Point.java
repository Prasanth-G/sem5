public class Point{
    private int x;
    private int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setx(int x){
        this.x = x;
    }
    public void sety(int y){
        this.y = y;
    }
    public int getx(){
        return this.x;
    }
    public int gety(){
        return this.y;
    }
    public double distanceFrom(Point p){
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    @Override
    public String toString() {
        return "( " + x + ", " + y +" )";
    }
}