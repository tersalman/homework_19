import Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    private static final int MAX_COUNT_OF_EMPLOYEE = 10;

    List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        if (employeeList.size() >= MAX_COUNT_OF_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("the storage is full");
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i) == null) {
                Employee employee = new Employee(firstName, lastName);
                employeeList.add(employee);
            }
        }
    }

    public void deleteEmployee(Employee employee) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.contains(employee)) ;
            employeeList.remove(employeeList.get(i));
        }

    }

    public void checkEmployee(Employee employee1) {
        if (employeeList.contains(employee1)) {
            System.out.println(employee1);

        } else {
            System.out.println("that's employee was not found");
        }
    }
}
