package org.klea.test.project.model;

import java.util.List;

public interface MeterDAO {

    public Meter createParkingMeter(Meter meterIn);

    public Meter updateParkingMeter(Meter meter);

    public boolean deleteParkingMeter(Integer meterId);

    public Meter retreiveParkingMeter(Integer meterId);

    public List<Meter> retreiveAllMeters();
   
   
}
