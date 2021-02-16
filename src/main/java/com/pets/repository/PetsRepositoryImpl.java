package com.pets.repository;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class PetsRepositoryImpl implements PetRepository {

  private final Map<String, Dog> dogs = new HashMap<>();
  private final Set<DogBreed> dogBreeds = new HashSet<>();

  @PostConstruct
  public void initData() {
    Dog huskyDog = new Dog();
    String uuidHusky = "uuidDog1";
    huskyDog.setId(uuidHusky);
    huskyDog.setAge(2);
    huskyDog.setName("Lyanna");
    DogBreed husky = new DogBreed();
    husky.setName("Siberian Husky");
    husky.setFeatures("Independent, funny and energetic");
    huskyDog.setBreed(husky);

    Dog malamuteDog = new Dog();
    String uuidMalamute = "uuidDog2";
    malamuteDog.setId(uuidMalamute);
    malamuteDog.setAge(3);
    malamuteDog.setName("Anuk");
    DogBreed malamute = new DogBreed();
    malamute.setName("Alaskan malamute");
    malamute.setFeatures("Independent, brave and tenant");
    malamuteDog.setBreed(malamute);

    Dog boyeroBernaDog = new Dog();
    String uuidBoyero = "uuidDog3";
    boyeroBernaDog.setId(uuidBoyero);
    boyeroBernaDog.setAge(1);
    boyeroBernaDog.setName("Brandom");
    DogBreed boyeroBerna = new DogBreed();
    boyeroBerna.setName("Boyero Berna");
    boyeroBerna.setFeatures("Giant, brave and loyal");
    boyeroBernaDog.setBreed(boyeroBerna);

    dogs.put(uuidHusky, huskyDog);
    dogs.put(uuidMalamute, malamuteDog);
    dogs.put(uuidBoyero, boyeroBernaDog);

    dogBreeds.add(husky);
    dogBreeds.add(malamute);
    dogBreeds.add(boyeroBerna);
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
  public List<DogBreed> removeDogBreeds(String dogBreedUuid) {
    dogBreeds.remove(dogBreedUuid);
    return new ArrayList<>(dogBreeds);
  }

  @Override
  public Dog updateFullDog(String uuid, Dog dog) {
    dogs.put(uuid, dog);
    return dogs.get(uuid);
  }

  @Override
  public Dog updatePartialDogInfo(String uuid, DogBreed dogBreed) {
    Dog updatedDog = dogs.get(uuid);
    updatedDog.setBreed(dogBreed);
    dogs.put(uuid, updatedDog);
    return dogs.get(uuid);
  }

}
