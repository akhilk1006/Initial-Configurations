package SpringMVCStart;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("SpringMVCStart.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setDataSource(ds());
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql", true);
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public DataSource ds(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjpa");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager txManager = new JpaTransactionManager(entityManagerFactory);
        return txManager;
    }
}
