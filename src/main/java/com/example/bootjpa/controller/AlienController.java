package com.example.bootjpa.controller;

import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("/")
    public String home(){

        return "home";
    }
    @PostMapping("/addAlien")
    public String addAlien(Alien alien){
         repo.save(alien);
        return "home";
    }

    @GetMapping("/getAlienForm")
    public String showForm(){
        return "getAlienForm";
    }
/*
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showAlien");
       Alien alien = repo.findById(aid).orElse(new Alien());
       System.out.println(repo.findByTech("java"));
       System.out.println(repo.findByAidGreaterThan(102));
       System.out.println(repo.findByTechSorted("java"));
       mv.addObject(alien);
       return mv;
    }
*/
     @GetMapping("/aliens")
     public List<Alien> getAliens(){

        return repo.findAll();
     }
    @GetMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){

        return repo.findById(aid);
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }
}
