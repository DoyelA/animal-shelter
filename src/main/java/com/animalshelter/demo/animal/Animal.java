package com.animalshelter.demo.animal;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="animaldetails")
public class Animal {

    @Id
    @SequenceGenerator(
            name="animal_sequence",
            sequenceName = "animal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=SEQUENCE,
            generator="animal_sequence"
    )
    private Long id;
    private String name;
    private String species;

    public Animal(Long id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public Animal() {
    }

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "animalEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
