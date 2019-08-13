package mock.data.starter.annotation;

import org.springframework.context.annotation.Conditional;

@Conditional(OnPropertyEnableCondition.class)
public @interface ConditionalOnPropertyEnable {
}
