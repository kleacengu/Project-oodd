/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.klea.test.project.service;

import org.klea.test.project.dao.jaxbimpl.MeterDAOJaxbImpl;
import org.klea.test.project.model.ServiceFacade;
import org.klea.test.project.model.ServiceFactory;
import org.klea.test.project.model.MeterDAO;

/**
 *
 * @author cgallen
 */
public class ServiceFactoryImpl implements ServiceFactory {

    ServiceFacade serviceFacade = null;

    String dataFileUri = null;

    public ServiceFactoryImpl(String dataFileUri) {
        if (dataFileUri == null) {
            throw new IllegalArgumentException("dataFileUri must not be null");
        }
        
        MeterDAO meterDao = new MeterDAOJaxbImpl(dataFileUri);
        ServiceFacadeImpl serviceFacadeImpl = new ServiceFacadeImpl();
        serviceFacadeImpl.setMeterDAO(meterDao);
        serviceFacade = serviceFacadeImpl;
        
    }

    @Override
    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }

}
