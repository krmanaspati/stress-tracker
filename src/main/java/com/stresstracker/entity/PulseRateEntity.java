package com.stresstracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PULSERATE")
public class PulseRateEntity {

    @Id
    private String id;
    @ElementCollection(targetClass=String.class)
    private List<String> pulseRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(List<String> pulseRate) {
        this.pulseRate = pulseRate;
    }
}
