package com.stresstracker.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OXYGENLEVEL")
public class OxygenLevelEntity {
    @Id
    private String id;
    @ElementCollection(targetClass=String.class)
    private List<String> oxygenLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(List<String> oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }
}
