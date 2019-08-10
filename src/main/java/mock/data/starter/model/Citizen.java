package mock.data.starter.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mock.data.starter.annotation.InjectRandomValue;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@Scope()
public class Citizen implements Person {

    @InjectRandomValue(type = AddressType.CITY)
    private String city;

    @InjectRandomValue(type = AddressType.STREET)
    private String street;

    @InjectRandomValue(type = AddressType.BUILDING)
    private String building;

    @InjectRandomValue(type = AddressType.APARTMENT)
    private String apartment;

    public Citizen() {
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
