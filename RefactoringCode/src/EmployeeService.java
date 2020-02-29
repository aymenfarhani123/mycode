import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService implements EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> initEmployeeList() {
        Addresse addresse=new Addresse(11,"description");
        Employee e1 = new Employee("Aymen", "Farhani", 28, "Java Developer",addresse);
        Employee e2 = new Employee("Durga", "Hindi", 46, "Java Teacher",addresse);
        Employee e3 = new Employee("Spring", "Boot", 5, "Java Framework",addresse);
        Employee e4 = new Employee("David", "Villa", 40, "Football Player",addresse);
        Employee e5 = new Employee("Vinkat", "Subramaniam", 50, "Java Champian",addresse);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        return employees;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = initEmployeeList();
        return allEmployees;
    }

    @Override
    public List<Employee> getEmployeeByEmail(String email) {
        return employees.stream().filter(employee -> employee.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeFilteredByAge(int age) {
        return employees.stream().filter(employee -> employee.getAge() > age).collect(Collectors.toList());
    }
}
