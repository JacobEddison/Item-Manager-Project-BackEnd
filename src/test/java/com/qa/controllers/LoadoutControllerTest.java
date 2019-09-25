package com.qa.controllers;

import com.qa.dto.LoadoutDto;
import com.qa.persistence.models.Loadout;
import com.qa.persistence.repository.LoadoutRepository;
import com.qa.service.LoadoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoadoutControllerTest {

    @InjectMocks
    private LoadoutController loadoutController;

    @Mock
    private LoadoutService loadoutService;

    @Test
    public void getLoadoutsTest() {
        List<LoadoutDto> loadoutDtos = new ArrayList<>();
        loadoutDtos.add(new LoadoutDto(1L,1L,2L,3L,4L,5L));
        loadoutDtos.add(new LoadoutDto(2L,6L,7L,8L,9L,10L));

        Mockito.when(loadoutService.getLoadouts()).thenReturn(loadoutDtos);

        assertEquals(HttpStatus.OK, loadoutController.getLoadouts().getStatusCode());
    }


    @Test
    public void createLoadoutTest() {
        LoadoutDto dto = new LoadoutDto(1L,1L,2L,3L,4L,5L);
        Mockito.when(loadoutService.createLoadout(dto)).thenReturn(new LoadoutDto(1L,1L,2L,3L,4L,5L));

        assertEquals((Long) 2L, loadoutController.createLoadout(dto).getBody().getArmId());
        assertEquals(HttpStatus.CREATED, loadoutController.createLoadout(dto).getStatusCode());
    }


    @Test
    public void updateLoadoutTest() {
        LoadoutDto dto = new LoadoutDto(1L,1L,2L,3L,4L,5L);
        LoadoutDto dto2 = new LoadoutDto(1L,1L,2L,7L,4L,5L);
        Mockito.when(loadoutService.updateLoadout(dto.getId(),dto2)).thenReturn(dto2);

        assertEquals((Long) 7L, loadoutController.updateLoadout(dto.getId(),dto2).getBody().getChestId());
        assertEquals(HttpStatus.ACCEPTED, loadoutController.updateLoadout(dto.getId(),dto2).getStatusCode());
    }

    @Test
    public void deleteLoadoutTest() {
        Long id = 1L;
        LoadoutDto dto = new LoadoutDto(1L,1L,2L,3L,4L,5L);
        Mockito.when(loadoutService.deleteLoadout(id)).thenReturn(dto);

        assertEquals((Long) 1L, loadoutController.deleteLoadout(id).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, loadoutController.deleteLoadout(id).getStatusCode());

    }

//    @Mock
//    private LoadoutRepository repository;
//
//    @LocalServerPort
//    private int port;
//
//    @Test
//    public void testGetAllLoadouts(){
//        List<Loadout> loadoutList = new ArrayList<>();
//        Loadout loadout = new Loadout();
//        loadout.setHelmetId(2L);
//        loadout.setArmId(3L);
//        loadout.setChestId(4L);
//        loadout.setLegId(5L);
//        loadout.setMarkId(6L);
//
//        loadoutList.add(loadout);
//
//        when(repository.findAll()).thenReturn(loadoutList);
//
//        assertEquals(loadoutController.listAllLoadout().get(0).getArmId(), Long.valueOf(3));
//
//    }
//
//    @Test
//    public void testGetLoadout(){
//        Loadout loadout = new Loadout();
//        loadout.setHelmetId(10L);
//
//        when(repository.getOne(0L)).thenReturn(loadout);
//
//        assertEquals(loadoutController.getLoadout(0L).getHelmetId(), Long.valueOf(10));
//
//    }
//
//    @Test
//    public void testSetLoadout(){
//        Loadout loadout = new Loadout();
//        loadout.setLegId(7L);
//        loadout.setMarkId(8L);
//
//        when(repository.saveAndFlush(loadout)).thenReturn(loadout);
//
//        assertEquals(loadoutController.addLoadout(loadout).getLegId(), Long.valueOf(7));
//    }
//
//    @Test
//    public void testDeleteLoadout(){
//        Loadout loadout = new Loadout();
//        loadout.setHelmetId(5L);
//        loadout.setChestId(7L);
//
//        when(repository.getOne(0L)).thenReturn(loadout);
//
//        assertEquals(loadoutController.deleteLoadout(0L).getChestId(), Long.valueOf(7));
//    }
//
//    @Test
//    public void testUpdateLoadout(){
//        Loadout loadout1 = new Loadout();
//        loadout1.setArmId(4L);
//        loadout1.setLegId(6L);
//        Loadout loadout2 = new Loadout();
//        loadout2.setArmId(12L);
//        loadout2.setLegId(14L);
//
//        when(repository.getOne(0L)).thenReturn(loadout1);
//        when(repository.saveAndFlush(loadout1)).thenReturn(loadout1);
//
//        assertEquals(loadoutController.updateLoadout(0L,loadout2).getLegId(), Long.valueOf(14));
//        assertEquals(loadoutController.updateLoadout(0L,loadout2).getArmId(), Long.valueOf(12));
//
//    }
}
