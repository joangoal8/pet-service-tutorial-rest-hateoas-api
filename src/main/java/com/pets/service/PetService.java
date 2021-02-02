package com.pets.service;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.web.request.DogRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PetService {

  Dog getDogByUuid(String uuid);

  List<Dog> getDogs();

  List<Dog> createDog(Dog newDog);

  List<DogBreed> deleteDogBreeds(String breedUuid);

  Dog updateDog(String uuid, Dog dog);

  Dog partialUpdateDog(String uuid, DogBreed dogBreed);

  List<Dog> sortDogs(String sortCondition);

  List<Dog> filterDogs(String filterCondition);

  List<Dog> searchDogs(String name);

  List<Dog> paginateDogs(int paginationNum);
}
