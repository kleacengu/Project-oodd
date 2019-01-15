package org.klea.test.project.model;

public interface RestInterface {

    public ReplyMessage retrieveMatchingEntites(Meter entityTempate);
    
    public ReplyMessage retrieveEntity(Integer id);
    
}


// public Integer requestConfiguration(Integer meterId);