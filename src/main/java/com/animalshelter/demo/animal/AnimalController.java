package com.animalshelter.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/animal")
public class AnimalController {
    @Autowired
    private final AnimalServices animalServices;

    public AnimalController(AnimalServices animalServices) {
        this.animalServices = animalServices;
    }

    @GetMapping(path="/browse")
    public List<Animal> browseShelter(){
        return animalServices.getAnimals();
    }

    @PostMapping
    public void rescueAnimal(@RequestBody Animal animal) throws Exception {
        animalServices.addAnimal(animal);
    }


}
