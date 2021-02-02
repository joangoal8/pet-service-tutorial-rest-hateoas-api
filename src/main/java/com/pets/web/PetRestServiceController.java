package com.pets.web;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.web.mapper.PetServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "pet-service/v1", consumes = PetRestServiceConstants.JSON_CONTENT_TYPE)
public class PetRestServiceController {

    private final PetServiceMapper petServiceMapper;

    @Autowired
    public PetRestServiceController(PetServiceMapper petServiceMapper) {
        this.petServiceMapper = petServiceMapper;
    }

    @GetMapping(value = "/ping")
    public String ping() {
        return PetRestServiceConstants.PONG_MESSAGE;
    }

    @GetMapping(value = "/dogs/{uuid]")
    public Dog getDog(@PathVariable("uuid") String uuid) {
        return new Dog();
    }

    @GetMapping(value = "/dogs")
    public List<Dog> getDogs(@PathVariable("uuid") String uuid) {
        return Collections.emptyList();
    }

    @PostMapping(value = "/dogs")
    public List<DogBreed> deleteDogBreeds(@PathVariable("uuid") String breedUuid) {
        return Collections.emptyList();
    }

    @DeleteMapping(value = "/dogs/breeds/{uuid}")
    public List<DogBreed> deleteDogBreeds(@PathVariable("uuid") String breedUuid) {
        return Collections.emptyList();
    }
}
