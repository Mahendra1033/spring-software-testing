package com.learntolead.test.repository;

import com.learntolead.test.entity.Alien;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AlienRepositoryTest {

    @Autowired
    private AlienRepository underTest;

    @Test
    public void testFindByName() {
        //given
        String name = "Mahendra";
        List<Alien> aliens = Stream.of(
                new Alien(1, "Mahendra", "mahendra@gmail.com", "Male"),
                new Alien(2, "Mahendra", "ironman@gmail.com", "Male"),
                new Alien(3, "Captain", "captain@gmail.com", "Male")
        ).collect(Collectors.toList());
        underTest.saveAll(aliens);
        List<Alien> expectedOne = aliens.stream().filter(list -> list.getName().equals("Mahendra")).collect(Collectors.toList());
        System.out.println("EXPECTED : " + expectedOne);
        int expectedTwo = aliens.size() - 1;
        //when
        List<Alien> actualOne = underTest.findByName(name);
        int actualTwo = actualOne.size();
        //then
        assertEquals(expectedOne, actualOne);
    }
}
