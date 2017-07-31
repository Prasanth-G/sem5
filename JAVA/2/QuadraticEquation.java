/**
 *
 * @author 15pt25
 */
 
import java.math.*;
class QuadraticEquation{
    private int a;
    private int b;
    private int c;
	QuadraticEquation(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
    int getA(){
        return a;
    }
    int getB(){
        return b;
    }
    int getC(){
        return c;
    }
    void setA(int a){
        this.a = a;
    }

    void setB(int b){
        this.b = b;
    }
    void setC(int c){
        this.c = c;
    }
	double getRoot1(){
		return (-b + Math.sqrt((b*b) - (4*a*c)))/2 * a;
		
	}
	double getRoot2(){
		return (-b - Math.sqrt((b*b) - (4*a*c)))/2 * a;
	}
	public static void main(String args[]){
        QuadraticEquation r1 = new QuadraticEquation(1, -5, 6);
        System.out.println("Root 1 : "+r1.getRoot1());
        System.out.println("Root 2 : "+r1.getRoot2());
    }
}