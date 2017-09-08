class Polynomial{
    private int a, b, c;
    Polynomial(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }
    public void setC(int c){
        this.c = c;
    }
    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }
    public int getC(){
        return this.c;
    }

    Polynomial add(Polynomial p){
        return new Polynomial(a + p.a, b + p.b, c + p.c);
    }

    @Override
    public String toString() {
        return ""+a+"X^2 + " + b + "X + " + c ;
    }
}