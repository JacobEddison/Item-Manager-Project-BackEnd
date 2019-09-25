package com.qa.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Armour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int light;
    private String slot;
    private String charClass;
    private Long loadoutId;

    public Armour() {
        super();
    }

    public Armour(Long id, String name, int light, String slot, String charClass, Long loadoutId) {
        super();
        this.id = id;
        this.name = name;
        this.light = light;
        this.slot = slot;
        this.charClass = charClass;
        this.loadoutId = loadoutId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public Long getLoadoutId() {
        return loadoutId;
    }

    public void setLoadoutId(Long loadoutId) {
        this.loadoutId = loadoutId;
    }

    public static Armour createArmour(){
        return new Armour();
    }
}
