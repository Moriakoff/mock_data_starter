package mock.data.starter.handler;

import mock.data.starter.model.AddressType;

public interface InjectRandomValueHandler {

    AddressType getType();

    String getRandomValue();


}
