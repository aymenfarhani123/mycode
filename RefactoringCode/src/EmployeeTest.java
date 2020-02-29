import static java.lang.System.*;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeService employeeService=new EmployeeService();
        List<Employee> employees=employeeService.getAllEmployee();
        out.println(employees.size());
        List<Employee> employeeByEmail=employeeService.getEmployeeByEmail("Java Teacher");
        out.println(employeeByEmail.size());
        List<Employee> getEmployeesByAge=employeeService.getEmployeeFilteredByAge(40);
        out.println(getEmployeesByAge.size());
        for(int i=0;i<employees.size();++i) {
            int streetNumber = employees.get(4).getAddresse().map(Addresse::getStreetNum).get();
            out.println(streetNumber);
        }
    }
}
