package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loadout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Armour helmet;
    private Armour arms;
    private Armour chest;
    private Armour legs;
    private Armour mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Armour getHelmet() {
        return helmet;
    }

    public void setHelmet(Armour helmet) {
        this.helmet = helmet;
    }

    public Armour getArms() {
        return arms;
    }

    public void setArms(Armour arms) {
        this.arms = arms;
    }

    public Armour getChest() {
        return chest;
    }

    public void setChest(Armour chest) {
        this.chest = chest;
    }

    public Armour getLegs() {
        return legs;
    }

    public void setLegs(Armour legs) {
        this.legs = legs;
    }

    public Armour getMark() {
        return mark;
    }

    public void setMark(Armour mark) {
        this.mark = mark;
    }



}
