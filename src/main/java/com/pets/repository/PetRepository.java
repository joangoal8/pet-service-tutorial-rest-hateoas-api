package com.pets.repository;

import com.pets.model.Dog;
import com.pets.model.DogBreed;

import java.util.List;

public interface PetRepository {

  Dog retrieveDogByUuid(String uuid);

  List<Dog> retrieveAllDogs();

  List<Dog> insertDog(Dog dog);

  List<Dog> removeDog(String dogUuid);

  Dog updateFullDog(String uuid, Dog dog);

  Dog updatePartialDogInfo(String uuid, DogBreed dogBreed);
}
