package com.pets.web;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.service.PetService;
import com.pets.web.mapper.PetServiceMapper;
import com.pets.web.request.DogBreedRequest;
import com.pets.web.request.DogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "pet-service/v1", consumes = PetRestServiceConstants.JSON_CONTENT_TYPE)
public class PetRestServiceController {

    private final PetServiceMapper petServiceMapper;
    private final PetService petService;

    @Autowired
    public PetRestServiceController(PetServiceMapper petServiceMapper, PetService petService) {
        this.petServiceMapper = petServiceMapper;
        this.petService = petService;
    }

    @GetMapping(value = "/ping")
    public String ping() {
        return PetRestServiceConstants.PONG_MESSAGE;
    }

    @GetMapping(value = "/dogs/{uuid}")
    public Dog getDog(@PathVariable("uuid") String uuid) {
        return new Dog();
    }

    @GetMapping(value = "/dogs")
    public List<Dog> getDogs() {
        return Collections.emptyList();
    }

    @PostMapping(value = "/dogs")
    public List<Dog> createDog(DogRequest dogRequest) {
        return Collections.emptyList();
    }

    @DeleteMapping(value = "/dogs/breeds/{uuid}")
    public List<DogBreed> deleteDogBreeds(@PathVariable("uuid") String breedUuid) {
        return Collections.emptyList();
    }

    @PutMapping(value = "/dogs/{uuid}")
    public Dog updateDog(@PathVariable("uuid") String uuid, @RequestBody DogRequest dogRequest) {
        return new Dog();
    }

    @PatchMapping(value = "/dogs/{uuid}")
    public Dog partialUpdateDog(@PathVariable("uuid") String uuid, @RequestBody DogBreedRequest dogBreedRequest) {
        return new Dog();
    }

    @GetMapping(value = "/dogs")
    public List<Dog> sortDogs(@RequestParam(name = "sort") String ageSortCondition) {
        return Collections.emptyList();
    }

    @GetMapping(value = "/dogs")
    public List<Dog> filterDogs(@RequestParam(name = "filter") String dogNameBreed) {
        return Collections.emptyList();
    }

    @GetMapping(value = "/dogs/breeds/")
    public DogBreed searchDogBreedsByName(@RequestParam(name = "search") String name) {
        return new DogBreed();
    }

    @GetMapping(value = "/dogs")
    public List<Dog> dogPagination(@RequestParam(name = "page") int paginationNum) {
        return Collections.emptyList();
    }
}
