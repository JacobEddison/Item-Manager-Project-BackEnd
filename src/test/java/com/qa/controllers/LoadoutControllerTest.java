package com.qa.controllers;

import com.qa.models.Loadout;
import com.qa.repository.LoadoutRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoadoutControllerTest {

    @InjectMocks
    private LoadoutController loadoutController;

    @Mock
    private LoadoutRepository repository;

    @LocalServerPort
    private int port;

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
//        assertEquals(loadoutController.listAllLoadout().get(0).getArmId(),3L);
//
//    }
//
//    @Test
//    public void testGetLoadout(){
//        Loadout loadout = new Loadout();
//        loadout.setHelmetId(10L);
//
//        when(repository.findOne(0L)).thenReturn(loadout);
//
//        long test = 10L;
//
//        assertEquals(loadoutController.getLoadout(0L).getHelmetId(), test);
//
//    }

    @Test
    public void testSetLoadout(){

    }

    @Test
    public void testDeleteLoadout(){

    }

    @Test
    public void testUpdateLoadout(){

    }
}
