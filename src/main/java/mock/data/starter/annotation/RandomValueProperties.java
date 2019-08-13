package mock.data.starter.annotation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "condition")
@Data
public class RandomValueProperties {

    private boolean enable;
}
