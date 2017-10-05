import Employee.*;

class Main{
    public static void main(String[] args){
        Employee e = new Employee("15pt03", "agalya", "E-Block");
        try{
            EmployeeWriter.write(e, "outputFile.ser");
        }catch(Exception err){}
        
        System.out.println("Written to file");
        try{
            System.out.println(EmployeeReader.read("outputFile.ser"));
        }catch(Exception err){}
    }
}