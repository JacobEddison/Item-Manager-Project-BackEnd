package com.qa.service;

import com.qa.dto.LoadoutDto;
import com.qa.persistence.models.Loadout;
import com.qa.persistence.repository.LoadoutRepository;
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
public class LoadoutServiceTest {

    @Mock
    private LoadoutRepository loadoutRepository;

    @InjectMocks
    private LoadoutService loadoutService;

    @Test
    public void getLoadoutsTest() {
        List<Loadout> listOfLoadouts = new ArrayList<>();
        listOfLoadouts.add(new Loadout(1L,1L,2L,3L,4L,5L));
        listOfLoadouts.add(new Loadout(2L,6L,7L,8L,9L,10L));

        List<LoadoutDto> listOfLoadoutDtos = new ArrayList<>();
        listOfLoadoutDtos.add(new LoadoutDto(1L,1L,2L,3L,4L,5L));
        listOfLoadoutDtos.add(new LoadoutDto(2L,6L,7L,8L,9L,10L));

        Mockito.when(loadoutRepository.findAll()).thenReturn(listOfLoadouts);
        assertEquals(listOfLoadoutDtos.get(1).getId(), loadoutService.getLoadouts().get(1).getId());
        assertEquals(listOfLoadoutDtos.get(1).getMarkId(), loadoutService.getLoadouts().get(1).getMarkId());
    }

    @Test
    public void getLoadoutTest() {
        Long id = 1L;
        Loadout loadout= new Loadout(id,1L,2L,3L,4L,5L);
        LoadoutDto loadoutDto = new LoadoutDto(id,1L,2L,3L,4L,5L);

        Mockito.when(loadoutRepository.getOne(id)).thenReturn(loadout);
        assertEquals(loadoutDto.getChestId(), loadoutService.getLoadout(id).getChestId());

    }


    @Test
    public void updateLoadoutTest() {
        LoadoutDto dto = new LoadoutDto();
        dto.setId(1L);
        dto.setHelmetId(1L);
        dto.setArmId(2L);
        dto.setChestId(3L);
        dto.setLegId(4L);
        dto.setMarkId(5L);
        Loadout loadout = new Loadout(1L,1L,2L,3L,9L,5L);

        Mockito.when(loadoutRepository.getOne(dto.getId())).thenReturn(loadout);
        assertEquals((Long) 4L, loadoutService.updateLoadout(loadout.getId(), dto).getLegId());
        assertEquals((Long) 1L, loadoutService.updateLoadout(loadout.getId(), dto).getId());
    }

    @Test
    public void deleteLoadoutTest() {
        Long id = 1L;
        Loadout loadout = new Loadout(id,1L,2L,3L,4L,5L);
        Mockito.when(loadoutRepository.getOne(id)).thenReturn(loadout);

        assertEquals((Long) 3L, loadoutService.deleteLoadout(id).getChestId());
        verify(loadoutRepository, Mockito.times(1)).deleteById(id);
    }
}
