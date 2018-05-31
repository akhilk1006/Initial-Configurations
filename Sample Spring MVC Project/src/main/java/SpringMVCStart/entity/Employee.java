package SpringMVCStart.entity;

import java.util.UUID;

public class Employee {
    private String id;
    private String name;
    private int salary;
    public Employee(){}

    public Employee(String name, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
