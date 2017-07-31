/**
 *
 * @author 15pt25
 */
 class Square{
    private int side;

    Square(int side){
        this.side = side;
    }
    void setSide(int side){
        this.side = side;
    }
    int getSide(){
        return this.side;
    }

    int calculateArea(){
        return side*side;
    }

    int calculateCircumference(){
        return 4 * side;
    }

    public static void main(String args[]){
        Square s1 = new Square(7);
        System.out.println("Area : "+s1.calculateArea());
        System.out.println("Circumferenece : "+s1.calculateCircumference());
    }
}