package org.klea.test.project.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplyMessage {

    private Integer code;

    private String debugMessage;
    
    private Meter meterConfig;
    

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public void setMeterConfig(Meter meterConfig) {
        this.meterConfig = meterConfig;
    }
    
      public Integer getCode() {
        return code;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public Meter getMeterConfig() {
        return meterConfig;
    }



     public void setCode(Integer setCode) {
        this.code = setCode;
    }

    @Override
    public String toString() {
        return "ReplyMessage{" + "code=" + code + ", debugMessage=" + debugMessage + ", meterConfig=" + meterConfig + '}';
    }
     
    



}
