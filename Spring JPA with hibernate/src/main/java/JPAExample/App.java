package JPAExample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistance-jpa");
        EntityManager em = emf.createEntityManager();

        //Insertion into Database

        Employee emp = new Employee();
        emp.setEmail("apara2232@villanova2.edu");
        emp.setName("akhilpara");
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        // Find by id in Database

         Employee emp = em.find(Employee.class, "0488b2f5-07f7-4f51-92e3-c081f763cd33");
         System.out.println(emp);

        //Update entry in Database

            Employee emp = em.find(Employee.class, "0488b2f5-07f7-4f51-92e3-c081f763cd33");
            emp.setName("Ellison");
            em.getTransaction().begin();
            em.merge(emp);
            em.getTransaction().commit();

        //Delete entry in Database

            Employee emp = em.find(Employee.class, "0488b2f5-07f7-4f51-92e3-c081f763cd33");
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();

        //creating custom queries

              TypedQuery<Employee> query = em.createNamedQuery("findByEmail", Employee.class);
              query.setParameter("email", "apara2232@villanova2.edu");
              List<Employee> resultList = query.getResultList();
              resultList.forEach(System.out::println);
              emf.close();
    }
}
