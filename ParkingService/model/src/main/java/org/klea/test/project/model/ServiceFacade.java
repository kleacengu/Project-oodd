package org.klea.test.project.model;

import java.util.Date;
import java.util.List;

public interface ServiceFacade extends MeterDAO {

    public String createTicket(Integer meterId, double durationTime, String startTime, String endTime, Date dateOfIssue);

   //public boolean validateCard(String cardNumber, String lunnNumber);
    //do it in ticket maachine
    public Meter retrieveMeterConfig(Integer meterId);
    
   
}
