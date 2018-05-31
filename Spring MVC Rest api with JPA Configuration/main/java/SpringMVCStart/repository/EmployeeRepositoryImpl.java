package SpringMVCStart.repository;

import SpringMVCStart.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return Arrays.asList(new Employee("akhil", 10000),
                new Employee("praveen", 1000000),
                new Employee("Jsmith", 134000));
    }

    @Override
    public Employee findOne(String id) {
        return null;
    }

    @Transactional
    @Override
    public Employee create(Employee employee) {
        entityManager.persist(employee);
        return entityManager.find(Employee.class, employee.getId());
    }
}
