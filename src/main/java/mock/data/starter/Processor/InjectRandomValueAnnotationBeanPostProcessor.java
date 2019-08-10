package mock.data.starter.Processor;

import com.github.javafaker.Faker;
import mock.data.starter.annotation.InjectRandomValue;
import mock.data.starter.handler.*;
import mock.data.starter.model.AddressType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InjectRandomValueAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<AddressType, InjectRandomValueHandler> map;

/*
    @Autowired
    public InjectRandomValueAnnotationBeanPostProcessor(Map<AddressType, InjectRandomValueHandler> map) {
        this.map = map;
    }*/

    @Bean
    public Map<AddressType, InjectRandomValueHandler> injectRandomValueHandlerMap(List<InjectRandomValueHandler> list) {
        return list.stream()
                .collect(Collectors.toMap(InjectRandomValueHandler::getType,
                        handler -> handler));
    }

    @Bean
    public List<InjectRandomValueHandler> initList() {
        List<InjectRandomValueHandler> injectRandomValueHandlerList = new ArrayList<>();

        injectRandomValueHandlerList.add(new InjectRandomValueCityHandler(faker()));
        injectRandomValueHandlerList.add(new InjectRandomValueApartmentHandler(faker()));
        injectRandomValueHandlerList.add(new InjectRandomValueStreetHandler(faker()));
        injectRandomValueHandlerList.add(new InjectRandomValueBuildingHandler(faker()));

        return injectRandomValueHandlerList;
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<InjectRandomValueHandler> injectRandomValueHandlerList = initList();
        map = injectRandomValueHandlerMap(injectRandomValueHandlerList);

        Field[] beanFields = bean.getClass().getDeclaredFields();
        Arrays.stream(beanFields)
                .forEach(field -> {
                    InjectRandomValue annotation = field.getAnnotation(InjectRandomValue.class);
                    if (annotation != null) {
                        field.setAccessible(true);
                        InjectRandomValueHandler valueHandler = map.get(annotation.type());
                        ReflectionUtils.setField(field, bean, valueHandler.getRandomValue());
                    }
                });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
