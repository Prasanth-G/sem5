import java.util.ArrayList;
class Polygon{
    private ArrayList<Point> points;
    Polygon(int pointcount){
        points = new ArrayList<Point>(pointcount);
        Point point = new Point(0,0);
        for(int i=0; i< pointcount; i++){
            points.add(point);
        }
    }

    public void setPoint(int index, Point element){
        points.add(index, element);
    }
    public Point getPoint(int index){
        return points.get(index);
    }
    public double calculateCircumference(){
        double sum = 0;
        Point prev = points.get(0);
        for(int i=1;i < points.size(); i++){
            sum += prev.distanceFrom(points.get(i));
            prev = points.get(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "[";
        for(Point p : points){
            s += p + "\n";
        }
        return s;
    }
}