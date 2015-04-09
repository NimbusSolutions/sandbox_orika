package com.nimbus.mapper;

import com.nimbus.data.JourneyEntity;
import com.nimbus.data.PassengerEntity;
import com.nimbus.domain.Journey;
import com.nimbus.domain.Passenger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Kye on 09/04/15.
 */
public class MapperTest {

    private Mapper objectUnderTest;

    @BeforeMethod
    private void beforeMethod() {
        objectUnderTest = new Mapper();
    }

    @AfterMethod
    private void afterMethod() {

        objectUnderTest = null;
    }

    @Test
    public void testMappingSimpleBean() {

        // forwards
        {
            Passenger source = createPassengerA();
            PassengerEntity target = objectUnderTest.map(source, PassengerEntity.class);

            assertPassenger(source, target);
            assertNull(target.getId());
            assertNull(target.getJourneyEntity());
        }

        //reversed
        {
            PassengerEntity source = createPassengerEntityA();
            Passenger target = objectUnderTest.map(source, Passenger.class);
            assertPassenger(target, source);
        }
    }


    @Test
    public void testMappingComplexBean() {

        // forwards
        {
            Journey source = createJourney();
            JourneyEntity target = objectUnderTest.map(source, JourneyEntity.class);

            assertEquals(target.getPnr(), source.getPnr());
            assertNull(target.getId());

            List<Passenger> sourcePaxList = source.getPassengers();
            List<PassengerEntity> targetPaxList = target.getPassengerEntities();
            assertEquals(sourcePaxList.size(), targetPaxList.size());


            for (int i = 0; i < sourcePaxList.size(); i++) {

                PassengerEntity targetPax = targetPaxList.get(i);
                assertPassenger(sourcePaxList.get(i), targetPax);

                assertNull(targetPax.getId());
                assertNull(targetPax.getJourneyEntity());
            }
        }

        // reversed
        {
            JourneyEntity source = createJourneyEntity();
            Journey target = objectUnderTest.map(source, Journey.class);

            assertEquals(target.getPnr(), source.getPnr());

            List<PassengerEntity> sourcePaxList = source.getPassengerEntities();
            List<Passenger> targetPaxList = target.getPassengers();
            assertEquals(sourcePaxList.size(), targetPaxList.size());


            for (int i = 0; i < sourcePaxList.size(); i++) {

                assertPassenger(targetPaxList.get(i), sourcePaxList.get(i));
            }
        }
    }


    private void assertPassenger(Passenger source, PassengerEntity target) {

        assertEquals(target.getFirstname(), source.getFirstname());
        assertEquals(target.getLastname(), source.getLastname());
        assertEquals(target.getEmail(), source.getEmail());
        assertEquals(target.getPassportId(), source.getPassportId());
        assertEquals(target.getPhone(), source.getPhonenumber());
    }


    private Passenger createPassengerA() {

        Passenger ret = new Passenger();
        ret.setFirstname("Kye");
        ret.setLastname("Yeung");
        ret.setEmail("yeung.kye@gmail.com");
        ret.setPassportId("aaabbbccc");
        ret.setPhonenumber("+4492928938392");

        return ret;
    }


    private Passenger createPassengerB() {

        Passenger ret = new Passenger();
        ret.setFirstname("Carl");
        ret.setLastname("Thompson");
        ret.setEmail("carl.thompson@gmail.com");
        ret.setPassportId("xxxxxxxddddd");
        ret.setPhonenumber("+4433333333333");

        return ret;
    }

    private Journey createJourney() {

        Journey ret = new Journey();

        ret.setPnr("pnr_1");
        ret.setPassengers(Arrays.asList(createPassengerA(), createPassengerB()));

        return ret;
    }

    private PassengerEntity createPassengerEntityA() {

        PassengerEntity ret = new PassengerEntity();

        ret.setId(1L);
        ret.setFirstname("Kye");
        ret.setLastname("Yeung");
        ret.setEmail("yeung.kye@gmail.com");
        ret.setPassportId("aaabbbccc");
        ret.setPhone("+4492928938392");

        return ret;
    }

    private PassengerEntity createPassengerEntityB() {

        PassengerEntity ret = new PassengerEntity();

        ret.setId(2L);
        ret.setFirstname("Carl");
        ret.setLastname("Thompson");
        ret.setEmail("carl.thompson@gmail.com");
        ret.setPassportId("xxxxxxxddddd");
        ret.setPhone("+4433333333333");

        return ret;
    }

    private JourneyEntity createJourneyEntity() {

        JourneyEntity ret = new JourneyEntity();

        ret.setId(1L);
        ret.setPnr("prn_1");
        ret.setPassengerEntities(Arrays.asList(createPassengerEntityA(), createPassengerEntityB()));
        ret.getPassengerEntities().stream().forEach(pe -> pe.setJourneyEntity(ret));

        return ret;
    }

}
