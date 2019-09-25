package com.qa.dto;

import com.qa.persistence.models.Armour;

public class ArmourDto {

    private Long id;

    private String name;
    private int light;
    private String slot;
    private String charClass;
    private Long loadoutId;

    public ArmourDto() {
        super();
    }

    public ArmourDto(Long id, String name, int light, String slot, String charClass, Long loadoutId) {
        super();
        this.id = id;
        this.name = name;
        this.light = light;
        this.slot = slot;
        this.charClass = charClass;
        this.loadoutId = loadoutId;
    }

    public ArmourDto(Armour armour) {
        this.id = armour.getId();
        this.name = armour.getName();
        this.light = armour.getLight();
        this.slot = armour.getSlot();
        this.charClass = armour.getCharClass();
        this.loadoutId = armour.getLoadoutId();
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


}
