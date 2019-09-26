package com.qa.controllers;

//import com.qa.persistence.models.Armour;
//import com.qa.persistence.repository.ArmourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.dto.ArmourDto;
import com.qa.service.ArmourService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ArmourController {

    @Autowired
    private ArmourService service;

    @RequestMapping(path = "armour/", method = {RequestMethod.GET})
    public ResponseEntity<List<ArmourDto>> getArmours(){
        return new ResponseEntity<>(service.getArmours(), HttpStatus.OK);
    }

    @RequestMapping(path = "armour/", method = {RequestMethod.POST})
    public ResponseEntity<ArmourDto> createArmour(@RequestBody ArmourDto armour){
        return new ResponseEntity<>(service.createArmour(armour), HttpStatus.CREATED);
    }

    @RequestMapping(path = "armour/{id}",method = {RequestMethod.GET})
    public ResponseEntity<ArmourDto> getArmour(@PathVariable Long id){
        return new ResponseEntity<>(service.getArmour(id), HttpStatus.OK);
    }

    @RequestMapping(path = "armour/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<ArmourDto> updateArmour(@PathVariable Long id, @RequestBody ArmourDto armour){
        return new ResponseEntity<>(service.updateArmour(id,armour), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "armour/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<ArmourDto> deleteArmour(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteArmour(id), HttpStatus.ACCEPTED);
    }

//    @Autowired
//    private ArmourRepository repository;
//
//    @RequestMapping(value = "armour",method= RequestMethod.GET)
//    public List<Armour> listAllArmour(){
//        return repository.findAll();
//    }
//
//    @RequestMapping(value = "armour",method=RequestMethod.POST)
//    public Armour addArmour(@RequestBody Armour armour){
//        return repository.saveAndFlush(armour);
//    }
//
//    @RequestMapping(value = "armour/",method=RequestMethod.GET)
//    public Armour getArmour(@PathVariable Long id){
//        return repository.getOne(id);
//    }
//
//    @RequestMapping(value = "armour/{id}",method=RequestMethod.DELETE)
//    public Armour deleteArmour(@PathVariable Long id){
//        Armour existing = repository.getOne(id);
//        repository.deleteById(id);
//        return existing;
//    }
//
//    @RequestMapping(value = "armour/",method=RequestMethod.PUT)
//    public Armour updateArmour(@PathVariable Long id,@RequestBody Armour armour){
//        Armour existing = repository.getOne(armour.getId());
//        existing.setName(armour.getName());
//        existing.setLight(armour.getLight());
//        existing.setSlot(armour.getSlot());
//        existing.setCharClass(armour.getCharClass());
//        existing.setLoadoutId(armour.getLoadoutId());
//        repository.saveAndFlush(existing);
//        return existing;
//
//    }
}
