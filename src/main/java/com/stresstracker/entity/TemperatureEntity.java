package com.stresstracker.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEMPERATURE")
public class TemperatureEntity {

    @Id
    private String id ;
    @ElementCollection(targetClass=String.class)
    private List<String> temperature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<String> temperature) {
        this.temperature = temperature;
    }
}
