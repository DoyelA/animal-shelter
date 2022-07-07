package com.animalshelter.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AnimalServices {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServices(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
     //CRUD OPERATIONS
    public void addAnimal(Animal animal) throws Exception{              //CREATE
        Optional<Animal> animalById=animalRepository.findById(animal.getId());
        if(animalById.isPresent()){
            throw new IllegalStateException("Animal by this ID is already present");
        }
        animalRepository.save(animal);
    }

    public List<Animal> getAnimals(){                     //READ
            return animalRepository.findAll();
    }
    @Transactional
    public void updateAnimal(Long id, String name, String species){             //UPDATE
        Animal animal=animalRepository.findById(id).orElseThrow(()-> new IllegalStateException("Animal does not exist"));
        if(name!=null&&name.length()>0&&!Objects.equals(animal.getName(),name)){
            animal.setName(name);
        }
        if(species!=null&&species.length()>0&&!Objects.equals(animal.getSpecies(),species)) {
            animal.setSpecies(species);
        }
        animalRepository.save(animal);
    }

    public void deleteAnimal(Long id){
        boolean exists=animalRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Animal doesn't exist in database");
        }
        animalRepository.deleteById(id);
    }
}
