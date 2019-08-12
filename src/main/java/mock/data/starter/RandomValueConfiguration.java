package mock.data.starter;

import com.github.javafaker.Faker;
import mock.data.starter.annotation.InjectRandomValue;
import mock.data.starter.handler.*;
import mock.data.starter.processor.InjectRandomValueAnnotationBeanPostProcessor;
import mock.data.starter.type.RandomDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class RandomValueConfiguration {

    @Bean
    public InjectRandomValueHandler injectRandomValueNameHandler(){
        return new InjectRandomValueNameHandler(faker());
    }
    @Bean
    public InjectRandomValueHandler injectRandomValueApartmentHandler(){
        return new InjectRandomValueApartmentHandler(faker());
    }
    @Bean
    public InjectRandomValueHandler injectRandomValueBuildingHandler(){
        return new InjectRandomValueBuildingHandler(faker());
    }
    @Bean
    public InjectRandomValueHandler injectRandomValueCityHandler(){
        return new InjectRandomValueCityHandler(faker());
    }
    @Bean
    public InjectRandomValueHandler injectRandomValueImageHandler(){
        return new InjectRandomValueImageLinkHandler(faker());
    }
    @Bean
    public InjectRandomValueHandler injectRandomValueStreetHandler(){
        return new InjectRandomValueStreetHandler(faker());
    }

    @Bean
    public Map<RandomDataType, InjectRandomValueHandler> injectRandomValueHandlerMap(List<InjectRandomValueHandler> list) {
        return list.stream()
                .collect(Collectors.toMap(InjectRandomValueHandler::getType,
                        handler -> handler));
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public InjectRandomValueAnnotationBeanPostProcessor annotationBeanPostProcessor() {
        return new InjectRandomValueAnnotationBeanPostProcessor();
    }

}