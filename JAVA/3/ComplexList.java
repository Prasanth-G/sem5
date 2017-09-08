import java.util.ArrayList;

public class ComplexList{
    private ArrayList<Complex> CList;

    ComplexList(int length){
        this.CList  = new ArrayList<Complex>(length);
        for(int i = 0; i < length; i++){
            CList.add(new Complex(0,0));
        }
    }

    public void setElement(int index, Complex element){
        CList.add(index, element);
    }
    public Complex getElement(int index){
        return CList.get(index);
    }

    public Complex calculateTotal(){
        Complex sum = new Complex(0,0);
        for (Complex c : CList){
            sum.add(c);
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (Complex each : CList){
            s = s + each + ",\n";
        }
        s = s + "]";
        return s;
    }
}