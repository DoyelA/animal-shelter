package com.animalshelter.demo.animal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AnimalConfig {
    @Bean
    CommandLineRunner commandLineRunner(AnimalRepository repository){
        return args->{
                Animal lola=new Animal(
                        1L,
                        "Lola",
                        "Cat"
                );

                Animal magic=new Animal(
                        2L,
                        "Magic",
                        "Beagle"
                );
            repository.saveAll(List.of(lola,magic));
        };
    }
}
