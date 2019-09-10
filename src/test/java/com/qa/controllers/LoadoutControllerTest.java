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
    }
}
