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

    }

    @Test
    public void testGetArmour(){

    }

    @Test
    public void testCreateArmour(){

    }

    @Test
    public void testDeleteArmour(){

    }

    @Test
    public void testUpdateArmour(){

    }
}
