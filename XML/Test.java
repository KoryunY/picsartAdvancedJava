package XML;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        Employee employee=new Employee(177,"Vazgen","Margaryan","Russia");
        Employee employe2=new Employee(19,"Arto","Tavryan","Armenia");
        Employee employe3=new Employee(19,"John","Black","Germany");
        employees.add(employee);
        employees.add(employe2);
        employees.add(employe3);
        EmployeeService.serializeXml(employees);
        List<Employee> emp=EmployeeService.deSerializeXml();
        System.out.println(emp);
    }
}
