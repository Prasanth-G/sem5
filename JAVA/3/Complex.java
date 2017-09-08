public class Complex{
    private int real;
    private int imaginary;
    
    Complex(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(int real){
        this.real = real;
    }
    public void setImaginary(int imaginary){
        this.imaginary = imaginary;
    }

    public int getReal(){
        return this.real;
    }
    public int getImaginary(){
        return this.imaginary;
    }

    public Complex add(Complex c){
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    Complex subtract(Complex c){
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    Complex multiply(Complex c){
        return new Complex(real * c.real - imaginary * c.imaginary, real * c.imaginary + imaginary * c.real);
    }

    @Override
    public String toString() {
        return "" + real + " + i" + imaginary;
    }
}