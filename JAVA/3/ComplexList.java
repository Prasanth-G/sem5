import java.util.ArrayList;

public class ComplexList{
    private ArrayList<Complex> CList;

    ComplexList(int length){
        this.CList  = new ArrayList(length);
    }

    void setElement(int index, Complex element){
        CList.add(index, element);
    }
    Complex getElement(int index){
        return CList.get(index);
    }

    Complex calculateTotal(){
        Complex sum = new Complex(0,0);
        for (Complex c : CList){
            sum.add(c);
        }
        return sum;
    }
}