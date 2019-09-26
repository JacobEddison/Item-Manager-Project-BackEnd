package com.qa.controllers;

import com.qa.dto.LoadoutDto;
import com.qa.persistence.models.Loadout;
import com.qa.persistence.repository.LoadoutRepository;
import com.qa.service.LoadoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoadoutController {

    @Autowired
    private LoadoutService service;

    @RequestMapping(path = "loadout/", method = {RequestMethod.GET})
    public ResponseEntity<List<LoadoutDto>> getLoadouts(){
        return new ResponseEntity<>(service.getLoadouts(), HttpStatus.OK);
    }

    @RequestMapping(path = "loadout/", method = {RequestMethod.POST})
    public ResponseEntity<LoadoutDto> createLoadout(@RequestBody LoadoutDto loadout){
        return new ResponseEntity<>(service.createLoadout(loadout), HttpStatus.CREATED);
    }

    @RequestMapping(path = "loadout/{id}",method = {RequestMethod.GET})
    public ResponseEntity<LoadoutDto> getloadout(@PathVariable Long id){
        return new ResponseEntity<>(service.getLoadout(id), HttpStatus.OK);
    }

    @RequestMapping(path = "loadout/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<LoadoutDto> updateLoadout(@PathVariable Long id, @RequestBody LoadoutDto loadout){
        return new ResponseEntity<>(service.updateLoadout(id, loadout), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "loadout/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<LoadoutDto> deleteLoadout(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteLoadout(id), HttpStatus.ACCEPTED);
    }
//    @Autowired
//    private LoadoutRepository repository;
//
//    @RequestMapping(value = "loadout",method= RequestMethod.GET)
//    public List<Loadout> listAllLoadout(){
//        return repository.findAll();
//    }
//
//    @RequestMapping(value = "loadout",method=RequestMethod.POST)
//    public Loadout addLoadout(@RequestBody Loadout loadout){
//        return repository.saveAndFlush(loadout);
//    }
//
//    @RequestMapping(value = "loadout/{id}",method=RequestMethod.GET)
//    public Loadout getLoadout(@PathVariable Long id){
//        return repository.getOne(id);
//    }
//
//    @RequestMapping(value = "loadout/{id}",method=RequestMethod.DELETE)
//    public Loadout deleteLoadout(@PathVariable Long id){
//        Loadout existing = repository.getOne(id);
//        repository.delete(existing);
//        return existing;
//    }
//
//    @RequestMapping(value = "loadout/{id}",method=RequestMethod.PUT)
//    public Loadout updateLoadout(@PathVariable Long id,@RequestBody Loadout loadout){
//        Loadout existing = repository.getOne(id);
//        existing.setHelmetId(loadout.getHelmetId());
//        existing.setArmId(loadout.getArmId());
//        existing.setChestId(loadout.getChestId());
//        existing.setLegId(loadout.getLegId());
//        existing.setMarkId(loadout.getMarkId());
//        return repository.saveAndFlush(existing);
//
//    }
}
