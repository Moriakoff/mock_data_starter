package mock.data.starter.handler;

import mock.data.starter.type.RandomDataType;


public interface InjectRandomValueHandler {

    RandomDataType getType();

    String getRandomValue();


}
