package com.stresstracker.entity;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STRESSTRACK")
public class StressTrackEntity {

    @Id
    @CsvBindByPosition(position = 0)
    public String id;
    @CsvBindByPosition(position = 1)
    public String name;
    @CsvBindByPosition(position = 2)
    public String gender;
    @CsvBindByPosition(position = 6)
    public String age;

    @OneToMany(targetEntity = PulseRateEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FK",referencedColumnName = "id")
    public List<PulseRateEntity> pulseRate;

    @OneToMany(targetEntity = OxygenLevelEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FK",referencedColumnName = "id")
    public List<OxygenLevelEntity> oxygenLevel;

    @OneToMany(targetEntity = TemperatureEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FK",referencedColumnName = "id")
    public List<TemperatureEntity> temperature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<PulseRateEntity> getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(List<PulseRateEntity> pulseRate) {
        this.pulseRate = pulseRate;
    }

    public List<OxygenLevelEntity> getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(List<OxygenLevelEntity> oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public List<TemperatureEntity> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<TemperatureEntity> temperature) {
        this.temperature = temperature;
    }
}
