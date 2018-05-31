package SpringMVCStart.repository;

import SpringMVCStart.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
}
