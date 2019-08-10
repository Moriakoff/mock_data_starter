package mock.data.starter.configuration;

import com.github.javafaker.Faker;
import mock.data.starter.handler.InjectRandomValueHandler;
import mock.data.starter.model.AddressType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*@Configuration*/
public class ApplicationConfiguration {

    @Bean
    public Map<AddressType, InjectRandomValueHandler> injectRandomValueHandlerMap(List<InjectRandomValueHandler> list) {
        return list.stream()
                .collect(Collectors.toMap(InjectRandomValueHandler::getType,
                        handler -> handler));
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

}
