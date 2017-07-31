/**
 *
 * @author 15pt25
 */
 import java.math.*;
class Circle{
    private int radius;

    Circle(int radius){
        this.radius = radius;
    }
    void setRadius(int radius){
        this.radius = radius;
    }
    int getRadius(){
        return this.radius;
    }

    double calculateArea(){
        return Math.PI*radius*radius;
    }
    double calculateCircumference(){
        return 2*Math.PI*radius;
    }

    public static void main(String args[]){
        Circle c1 = new Circle(7);
        System.out.println("Area :\t"+c1.calculateArea());
        System.out.println("Circumference : "+c1.calculateCircumference());
    }
}