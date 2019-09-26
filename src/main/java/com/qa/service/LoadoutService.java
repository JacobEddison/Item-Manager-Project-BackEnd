package com.qa.service;

import com.qa.dto.LoadoutDto;
import com.qa.persistence.models.Loadout;
import com.qa.persistence.repository.LoadoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadoutService {

    @Autowired
    private LoadoutRepository loadoutRepository;

    public List<LoadoutDto> getLoadouts(){
        List<Loadout> loadouts = loadoutRepository.findAll();
        List<LoadoutDto> loadoutsDto = new ArrayList<>();
        loadouts.forEach(loadout -> loadoutsDto.add(new LoadoutDto(loadout)));
        return loadoutsDto;
    }

    public LoadoutDto getLoadout(Long id){
        Loadout loadout = loadoutRepository.getOne(id);
        LoadoutDto loadoutDto = new LoadoutDto(loadout);
        return loadoutDto;

    }

    public LoadoutDto createLoadout(LoadoutDto loadoutDto){
        loadoutDto.setId(null);
        Loadout loadout = Loadout.createLoadout();
        loadout.setHelmetId(loadoutDto.getHelmetId());
        loadout.setArmId(loadoutDto.getArmId());
        loadout.setChestId(loadoutDto.getChestId());
        loadout.setLegId(loadoutDto.getLegId());
        loadout.setMarkId(loadoutDto.getMarkId());


        return new LoadoutDto(loadoutRepository.saveAndFlush(loadout));
    }

    public LoadoutDto updateLoadout(Long id,LoadoutDto loadoutDto){
        Loadout loadout = loadoutRepository.getOne(id);
        loadout.setHelmetId(loadoutDto.getHelmetId());
        loadout.setArmId(loadoutDto.getArmId());
        loadout.setChestId(loadoutDto.getChestId());
        loadout.setLegId(loadoutDto.getLegId());
        loadout.setMarkId(loadoutDto.getMarkId());
        loadoutRepository.flush();
        return new LoadoutDto(loadout);
    }

    public LoadoutDto deleteLoadout(Long id){
        Loadout loadout = loadoutRepository.getOne(id);
        LoadoutDto loadoutDto = new LoadoutDto(loadout);
        loadoutRepository.deleteById(id);
        return loadoutDto;
    }
}
