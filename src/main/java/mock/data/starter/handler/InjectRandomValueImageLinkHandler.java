package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataImageLinkType;
import mock.data.starter.type.RandomDataType;

public class InjectRandomValueImageLinkHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueImageLinkHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataType getType() {
        return RandomDataImageLinkType.IMAGE;
    }

    @Override
    public String getRandomValue() {
        return faker.avatar().image();
    }
}
