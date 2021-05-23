package com.pets.repository;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.model.Owner;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PetsRepositoryImpl implements PetRepository {

  private final Map<String, Dog> dogs = new HashMap<>();
  private final Set<DogBreed> dogBreeds = new HashSet<>();
  private final Set<Owner> owners = new HashSet<>();

  @PostConstruct
  public void initData() {
    String ownerUuid1 = "ownerUuid1";
    String ownerUuid2 = "ownerUuid2";

    String uuidHusky = "uuidDog1";
    DogBreed husky = DogBreed.builder().setName("Siberian Husky")
      .setFeatures("Independent, funny and energetic"). build();
    Dog huskyDog = Dog.builder().setId(uuidHusky)
      .setAge(2).setName("Lyanna")
      .setBreed(husky).setOwnerId(ownerUuid1).build();

    String uuidMalamute = "uuidDog2";
    DogBreed malamute = DogBreed.builder().setName("Alaskan malamute")
      .setFeatures("Independent, brave and tenant").build();
    Dog malamuteDog = Dog.builder().setId(uuidMalamute).setAge(3)
      .setName("Anuk").setBreed(malamute).setOwnerId(ownerUuid2).build();

    DogBreed boyeroBerna = DogBreed.builder().setName("Boyero Berna")
      .setFeatures("Giant, brave and loyal").build();
    String uuidBoyero = "uuidDog3";
    Dog boyeroBernaDog = Dog.builder().setId(uuidBoyero)
      .setAge(1).setName("Brandom").setBreed(boyeroBerna)
      .setOwnerId(ownerUuid2).build();

    Owner owner1 = Owner.builder().setId(ownerUuid1).setName("ownerName1")
      .setDogs(Collections.singletonList(huskyDog)).build();

    Owner owner2 = Owner.builder().setId(ownerUuid2).setName("ownerName2")
      .setDogs(Arrays.asList(malamuteDog, boyeroBernaDog)).build();

    dogs.put(uuidHusky, huskyDog);
    dogs.put(uuidMalamute, malamuteDog);
    dogs.put(uuidBoyero, boyeroBernaDog);

    dogBreeds.add(husky);
    dogBreeds.add(malamute);
    dogBreeds.add(boyeroBerna);

    owners.add(owner1);
    owners.add(owner2);
  }

  @Override
  public Dog retrieveDogByUuid(String uuid) {
    return dogs.get(uuid);
  }

  @Override
  public List<Dog> retrieveAllDogs() {
    return new ArrayList<>(dogs.values());
  }

  @Override
  public List<Dog> insertDog(Dog dog) {
    dogs.put(dog.getId(), dog);
    return new ArrayList<>(dogs.values());
  }

  @Override
  public List<Dog> removeDog(String dogUuid) {
    dogs.remove(dogUuid);
    return new ArrayList<>(dogs.values());
  }

  @Override
  public Dog updateFullDog(String uuid, Dog dog) {
    dogs.put(uuid, dog);
    return dogs.get(uuid);
  }

  @Override
  public Dog updatePartialDogInfo(String uuid, DogBreed dogBreed) {
    Dog dog = dogs.get(uuid);
    if (Objects.nonNull(dog)) {
      Dog updatedDog = Dog.builder().setId(dog.getId())
        .setName(dog.getName()).setAge(dog.getAge())
        .setBreed(dogBreed).build();
      dogs.put(uuid, updatedDog);
    }
    return dogs.get(uuid);
  }

  @Override
  public Owner retrieveOwnerByUuid(String ownerUuid) {
    return owners.stream().filter(owner -> ownerUuid.equals(owner.getId()))
      .findFirst().orElse(null);
  }

  @Override
  public List<Dog> retrieveOwnerDogs(String ownerUuid) {
    return dogs.values().stream().filter(dog -> ownerUuid.equals(dog.getOwnerId()))
      .collect(Collectors.toList());
  }

}
