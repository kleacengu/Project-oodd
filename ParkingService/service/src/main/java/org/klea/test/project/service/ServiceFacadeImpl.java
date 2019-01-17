
package org.klea.test.project.service;

import java.util.List;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.klea.test.project.model.Meter;
import org.klea.test.project.model.ServiceFacade;
import org.klea.test.project.model.MeterDAO;
import org.klea.test.project.model.Ticket;

public class ServiceFacadeImpl implements ServiceFacade {
    
    MeterDAO meterDAO = null;

    public void setMeterDAO(MeterDAO meterDAO) {
        this.meterDAO = meterDAO;
    }

    @Override
    public boolean deleteParkingMeter(Integer meterId) {
       return meterDAO.deleteParkingMeter(meterId);
    }
    
    @Override
     public Meter createParkingMeter(Meter meterIn){
         return meterDAO.createParkingMeter(meterIn);
     }
    
    @Override
    public Meter retreiveParkingMeter(Integer meterId){
      return meterDAO.retreiveParkingMeter(meterId);
    }
            
    @Override
    public Meter updateParkingMeter(Meter meter) {
        return meterDAO.updateParkingMeter(meter);
    }
    

    @Override
    public List<Meter> retreiveAllMeters() {
        return meterDAO.retreiveAllMeters();
    }
        
    
     @Override
    public boolean validateCard(String cardNumber, String lunnNumber) {
        if (cardNumber.length() == 16)
        {
            if(lunnNumber.length() == 3)
                return true;
        }
        return false;
    }
    
     AtomicInteger m_atomicIssueNumber = new AtomicInteger(0);

    private int getNewTicketNumber() {
        int issueNumber = m_atomicIssueNumber.incrementAndGet();
        return issueNumber;
    }
    
    
     @Override
   public String createTicket(Integer meterId, double durationTime, String startTime, String endTime, Date dateOfIssue) {
       
      int ticketId = getNewTicketNumber();
      Ticket ticket = new Ticket();
      
      ticket.setMeterId(meterId);
      ticket.setDurationTime(durationTime);
      ticket.setStartTime(startTime);
      ticket.setEndTime(endTime);
      ticket.setDateOfIssue(dateOfIssue);
      
      String ticketString = ticketId + meterId + durationTime + startTime + endTime + dateOfIssue;
      return ticketString;
   }

    @Override
    public Meter retrieveMeterConfig(Integer meterId) {
        
        Meter meterConf = new Meter();
        Integer id = meterConf.getMeterId();
        meterConf.getLocation();
        meterConf.getParkingBands();
        
        return meterConf;
    }
       

    
}