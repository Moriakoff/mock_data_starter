package mock.data.starter;

import mock.data.starter.model.Citizen;
import mock.data.starter.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {

        return args -> {
            Person bean = appContext.getBean(Citizen.class);
            System.out.println(bean);
        };
    }

}
