package com.learntolead.test.service;

import com.learntolead.test.entity.Alien;
import com.learntolead.test.repository.AlienRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AlienServiceTest {

    @Autowired
    private AlienService underTest;

    @MockBean
    private AlienRepository alienRepository;

    @Test
    public void testFindAllMethod(){
        //given
        List<Alien> aliens = Stream.of(
                new Alien(101,"Mahendra","mahendra@gmail.com","Male"),
                new Alien(102,"Iron Man","ironman@gmail.com","Male"),
                new Alien(103,"Captain","captain@gmail.com","Male")
                ).collect(Collectors.toList());
        int expected = aliens.size();
        //when
        when(alienRepository.findAll()).thenReturn(aliens);
        int actual = underTest.findAll().size();
        List<Alien> aliens1 = underTest.findAll();
        System.out.println(aliens1);
        // then
        assertThat(actual).isEqualTo(expected);
        //System.out.println(aliens);
    }

    @Test
    public void testGetAlienById(){
        //given
        int id = 101;
        List<Alien> aliens = Stream.of(
                new Alien(101,"Mahendra","mahendra@gmail.com","Male"),
                new Alien(102,"Iron Man","ironman@gmail.com","Male"),
                new Alien(103,"Captain","captain@gmail.com","Male")
        ).collect(Collectors.toList());
        //when
        when(alienRepository.findById(id)).thenReturn(Optional.ofNullable((aliens.get(0))));
        //then
        assertEquals(aliens.get(0),underTest.getAlienById(id));
    }
}
