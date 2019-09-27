package com.qa.controllers;

import com.qa.dto.ArmourDto;
import com.qa.persistence.models.Armour;
import com.qa.persistence.repository.ArmourRepository;
import com.qa.service.ArmourService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArmourControllerTest {

    @InjectMocks
    private ArmourController armourController;

    @Mock
    private ArmourService armourService;

    @Test
    public void getArmoursTest() {
        List<ArmourDto> armourDtos = new ArrayList<>();
        armourDtos.add(new ArmourDto(1L,"bob",123,"arm","titan"));
        armourDtos.add(new ArmourDto(2L,"dave",450,"head","warlock"));

        Mockito.when(armourService.getArmours()).thenReturn(armourDtos);

        assertEquals(HttpStatus.OK, armourController.getArmours().getStatusCode());
    }

    @Test
    public void getArmourTest() {
        Long id = 1L;
        ArmourDto armourDto = new ArmourDto(id,"bob",123,"arm","titan");

        Mockito.when(armourService.getArmour(id)).thenReturn(armourDto);

        assertEquals(HttpStatus.OK, armourController.getArmour(id).getStatusCode());
    }


    @Test
    public void createArmourTest() {
        ArmourDto dto = new ArmourDto(1L,"dave",450,"head","warlock");
        Mockito.when(armourService.createArmour(dto)).thenReturn(new ArmourDto(1L,"dave",450,"head","warlock"));

        assertEquals("dave", armourController.createArmour(dto).getBody().getName());
        assertEquals(HttpStatus.CREATED, armourController.createArmour(dto).getStatusCode());
    }


    @Test
    public void updateArmourTest() {
        ArmourDto dto = new ArmourDto(1L,"dave",450,"head","warlock");
        ArmourDto dto2 = new ArmourDto(1L,"bob",450,"head","warlock");
        Mockito.when(armourService.updateArmour(dto.getId(),dto2)).thenReturn(dto2);

        assertEquals(450, armourController.updateArmour(dto.getId(),dto2).getBody().getLight());
        assertEquals(HttpStatus.ACCEPTED, armourController.updateArmour(dto.getId(),dto2).getStatusCode());
    }

    @Test
    public void deleteArmourTest() {
        Long id = 1L;
        ArmourDto dto = new ArmourDto(1L,"dave",450,"head","warlock");
        Mockito.when(armourService.deleteArmour(id)).thenReturn(dto);

        assertEquals((Long) 1L, armourController.deleteArmour(id).getBody().getId());
        assertEquals(HttpStatus.ACCEPTED, armourController.deleteArmour(id).getStatusCode());

    }

//    @Mock
//    private ArmourRepository repository;
//
//    @LocalServerPort
//    private int port;
//
//    @Test
//    public void testGetAllArmour(){
//        List<Armour> armourList = new ArrayList<>();
//        Armour armour = new Armour();
//        armour.setName("dave");
//        armour.setLight(700);
//        armour.setCharClass("titan");
//        armourList.add(armour);
//
//        when(repository.findAll()).thenReturn(armourList);
//
//        assertEquals(armourController.getArmours().get(0).getName(),"dave");
//
//    }
//
////    @Test
////    public void testGetArmour(){
////
////        Armour armour = new Armour();
////        armour.setName("bob");
////        armour.setLoadoutId(10L);
////        armour.setLight(100);
////
////        when(repository.getOne(0L)).thenReturn(armour);
////
////        assertEquals(armourController.getArmour(0L).getName(),"bob");
////        assertEquals(armourController.getArmour(0L).getLight(), 100);
////        //assertEquals(armourController.getArmour(0L).getLoadoutId(), 10L);
////
////    }
//
//    @Test
//    public void testCreateArmour(){
//        Armour armour = new Armour();
//        armour.setName("nuyce");
//        armour.setLight(250);
//
//        when(repository.saveAndFlush(armour)).thenReturn(armour);
//
//        assertEquals(armourController.createArmour(armour).getName(),"nuyce");
//        assertEquals(armourController.createArmour(armour).getLight(),250);
//
//    }
//
//    @Test
//    public void testDeleteArmour(){
//        Armour armour = new Armour();
//        armour.setName("nuyce");
//        armour.setLight(250);
//
//        when(repository.getOne(0L)).thenReturn(armour);
//
//        assertEquals(armourController.deleteArmour(0L).getName(), "nuyce");
//    }
//
//    @Test
//    public void testUpdateArmour(){
//        Armour armour1 = new Armour();
//        armour1.setName("dave");
//        armour1.setLight(700);
//        Armour armour2 = new Armour();
//        armour2.setName("bob");
//        armour2.setLight(650);
//
//        when(repository.getOne(0L)).thenReturn(armour1);
//        when(repository.saveAndFlush(armour1)).thenReturn(armour1);
//
//        assertEquals(armourController.updateArmour(0L,armour2).getName(), "bob");
//
//    }
}
