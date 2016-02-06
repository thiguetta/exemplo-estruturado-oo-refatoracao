package br.com.arquivolivre.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Thiago Gonzaga <thi_gonzaga@yahoo.com.br>
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("br.com.arquivolivre")
public class ApplicationConfig {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("unidadePersistencia");

    @Bean
    public EntityManager entityManager() {
        return EMF.createEntityManager();
    }
}
