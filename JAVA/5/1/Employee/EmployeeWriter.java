package Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EmployeeWriter {

    public static void write(Employee e, String filename) throws Exception{
        FileOutputStream fileout;
        File file = new File(filename);
        file.createNewFile();
        fileout = new FileOutputStream(filename);
        ObjectOutputStream objout = new ObjectOutputStream(fileout);
        objout.writeObject(e);
        objout.close();
        fileout.close();
    }
}
