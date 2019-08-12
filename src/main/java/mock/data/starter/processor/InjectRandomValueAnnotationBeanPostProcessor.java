package mock.data.starter.processor;

import mock.data.starter.annotation.InjectRandomValue;
import mock.data.starter.handler.InjectRandomValueHandler;
import mock.data.starter.type.RandomDataType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;


public class InjectRandomValueAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private Map<RandomDataType, InjectRandomValueHandler> map;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] beanFields = bean.getClass().getDeclaredFields();
        for (Field field : beanFields) {
            InjectRandomValue annotation = field.getAnnotation(InjectRandomValue.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class typeClass = annotation.type();
                RandomDataType randomDataType = (RandomDataType) Enum.valueOf(typeClass,
                        annotation.fieldName().toUpperCase());
                InjectRandomValueHandler valueHandler = map.get(randomDataType);
                ReflectionUtils.setField(field, bean, valueHandler.getRandomValue());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
