package br.com.arquivolivre.rest;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("br.com.arquivolivre")
public class ApplicationConfig {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("unidadePersistencia");
        return emf;
    }

//    @Bean
//    @Autowired
//    public EntityManager entityManager(EntityManagerFactory emf){
//        return emf.createEntityManager();
//    }
    @Bean
    @Autowired
    public DataSource dataSource(LocalEntityManagerFactoryBean emf) {
        return emf.getDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }
}
