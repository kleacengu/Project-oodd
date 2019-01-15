/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.klea.test.project.web.rest.client.test.manual;

import java.util.List;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import org.klea.test.project.model.Meter;
import org.klea.test.project.model.ReplyMessage;
import org.klea.test.project.web.rest.client.RestClientJerseyImpl;

/**
 *
 * @author cgallen
 */
public class RestClientJerseyImplTest {

    String baseUrl = "http://localhost:8680/";

    MediaType mediaType = MediaType.APPLICATION_XML_TYPE;

    @Test
    public void restClientRetreiveTest() {

        RestClientJerseyImpl restClient = new RestClientJerseyImpl(baseUrl, mediaType);

        // try to retreive an unknown entity
        ReplyMessage replyMessage = restClient.retrieveEntity(Integer.SIZE);
        assertNotNull(replyMessage);
        assertTrue(replyMessage.getMeterConfig().getLocation().isEmpty());

        // try to retreive entity with id 1
        ReplyMessage replyMessage2 = restClient.retrieveEntity(1);
        assertNotNull(replyMessage2);
        assertEquals(1, replyMessage2.getMeterConfig().getMeterId().size());

        Meter meter = replyMessage2.getMeterConfig().getMeterId().get(0);
        System.out.println("Received Meter: " + meter);

    }

    @Test
    public void restClientRetreiveTemplateTest() {

        RestClientJerseyImpl restClient = new RestClientJerseyImpl(baseUrl, mediaType);

        Meter meter = new Meter();
        meter.setMeterId(001);

        // try to retreive an unknown entity
        ReplyMessage replyMessage = restClient.retrieveMatchingEntites(meter);
        assertNotNull(replyMessage);

        List<Meter> entityList =  replyMessage.getEntityList().getEntities();
        System.out.println("Received "
                + entityList.size()
                + " Entities");
        
       for(Meter e: entityList){
           System.out.println("   "+ e);
       }
        
    }
}
