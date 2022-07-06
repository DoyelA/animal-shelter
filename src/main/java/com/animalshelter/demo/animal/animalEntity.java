package com.animalshelter.demo.animal;

public class animalEntity {
    private Long id;
    private String name;
    private String species;

    public animalEntity(Long id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public animalEntity() {
    }

    public animalEntity(String name, String species) {
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
