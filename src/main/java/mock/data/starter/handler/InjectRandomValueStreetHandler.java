package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataAddressType;

public class InjectRandomValueStreetHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueStreetHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataAddressType getType() {
        return RandomDataAddressType.STREET;
    }

    @Override
    public String getRandomValue() {
        return faker.address().city();
    }
}
