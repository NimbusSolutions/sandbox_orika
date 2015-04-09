package com.nimbus.mapper;

import com.nimbus.data.JourneyEntity;
import com.nimbus.data.PassengerEntity;
import com.nimbus.domain.Journey;
import com.nimbus.domain.Passenger;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by Kye on 09/04/15.
 */
public class Mapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {

        factory.classMap(Passenger.class, PassengerEntity.class).field("phonenumber", "phone").byDefault().register();

        factory.classMap(Journey.class, JourneyEntity.class).field("passengers", "passengerEntities").byDefault().register();

    }
}
