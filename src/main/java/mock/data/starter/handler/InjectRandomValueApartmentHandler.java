package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataAddressType;

public class InjectRandomValueApartmentHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueApartmentHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataAddressType getType() {
        return RandomDataAddressType.APARTMENT;
    }

    @Override
    public String getRandomValue() {
        return faker.address().streetAddressNumber();
    }
}
