package com.qa.service;

import com.qa.dto.ArmourDto;
import com.qa.persistence.models.Armour;
import com.qa.persistence.repository.ArmourRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArmourServiceTest {

    @Mock
    private ArmourRepository armourRepository;

    @InjectMocks
    private ArmourService armourService;

    @Test
    public void getArmoursTest() {
        List<Armour> listOfArmours = new ArrayList<>();
        listOfArmours.add(new Armour(1L,"bob",123,"arm","titan"));
        listOfArmours.add(new Armour(2L,"dave",450,"head","warlock"));

        List<ArmourDto> listOfArmourDtos = new ArrayList<>();
        listOfArmourDtos.add(new ArmourDto(1L,"bob",123,"arm","titan"));
        listOfArmourDtos.add(new ArmourDto(2L,"dave",450,"head","warlock"));

        Mockito.when(armourRepository.findAll()).thenReturn(listOfArmours);
        assertEquals(listOfArmourDtos.get(1).getId(), armourService.getArmours().get(1).getId());
        assertEquals(listOfArmourDtos.get(0).getCharClass(), armourService.getArmours().get(0).getCharClass());
    }

    @Test
    public void getArmourTest() {
        Long id = 1L;
        Armour armour= new Armour(id,"bob",123,"arm","titan");
        ArmourDto armourDto = new ArmourDto(id,"bob",123,"arm","titan");

        Mockito.when(armourRepository.getOne(id)).thenReturn(armour);
        assertEquals(armourDto.getLight(), armourService.getArmour(id).getLight());

    }



    @Test
    public void updateArmourTest() {
        ArmourDto dto = new ArmourDto();
        dto.setId(1L);
        dto.setName("bob");
        dto.setLight(123);
        dto.setSlot("arm");
        dto.setCharClass("titan");
        Armour armour = new Armour(1L,"dave",123,"arm","titan");

        Mockito.when(armourRepository.getOne(dto.getId())).thenReturn(armour);
        assertEquals("bob", armourService.updateArmour(armour.getId(), dto).getName());
        assertEquals((Long) 1L, armourService.updateArmour(armour.getId(), dto).getId());
    }

    @Test
    public void deleteArmourTest() {
        Long id = 1L;
        Armour armour = new Armour(id,"bob",123,"arm","titan");
        Mockito.when(armourRepository.getOne(id)).thenReturn(armour);

        assertEquals("arm", armourService.deleteArmour(id).getSlot());
        verify(armourRepository, Mockito.times(1)).deleteById(id);
    }
}
