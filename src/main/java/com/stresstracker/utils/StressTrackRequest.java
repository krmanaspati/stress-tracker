package com.stresstracker.utils;

import com.opencsv.bean.CsvBindByPosition;

public class StressTrackRequest {

    @CsvBindByPosition(position = 0)
    public String id;
    @CsvBindByPosition(position = 1)
    public String name;
    @CsvBindByPosition(position = 2)
    public String gender;
    @CsvBindByPosition(position = 6)
    public String age;
    @CsvBindByPosition(position = 3)
    public String[] pulseRate;
    @CsvBindByPosition(position = 4)
    public String[] oxygenLevel;
    @CsvBindByPosition(position = 5)
    public String[] temperature;

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

    public String[] getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String[] pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String[] getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(String[] oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public String[] getTemperature() {
        return temperature;
    }

    public void setTemperature(String[] temperature) {
        this.temperature = temperature;
    }
}
