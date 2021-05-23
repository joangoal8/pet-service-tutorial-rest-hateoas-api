package com.pets.web;

import com.pets.model.Dog;
import com.pets.model.Owner;
import com.pets.service.PetService;
import com.pets.web.mapper.PetServiceMapper;
import com.pets.web.request.DogBreedRequest;
import com.pets.web.request.DogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
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
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/pet-service/v1",
  produces = PetRestServiceConstants.JSON_CONTENT_TYPE)
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
        return petService.getDogByUuid(uuid);
    }

    @PostMapping(value = "/dogs")
    public List<Dog> createDog(@RequestBody DogRequest dogRequest) {
        return petService.createDog(petServiceMapper.mapDog(dogRequest));
    }

    @DeleteMapping(value = "/dogs/{uuid}")
    public List<Dog> deleteDogBreeds(@PathVariable("uuid") String dogUuid) {
        return petService.deleteDog(dogUuid);
    }

    @PutMapping(value = "/dogs/{uuid}")
    public Dog updateDog(@PathVariable("uuid") String uuid, @RequestBody DogRequest dogRequest) {
        return petService.updateDog(uuid, petServiceMapper.mapDog(dogRequest));
    }

    @PatchMapping(value = "/dogs/{uuid}")
    public Dog partialUpdateDog(@PathVariable("uuid") String uuid, @RequestBody DogBreedRequest dogBreedRequest) {
        return petService.partialUpdateDog(uuid, petServiceMapper.mapDogBreed(dogBreedRequest));
    }

    @GetMapping(value = "/dogs")
    public List<Dog> getDogs(@RequestParam(name = "sort", required = false) String sortCondition,
                             @RequestParam(name = "filter", required = false) String dogNameBreed,
                             @RequestParam(name = "search", required = false) String name,
                             @RequestParam(name = "iniPage", required = false) Integer iniPageNum,
                             @RequestParam(name = "endPage", required = false) Integer endPageNum) {
        return petService.getDogs(petServiceMapper.map(sortCondition, dogNameBreed, name, iniPageNum, endPageNum));
    }

    @GetMapping(value = "/owners/{uuid}")
    public CollectionModel<Owner> getOwner(@PathVariable("uuid") String uuid) {
        Owner owner = petService.getOwnerByUuid(uuid);
        Link dogsLinks = linkTo(methodOn(PetRestServiceController.class)
          .getDogsOwner(uuid)).withRel("ownerDogs");
        return Objects.isNull(owner) ? CollectionModel.of(Collections.emptyList())
          : CollectionModel.of(Collections.singletonList(owner), dogsLinks);
    }

    @GetMapping(value = "/owners/{uuid}/dogs")
    public CollectionModel<Dog> getDogsOwner(@PathVariable("uuid") String uuid) {
        List<Dog> dogs = petService.getOwnerDogs(uuid);
        dogs.forEach(dog -> {
            Link selfLink = linkTo(methodOn(PetRestServiceController.class)
              .getDog(dog.getId())).withSelfRel();
            dog.add(selfLink);
        });
        return CollectionModel.of(dogs);
    }

}
