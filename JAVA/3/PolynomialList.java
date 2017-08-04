import java.util.ArrayList;

class PolynomialList{
    private ArrayList<Polynomial> PList;

    PolynomialList(int length){
        this.PList  = new ArrayList(length);
    }

    void setElement(int index, Polynomial element){
        PList.add(index, element);
    }
    Polynomial getElement(int index){
        return PList.get(index);
    }

    Polynomial calculateTotal(){
        Polynomial sum = new Polynomial(0,0);
        for (Polynomial c : PList){
            sum.add(c);
        }
        return sum;
    }
}