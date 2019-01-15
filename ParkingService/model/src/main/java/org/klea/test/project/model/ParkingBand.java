package org.klea.test.project.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ParkingBand {

    private String startTime;

    private double pricePerHalfHour;
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setPricePerHalfHour(double pricePerHalfHour) {
        this.pricePerHalfHour = pricePerHalfHour;
    }
    
     public String getStartTime() {
        return startTime;
    }

    public double getPricePerHalfHour() {
        return pricePerHalfHour;
    }

}
