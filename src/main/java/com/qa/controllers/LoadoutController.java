package com.qa.controllers;

import com.qa.models.Loadout;
import com.qa.repository.LoadoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class LoadoutController {

    @Autowired
    private LoadoutRepository repository;

    @RequestMapping(value = "loadout",method= RequestMethod.GET)
    public List<Loadout> listAllLoadout(){
        return repository.findAll();
    }

    @RequestMapping(value = "loadout",method=RequestMethod.POST)
    public Loadout addLoadout(@RequestBody Loadout loadout){
        return repository.saveAndFlush(loadout);
    }

    @RequestMapping(value = "loadout/{id}",method=RequestMethod.GET)
    public Loadout getLoadout(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @RequestMapping(value = "loadout/{id}",method=RequestMethod.DELETE)
    public Loadout deleteLoadout(@PathVariable Long id){
        Loadout existing = repository.findById(id).orElse(null);
        repository.delete(existing);
        return existing;
    }

    @RequestMapping(value = "loadout/{id}",method=RequestMethod.PUT)
    public Loadout updateLoadout(@PathVariable Long id,@RequestBody Loadout loadout){
        Loadout existing = repository.findById(id).orElse(null);
        existing.setHelmetId(loadout.getHelmetId());
        existing.setArmId(loadout.getArmId());
        existing.setChestId(loadout.getChestId());
        existing.setLegId(loadout.getLegId());
        existing.setMarkId(loadout.getMarkId());
        return repository.saveAndFlush(existing);

    }
}
