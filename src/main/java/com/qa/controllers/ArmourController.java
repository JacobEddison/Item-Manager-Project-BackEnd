package com.qa.controllers;

import com.qa.models.Armour;
import com.qa.repository.ArmourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class ArmourController {

    @Autowired
    private ArmourRepository repository;

    @RequestMapping(value = "armour",method= RequestMethod.GET)
    public List<Armour> listAllArmour(){
        return repository.findAll();
    }

    @RequestMapping(value = "armour",method=RequestMethod.POST)
    public Armour addArmour(@RequestBody Armour armour){
        return repository.saveAndFlush(armour);
    }

    @RequestMapping(value = "armour/{id}",method=RequestMethod.GET)
    public Armour getArmour(@PathVariable Long id){
        return repository.getOne(id);
    }

    @RequestMapping(value = "armour/{id}",method=RequestMethod.DELETE)
    public Armour deleteArmour(@PathVariable Long id){
        Armour existing = repository.getOne(id);
        repository.delete(existing);
        return existing;
    }

    @RequestMapping(value = "armour/{id}",method=RequestMethod.PUT)
    public Armour updateArmour(@PathVariable Long id,@RequestBody Armour armour){
        Armour existing = repository.getOne(id);
        existing.setName(armour.getName());
        existing.setLight(armour.getLight());
        existing.setSlot(armour.getSlot());
        existing.setCharClass(armour.getCharClass());
        existing.setLoadoutId(armour.getLoadoutId());
        repository.saveAndFlush(existing);
        return existing;

    }
}
