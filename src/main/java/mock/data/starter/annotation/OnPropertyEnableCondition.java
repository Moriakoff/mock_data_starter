package mock.data.starter.annotation;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;


public class OnPropertyEnableCondition implements Condition {

    private RandomValueProperties properties;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return properties.isEnable();
    }
}
