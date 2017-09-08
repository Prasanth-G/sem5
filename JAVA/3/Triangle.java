class Triangle extends Polygon{
    Triangle(Point P1, Point P2, Point P3){
        super(3);
        this.setPoint(0, P1);
        this.setPoint(1, P2);
        this.setPoint(2, P3);
    }
    public void setP1(Point element){
        this.setPoint(0, element);
    }
    public void setP2(Point element){
        this.setPoint(1, element);
    }
    public void setP3(Point element){
        this.setPoint(2, element);
    }

    public double calculateCircumference(){
        Point p1 = this.getPoint(0);
        Point p2 = this.getPoint(1);
        Point p3 = this.getPoint(2);
        double s1 = p1.distanceFrom(p2);
        double s2 = p2.distanceFrom(p3);
        double s3 = p3.distanceFrom(p4);
        return s1 + s2 + s3;
    }

    public double calculateArea(){
        double s1 = this.getPoint(0).distanceFrom(this.getPoint(1));
        double s2 = this.getPoint(1).distanceFrom(this.getPoint(2));
        double s3 = this.getPoint(2).distanceFrom(this.getPoint(0));
        double p = (s1 + s2 + s3)/2;
        return Math.sqrt(p*(p - s1)*(p-s2)*(p-s3));
    }

}