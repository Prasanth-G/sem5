package Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class EmployeeReader {

    public static Employee read(String filename) throws Exception{
        FileInputStream filein;
        filein = new FileInputStream(filename);
        ObjectInputStream objin = new ObjectInputStream(filein);
        Employee e = (Employee) objin.readObject();
        objin.close();
        filein.close();
        return e;
    }
}
