class Polynomial{
    private int a, b, c;
    Polynomial(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
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
    int getA(){
        return this.a;
    }
    int getB(){
        return this.b;
    }
    int getC(){
        return this.c;
    }

    Polynomial add(Polynomial p){
        return Polynomial(a + p.a, b + p.b, c + p.c);
    }
}