package mock.data.starter.annotation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "condition")
@Data
public class RandomValueProperties {

    private boolean enable;
}
