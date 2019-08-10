package mock.data.starter.handler;

import com.github.javafaker.Faker;
import mock.data.starter.model.AddressType;
import org.springframework.stereotype.Component;

@Component
public class InjectRandomValueCityHandler implements InjectRandomValueHandler {

    private final Faker faker;

    public InjectRandomValueCityHandler(Faker faker) {
        this.faker = faker;
    }

    @Override
    public AddressType getType() {
        return AddressType.CITY;
    }

    @Override
    public String getRandomValue() {
        return faker.address().city();
    }
}