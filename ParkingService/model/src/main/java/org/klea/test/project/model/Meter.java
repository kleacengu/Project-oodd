package org.klea.test.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.klea.test.project.model.ParkingBand;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Meter {

    private Integer meterId;

    private String location;

    // private double duration;
    @XmlElementWrapper(name = "parkingBands")
    @XmlElement(name = "parkingBand")
    private List<ParkingBand> parkingBands = new ArrayList<ParkingBand>();

    public double calculateCharge(String startTime, double pricePerHalfHour) {

        ParkingBand parking = new ParkingBand();
        double charge = 0.30;
        parking.getStartTime();
        parking.getPricePerHalfHour();
        Integer startTimeNo = Integer.valueOf(startTime);

        if (startTimeNo > 11) {
            charge = charge + pricePerHalfHour;
        } else {

            charge = charge + (pricePerHalfHour * 2);
        }

        return charge;
    }

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ParkingBand> getParkingBands() {
        return parkingBands;
    }

    public void setParkingBands(List<ParkingBand> parkingBands) {
        this.parkingBands = parkingBands;
    }

}
