package com.learntolead.test.controller;

import com.learntolead.test.entity.Alien;
import com.learntolead.test.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AlienController {

    @Autowired
    private AlienService alienService;

    @PostMapping("/saveAlien")
    public Alien saveAlien(@RequestBody Alien alien) {
        Alien aliens = new Alien();
        return alienService.saveAlien(alien);
    }

    @GetMapping("/findAll")
    public List<Alien> findAll() {
        return alienService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Alien getAlienById(@PathVariable int id) {
        return alienService.getAlienById(id);
    }

    @PutMapping("/updateAlien")
    public Alien getAlienById(@RequestBody Alien alien) {
        return alienService.updateAlien(alien);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteAlienById(@PathVariable int id) {
        return alienService.deleteById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<Alien> getAlienByName(@PathVariable String name){
        return alienService.getAlienByName(name);
    }

    @GetMapping("/getByGender/{gender}")
    public List<Alien> getByGender(@PathVariable String gender){
        return alienService.getAlienByGender(gender);
    }

}
