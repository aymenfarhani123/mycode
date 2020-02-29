import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByEmail(String email);
    List<Employee> getEmployeeFilteredByAge(int age);
}
