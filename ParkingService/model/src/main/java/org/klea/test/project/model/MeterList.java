/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.klea.test.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cgallen
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MeterList {

    // only used by persistance layer
    private Integer lastEntityId = null;

    @XmlElementWrapper(name = "meters")
    @XmlElement(name = "meter")
    private List<Meter> entities = new ArrayList<Meter>();

    public List<Meter> getEntities() {
        return entities;
    }

    public void setEntities(List<Meter> entities) {
        this.entities = entities;
    }
    
    
    public Integer getLastEntityId() {
        return lastEntityId;
    }

    public void setLastEntityId(Integer lastEntityId) {
        this.lastEntityId = lastEntityId;
    }

    @Override
    public String toString() {
        return "EntityList{" + "lastEntityId=" + lastEntityId + ", entities=" + entities + '}';
    }



}
