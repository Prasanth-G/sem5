public class Complex{
    private int real;
    private int imaginary;
    
    Complex(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    void setReal(int real){
        this.real = real;
    }
    void setImaginary(int imaginary){
        this.imaginary = imaginary;
    }

    int getReal(){
        return this.real;
    }
    int getImaginary(){
        return this.imaginary;
    }

    Complex add(Complex c){
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    Complex subtract(Complex c){
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    Complex multiply(Complex c){
        return new Complex(real * c.real - imaginary * c.imaginary, real * c.imaginary + imaginary * c.real);
    }

}