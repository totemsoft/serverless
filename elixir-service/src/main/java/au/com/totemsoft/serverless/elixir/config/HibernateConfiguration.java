package au.com.totemsoft.serverless.elixir.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import au.com.totemsoft.serverless.elixir.repository.UserRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
    UserRepository.class,
})
@EnableTransactionManagement
public class HibernateConfiguration {

    @Value("classpath:application-h2.properties")
    //@Value("classpath:application-postgres.properties")
    private Resource propertiesResource;

    private Properties properties() throws IOException {
        try (InputStream is = propertiesResource.getInputStream();) {
            Properties props = new Properties();
            props.load(is);
            return props;
        }
    }

    @Value("classpath:application-h2-jpa.properties")
    //@Value("classpath:application-postgres-jpa.properties")
    private Resource jpaResource;

    private Properties jpaProperties() throws IOException {
        try (InputStream is = jpaResource.getInputStream();) {
            Properties props = new Properties();
            props.load(is);
            return props;
        }
    }

    @Bean
    public DataSource dataSource() throws IOException {
        Properties props = properties();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(props.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(props.getProperty("spring.datasource.url"));
        dataSource.setUsername(props.getProperty("spring.datasource.username"));
        dataSource.setPassword(props.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) throws IOException {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(ds);
       em.setPackagesToScan(new String[] { "au.com.totemsoft.serverless.elixir.model" });
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
       em.setJpaProperties(jpaProperties());
       return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
