import java.util.ArrayList;

class PolynomialList{
    private ArrayList<Polynomial> PList;

    PolynomialList(int length){
        this.PList  = new ArrayList(length);
        for(int i = 0; i < length; i++){
            PList.add(new Polynomial(0,0,0));
        }
    }

    public void setElement(int index, Polynomial element){
        PList.add(index, element);
    }
    public Polynomial getElement(int index){
        return PList.get(index);
    }

    public Polynomial calculateTotal(){
        Polynomial sum = new Polynomial(0,0,0);
        for (Polynomial c : PList){
            sum = sum.add(c);
        }
        return sum;
    }

     @Override
    public String toString() {
        String s = "[ ";
        for (Polynomial each : PList){
            s = s + each + ",\n";
        }
        s = s + "]";
        return s;
    }
}