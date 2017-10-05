package Employee;

import java.io.Serializable;

public class Employee implements Serializable{
    
    String empno, ename, address;
    
    public Employee(String empno, String ename, String address) {
        this.empno = empno;
        this.ename = ename;
        this.address = address;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ", ename=" + ename + ", address=" + address + '}';
    }
}
