class Main{
    public static void main(String args[]){
        for (String arg : args){
            switch (arg){
                case "1":
                    System.out.println("Problem 1 :");
                    ComplexList C = new ComplexList(10);
                    C.setElement(2, new Complex(1,4));
                    C.setElement(4, new Complex(3,4));
                    System.out.println(C);
                    System.out.println("Total : " + C.calculateTotal());
                    break;
                case "2":
                    System.out.println("Problem 2 :");
                    PolynomialList P = new PolynomialList(10);
                    P.setElement(2, new Polynomial(1, 4, 2));
                    P.setElement(4, new Polynomial(3, 4, 5));
                    System.out.println(P);
                    System.out.println("Total : " + P.calculateTotal());
                case "3":
                    System.out.println("Problem 3 :");
                    Polygon Poly = new Polygon(4);
                    Poly.setPoint(2, new Point(0, 0));
                    Poly.setPoint(4, new Point(0, 1));
                    Poly.setPoint(4, new Point(1, 1));
                    Poly.setPoint(4, new Point(1, 0));
                    System.out.println(Poly);
                    System.out.println("Circumference : " + Poly.calculateCircumference());
                case "4":
                    System.out.println("Problem 3 :");
                    Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 1));
                    System.out.println(triangle);
                    System.out.println("Circumference : " + triangle.calculateCircumference());
                    System.out.println("Area : " + triangle.calculateArea());
            }
        }
    }
}