package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.type.RandomDataAddressType;

public class InjectRandomValueBuildingHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueBuildingHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public RandomDataAddressType getType() {
        return RandomDataAddressType.BUILDING;
    }

    @Override
    public String getRandomValue() {
        return faker.address().buildingNumber();
    }
}
