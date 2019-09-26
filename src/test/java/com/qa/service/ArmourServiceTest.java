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
        List<Armour> listOfArmours = new ArrayList<Armour>();
        listOfArmours.add(new Armour(1L,"bob",123,"arm","titan",3L));
        listOfArmours.add(new Armour(2L,"dave",450,"head","warlock",4L));

        List<ArmourDto> listOfArmourDtos = new ArrayList<ArmourDto>();
        listOfArmourDtos.add(new ArmourDto(1L,"bob",123,"arm","titan",3L));
        listOfArmourDtos.add(new ArmourDto(2L,"dave",450,"head","warlock",4L));

        Mockito.when(armourRepository.findAll()).thenReturn(listOfArmours);
        assertEquals(listOfArmourDtos.get(1).getId(), armourService.getArmours().get(1).getId());
        assertEquals(listOfArmourDtos.get(1).getCharClass(), armourService.getArmours().get(1).getCharClass());
    }


    @Test
    public void updateArmourTest() {
        ArmourDto dto = new ArmourDto(1L,"bob",123,"arm","titan",3L);
        Armour armour = new Armour(1L,"dave",123,"arm","titan",3L);

        Mockito.when(armourRepository.getOne(dto.getId())).thenReturn(armour);
        assertEquals("bob", armourService.updateArmour(armour.getId(), dto).getName());
        assertEquals((Long) 1L, armourService.updateArmour(armour.getId(), dto).getId());
    }

    @Test
    public void deleteArmourTest() {
        Long id = 1L;
        Armour armour = new Armour(id,"bob",123,"arm","titan",3L);
        Mockito.when(armourRepository.getOne(id)).thenReturn(armour);

        assertEquals("arm", armourService.deleteArmour(id).getSlot());
        verify(armourRepository, Mockito.times(1)).deleteById(id);
    }
}
