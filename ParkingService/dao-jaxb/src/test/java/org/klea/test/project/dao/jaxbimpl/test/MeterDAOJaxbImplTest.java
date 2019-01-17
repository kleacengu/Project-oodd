/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.klea.test.project.dao.jaxbimpl.test;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.klea.test.project.dao.jaxbimpl.MeterDAOJaxbImpl;
import org.klea.test.project.model.Meter;
import org.klea.test.project.model.MeterDAO;

/**
 * tests for entityDao.createEntity(entity) entityDao.deleteEntity(Id) entityDao.retrieveAllEntities() entityDao.retrieveEntity(Id)
 * entityDao.retrieveMatchingEntites(entityTempate) entityDao.updateEntity(entity)
 *
 * @author cgallen
 */
public class MeterDAOJaxbImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(MeterDAOJaxbImplTest.class);

    public final String TEST_DATA_FILE_LOCATION = "target/testDaofile.xml";

    @Test
    public void testDestinationsDAOJaxb() {

        // delete test file at start of test
        File file = new File(TEST_DATA_FILE_LOCATION);
        file.delete();
        assertFalse(file.exists());

        // create dao
        MeterDAO meterDao = new MeterDAOJaxbImpl(TEST_DATA_FILE_LOCATION);

        // check that new file created
        assertTrue(file.exists());

        // check there are no entities
        assertTrue(meterDao.retreiveAllMeters().isEmpty());

        // add 3 entities
        int ENTITY_NUMBER = 3;
        for (int intityId = 0; intityId < ENTITY_NUMBER; intityId++) {
            Meter meter = new Meter();
            meter.setMeterId(intityId);
            meter.setLocation("Location" + intityId);

            LOG.debug("adding meter:" + meter);
            Meter e = meterDao.createParkingMeter(meter);
            assertNotNull(e);
        }

        // check 3 entities added
        assertTrue(ENTITY_NUMBER == meterDao.retreiveAllMeters().size());
        

        // check return false for delete unknown entity
           LOG.debug("deleting meter: " + (ENTITY_NUMBER));
       assertTrue(meterDao.deleteParkingMeter(ENTITY_NUMBER));

        // find an entity to delete
        List<Meter> elist = meterDao.retreiveAllMeters();
        Integer idToDelete = elist.get(0).getMeterId();
        LOG.debug("deleting  entity:" + idToDelete);

        // check found and deleted
        assertTrue(meterDao.deleteParkingMeter(idToDelete));

        // check no longer found after deletion
        assertNull(meterDao.retreiveParkingMeter(idToDelete));

        // check entities size decremeted
        List<Meter> elist2 = meterDao.retreiveAllMeters();
        LOG.debug("elist2.size() "+elist2.size());
        assertTrue(ENTITY_NUMBER - 2 == elist2.size());

        // update entity
        Meter meterToUpdate = elist2.get(0);
        LOG.debug("updating meter: " + meterToUpdate);

        // add 1 newProperties for entity
        meterToUpdate.setLocation("Southampton - Portland Terrace");
        //meterToUpdate.setField_B("field_B_Update");
        //meterToUpdate.setField_C(null); // do not update field C
        LOG.debug("update meter: " + meterToUpdate);

        Meter updatedEntity = meterDao.updateParkingMeter(meterToUpdate);
        LOG.debug("updated meter: " + updatedEntity);
        assertNotNull(updatedEntity);

        // check entity updated
        Meter retrievedMeter = meterDao.retreiveParkingMeter(updatedEntity.getMeterId());
        LOG.debug("retreived meter: " + retrievedMeter);
        assertEquals(meterToUpdate.getLocation(), retrievedMeter.getLocation());
        //assertEquals(entityToUpdate.getDuration(), retrievedMeter.getDuration());
        //assertNotEquals(entityToUpdate.getField_C(), retrievedEntity.getField_C());
    }
       

}
