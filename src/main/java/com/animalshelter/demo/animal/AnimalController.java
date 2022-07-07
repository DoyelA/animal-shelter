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

    @PostMapping(path="/add")
    public void rescueAnimal(@RequestBody Animal animal) throws Exception {
        animalServices.addAnimal(animal);
    }

    @PutMapping(path="/update/{id}")
    public void editDetails(@PathVariable("id") Long id, @RequestParam(required=false) String name, @RequestParam(required=false) String species){
        animalServices.updateAnimal(id, name, species);
    }

    @DeleteMapping(path="delete/{id}")
    public void adoptAnimal(@PathVariable("id") Long id){
        animalServices.deleteAnimal(id);
    }


}

//issues: cannot add new animal unless we pass whole Animal body, but sequence generator should permit us to pass without an id. Look into this.
        //when we pass id, we still get automatically generated id.
        //