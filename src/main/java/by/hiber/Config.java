package by.hiber;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("by.hiber")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableWebMvc
@PropertySource("classpath:config.properties")
public class Config {

    private final Environment environment;

    public Config(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setInitialSize(5);
        basicDataSource.setUsername(environment.getProperty("login"));
        basicDataSource.setPassword(environment.getProperty("password"));
        basicDataSource.setUrl(environment.getProperty("url"));
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
//        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
//        return embeddedDatabaseBuilder.build();
        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("by.hiber.model");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory localSessionFactoryBean) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean);
        return hibernateTransactionManager;
    }

    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory localSessionFactoryBean){
        return new HibernateTemplate(localSessionFactoryBean);
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "create-drop");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                setProperty("hibernate.show_sql", "true");
//                setProperty("hibernate.format_sql", "true");
            }
        };
    }

//    @Bean
//    @Scope("prototype")
//    public Connection connection(){
//        return DriverManager.getConnection();
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
}
