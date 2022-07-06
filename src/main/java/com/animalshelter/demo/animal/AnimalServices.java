package com.animalshelter.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServices {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
     //CRUD OPERATIONS
    public void addAnimal(Animal animal) throws Exception{
        Optional<Animal> animalById=animalRepository.findById(animal.getId());
        if(animalById.isPresent()){
            throw new IllegalStateException("Animal by this ID is already present");
        }
        animalRepository.save(animal);
    }

    public List<Animal> getAnimals(){
            return animalRepository.findAll();
    }

}
