package SpringMVCStart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private int salary;
    public Employee(){
        this.id = UUID.randomUUID().toString();
    }

    public Employee(String name, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
