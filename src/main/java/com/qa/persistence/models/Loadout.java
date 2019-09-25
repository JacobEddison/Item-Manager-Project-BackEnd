package com.qa.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loadout{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long helmetId;
    private Long armId;
    private Long chestId;
    private Long legId;
    private Long markId;

    public Loadout() {
    }

    public Loadout(Long id, Long helmetId, Long armId, Long chestId, Long legId, Long markId) {
        super();
        this.id = id;
        this.helmetId = helmetId;
        this.armId = armId;
        this.chestId = chestId;
        this.legId = legId;
        this.markId = markId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHelmetId() {
        return helmetId;
    }

    public void setHelmetId(Long helmetId) {
        this.helmetId = helmetId;
    }

    public Long getArmId() {
        return armId;
    }

    public void setArmId(Long armId) {
        this.armId = armId;
    }

    public Long getChestId() {
        return chestId;
    }

    public void setChestId(Long chestId) {
        this.chestId = chestId;
    }

    public Long getLegId() {
        return legId;
    }

    public void setLegId(Long legId) {
        this.legId = legId;
    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public static Loadout createLoadout(){
        return new Loadout();
    }
}
