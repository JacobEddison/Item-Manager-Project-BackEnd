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

    @Test
    public void testGetAllLoadouts(){
        List<Loadout> loadoutList = new ArrayList<>();
        Loadout loadout = new Loadout();
        loadout.setHelmetId(2L);
        loadout.setArmId(3L);
        loadout.setChestId(4L);
        loadout.setLegId(5L);
        loadout.setMarkId(6L);

        loadoutList.add(loadout);

        when(repository.findAll()).thenReturn(loadoutList);

        assertEquals(loadoutController.listAllLoadout().get(0).getArmId(),new Long(3));

    }

    @Test
    public void testGetLoadout(){
        Loadout loadout = new Loadout();
        loadout.setHelmetId(10L);

        when(repository.findOne(0L)).thenReturn(loadout);

        assertEquals(loadoutController.getLoadout(0L).getHelmetId(), new Long(10));

    }

    @Test
    public void testSetLoadout(){
        Loadout loadout = new Loadout();
        loadout.setLegId(7L);
        loadout.setMarkId(8L);

        when(repository.saveAndFlush(loadout)).thenReturn(loadout);

        assertEquals(loadoutController.addLoadout(loadout).getLegId(),new Long(7));
    }

    @Test
    public void testDeleteLoadout(){
        Loadout loadout = new Loadout();
        loadout.setHelmetId(5L);
        loadout.setChestId(7L);

        when(repository.findOne(0L)).thenReturn(loadout);

        assertEquals(loadoutController.deleteLoadout(0L).getChestId(), new Long(7));
    }

    @Test
    public void testUpdateLoadout(){
        Loadout loadout1 = new Loadout();
        loadout1.setArmId(4L);
        loadout1.setLegId(6L);
        Loadout loadout2 = new Loadout();
        loadout2.setArmId(12L);
        loadout2.setLegId(14L);

        when(repository.findOne(0L)).thenReturn(loadout1);
        when(repository.saveAndFlush(loadout1)).thenReturn(loadout1);

        assertEquals(loadoutController.updateLoadout(0L,loadout2).getLegId(), new Long(14));
        assertEquals(loadoutController.updateLoadout(0L,loadout2).getArmId(), new Long(12));

    }
}
