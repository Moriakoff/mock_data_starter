package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataNameType;
import mock.data.starter.type.RandomDataType;

public class InjectRandomValueNameHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueNameHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataType getType() {
        return RandomDataNameType.NAME;
    }

    @Override
    public String getRandomValue() {
        return faker.artist().name();
    }
}
