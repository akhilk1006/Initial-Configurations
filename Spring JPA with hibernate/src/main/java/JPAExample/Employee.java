package JPAExample;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(indexes = {@Index(columnList = "name, email")})
@NamedQuery(name = "findByEmail", query = "SELECT emp FROM Employee emp WHERE emp.email=:email")
public class Employee {
    @Id
    private String id;

    @Column(unique = true)
    private String name;
    private  String email;

    public Employee() {
        this.id = UUID.randomUUID().toString();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
