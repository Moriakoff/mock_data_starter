package mock.data.starter.annotation;

import mock.data.starter.type.RandomDataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectRandomValue {
    Class<? extends RandomDataType> type();

    String fieldName();
}
