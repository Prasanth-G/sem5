/**
 *
 * @author 15pt25
 */

import java.math.*;
class Triangle{
    private double side1;
    private double side2;
    private double side3;
    Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    void setSide1(double side1){
        this.side1 = side1;
    }

    void setSide2(double side2){
        this.side2 = side2;
    }
    void setSide3(double side3){
        this.side3 = side3;
    }
    double getSide1(){
        return this.side1;
    }

    double getSide2(){
        return this.side2;
    }
    double getSide3(){
        return this.side3;
    }
    double calculateArea(){
        double p = (side1 + side2 + side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    double calculateCircumference(){
        return side1 + side2 + side3;
    }

    public static void main(String args[]){
        Triangle t1 = new Triangle(17,31,33);
        System.out.println("Area :\t"+t1.calculateArea());
        System.out.println("Circumference :\t"+t1.calculateCircumference());
    }
}