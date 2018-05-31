package SpringMVCStart.service;

import SpringMVCStart.entity.Employee;
import SpringMVCStart.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;
    public EmployeeServiceImpl(){

    }
    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Employee findOne(String id) {
        return this.repository.findOne(id);
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee update(String id, Employee employee) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
