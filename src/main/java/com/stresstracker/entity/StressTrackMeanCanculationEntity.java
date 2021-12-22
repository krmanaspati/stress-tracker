package com.stresstracker.entity;

import javax.persistence.*;

@Entity
@Table( name = "STRESSTRACKMEANCALCULATION")
public class StressTrackMeanCanculationEntity {

    @Id
    private String id;
    private double pulseRateMeanValue;
    private double oxygenLevelMeanValue;
    private double temperatureMeanValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPulseRateMeanValue() {
        return pulseRateMeanValue;
    }

    public void setPulseRateMeanValue(double pulseRateMeanValue) {
        this.pulseRateMeanValue = pulseRateMeanValue;
    }

    public double getOxygenLevelMeanValue() {
        return oxygenLevelMeanValue;
    }

    public void setOxygenLevelMeanValue(double oxygenLevelMeanValue) {
        this.oxygenLevelMeanValue = oxygenLevelMeanValue;
    }

    public double getTemperatureMeanValue() {
        return temperatureMeanValue;
    }

    public void setTemperatureMeanValue(double temperatureMeanValue) {
        this.temperatureMeanValue = temperatureMeanValue;
    }
}
