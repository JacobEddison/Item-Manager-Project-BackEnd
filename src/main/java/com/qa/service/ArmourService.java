package com.qa.service;

import com.qa.dto.ArmourDto;
import com.qa.persistence.models.Armour;
import com.qa.persistence.repository.ArmourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmourService {

    @Autowired
    private ArmourRepository armourRepository;

    public List<ArmourDto> getArmours(){
        List<Armour> armours = armourRepository.findAll();
        List<ArmourDto> armoursDto = new ArrayList<>();
        armours.forEach(armour -> armoursDto.add(new ArmourDto(armour)));
        return armoursDto;
    }

    public ArmourDto getArmour(Long id){
        Armour armour = armourRepository.getOne(id);
        ArmourDto armourDto = new ArmourDto(armour);
        return armourDto;


    }

    public ArmourDto createArmour(ArmourDto armourDto){
        armourDto.setId(null);
        Armour armour = Armour.createArmour();
        armour.setName(armourDto.getName());
        armour.setCharClass(armourDto.getCharClass());
        armour.setLight(armourDto.getLight());
        armour.setSlot(armourDto.getSlot());


        return new ArmourDto(armourRepository.saveAndFlush(armour));
    }

    public ArmourDto updateArmour(Long id, ArmourDto armourDto){
        Armour armour = armourRepository.getOne(id);
        armour.setName(armourDto.getName());
        armour.setCharClass(armourDto.getCharClass());
        armour.setLight(armourDto.getLight());
        armour.setSlot(armourDto.getSlot());
        armour.setLoadoutId(armourDto.getLoadoutId());
        armourRepository.flush();
        return new ArmourDto(armour);
    }

    public ArmourDto deleteArmour(Long id){
        Armour armour = armourRepository.getOne(id);
        ArmourDto armourDto = new ArmourDto(armour);
        armourRepository.deleteById(id);
        return armourDto;
    }
}
