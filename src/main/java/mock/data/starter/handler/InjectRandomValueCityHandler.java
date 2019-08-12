package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataAddressType;

public class InjectRandomValueCityHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueCityHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataAddressType getType() {
        return RandomDataAddressType.CITY;
    }

    @Override
    public String getRandomValue() {
        return faker.address().city();
    }
}
