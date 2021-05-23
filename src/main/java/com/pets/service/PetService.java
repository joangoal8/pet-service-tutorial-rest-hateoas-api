package com.pets.service;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.model.DogQueryCondition;
import com.pets.model.Owner;

import java.util.List;

public interface PetService {

  Dog getDogByUuid(String uuid);

  List<Dog> getDogs(DogQueryCondition queryCondition);

  List<Dog> createDog(Dog newDog);

  List<Dog> deleteDog(String dogUuid);

  Dog updateDog(String uuid, Dog dog);

  Dog partialUpdateDog(String uuid, DogBreed dogBreed);

  Owner getOwnerByUuid(String ownerUuid);

  List<Dog> getOwnerDogs(String ownerUuid);
}
