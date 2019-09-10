package com.qa.controllers;

import com.qa.models.Armour;
import com.qa.repository.ArmourRepository;
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
public class ArmourControllerTest {

    @InjectMocks
    private ArmourController armourController;

    @Mock
    private ArmourRepository repository;

    @LocalServerPort
    private int port;

    @Test
    public void testGetAllArmour(){
        List<Armour> armourList = new ArrayList<>();
        Armour armour = new Armour();
        armour.setName("dave");
        armour.setLight(700);
        armour.setCharClass("titan");
        armourList.add(armour);

        when(repository.findAll()).thenReturn(armourList);

        assertEquals(armourController.listAllArmour().get(0).getName(),"dave");

    }

    @Test
    public void testGetArmour(){

        Armour armour = new Armour();
        armour.setName("bob");
        armour.setLoadoutId(10L);
        armour.setLight(100);

        when(repository.findOne(0L)).thenReturn(armour);

        assertEquals(armourController.getArmour(0L).getName(),"bob");
        assertEquals(armourController.getArmour(0L).getLight(), 100);
        //assertEquals(armourController.getArmour(0L).getLoadoutId(), 10L);

    }

    @Test
    public void testCreateArmour(){
        Armour armour = new Armour();
        armour.setName("nuyce");
        armour.setLight(250);

        when(repository.saveAndFlush(armour)).thenReturn(armour);

        assertEquals(armourController.addArmour(armour).getName(),"nuyce");
        assertEquals(armourController.addArmour(armour).getLight(),250);

    }

    @Test
    public void testDeleteArmour(){
        Armour armour = new Armour();
        armour.setName("nuyce");
        armour.setLight(250);

        when(repository.findOne(0L)).thenReturn(armour);

        assertEquals(armourController.deleteArmour(0L).getName(), "nuyce");
    }

    @Test
    public void testUpdateArmour(){

    }
}
