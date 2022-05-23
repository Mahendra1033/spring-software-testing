package com.learntolead.test.service;

import com.learntolead.test.entity.Alien;
import com.learntolead.test.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienService {

    @Autowired
    private AlienRepository alienRepository;

    public Alien saveAlien(Alien alien) {
        return alienRepository.save(alien);
    }

    public List<Alien> findAll() {
        return alienRepository.findAll();
    }

    public Alien getAlienById(int id) {
        return alienRepository.findById(id).orElseGet(()->new Alien());
    }

    public Alien updateAlien(Alien alien) {
        Alien obj = alien;
        return alienRepository.save(alien);
    }

    public String deleteById(int id) {
        alienRepository.deleteById(id);
        return "Deleted Successfully" ;
    }

    public List<Alien> getAlienByName(String name) {
        return alienRepository.findByName(name);
    }

    public List<Alien> getAlienByGender(String gender) {
        return alienRepository.getByAlienGender(gender);
    }
}
