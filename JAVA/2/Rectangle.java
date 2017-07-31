/**
 *
 * @author 15pt25
 */
import java.math.*;
class Rectangle{
    private int length;
    private int width;
    Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    void setlength(int length){
        this.length = length;
    }

    void setwidth(int width){
        this.width = width;
    }
    int getlength(){
        return this.length;
    }

    int getwidth(){
        return this.width;
    }

    int calculateArea(){
        return length*width;
    }
    int calculateCircumference(){
        return 2 * (length + width);
    }

    public static void main(String args[]){
        Rectangle r1 = new Rectangle(7, 9);
        System.out.println("Area :\t"+r1.calculateArea());
        System.out.println("Circumference :\t"+r1.calculateCircumference());
    }
}