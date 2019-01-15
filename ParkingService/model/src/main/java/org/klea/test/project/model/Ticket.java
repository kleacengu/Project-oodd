package org.klea.test.project.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    private Integer ticketId;

    private Date dateOfIssue;

    private double durationTime;

    private String startTime;
    
    private String endTime;

    private Integer meterId;

    private String Location;
    
      public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime = durationTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
     public Integer getTicketId() {
        return ticketId;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public double getDurationTime() {
        return durationTime;
    }

    public String getStartTime() {
        return startTime;
    }

    
    public String getEndTime() {
        return endTime;
    }

    public Integer getMeterId() {
        return meterId;
    }

    public String getLocation() {
        return Location;
    }
}
