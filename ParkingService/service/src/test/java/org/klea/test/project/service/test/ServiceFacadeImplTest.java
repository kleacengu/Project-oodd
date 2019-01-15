/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.klea.test.project.service.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.klea.test.project.model.Meter;
import org.klea.test.project.model.ServiceFacade;
import org.klea.test.project.model.ServiceFactory;
import org.klea.test.project.service.ServiceFactoryImpl;

/**
 *
 * @author cgallen
 */
public class ServiceFacadeImplTest {

    public static final String TEST_DATA_FILE = "./target/testfile.xml";

    // Only some basic tests as most tests already done in EntityDAO tests
    @Test
    public void simpleServiceFacadeTest() {

        // use service factory to get access to service
        ServiceFactory serviceFactory = new ServiceFactoryImpl(TEST_DATA_FILE);
        assertNotNull(serviceFactory);

        ServiceFacade serviceFacade = serviceFactory.getServiceFacade();
        assertNotNull(serviceFacade);
        
        // clear file before anything else
        serviceFacade.deleteParkingMeter(Integer.BYTES);

        Meter meter = new Meter();
        meter.setMeterId(001);

        serviceFacade.createParkingMeter(meter);
        List<Meter> retrievedEntities = (List<Meter>) serviceFacade.retreiveParkingMeter(001);

        assertEquals(1, retrievedEntities.size());
    }
}
