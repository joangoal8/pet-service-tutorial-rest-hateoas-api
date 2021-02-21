package com.pets.service;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.model.DogQueryCondition;
import com.pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;

  @Autowired
  public PetServiceImpl(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public Dog getDogByUuid(String uuid) {
    return petRepository.retrieveDogByUuid(uuid);
  }

  @Override
  public List<Dog> getDogs(DogQueryCondition dogQueryCondition) {
    List<Dog> dogs = petRepository.retrieveAllDogs();
    if (Objects.nonNull(dogQueryCondition)) {
      dogs = applyQueryCondition(dogs, dogQueryCondition);
    }
    return dogs;
  }

  private List<Dog> applyQueryCondition(List<Dog> dogs, DogQueryCondition dogQueryCondition) {
    sortDogs(dogQueryCondition, dogs);
    List<Dog> queryDogs = filteringDogs(dogQueryCondition, dogs);
    queryDogs = searchDog(dogQueryCondition, queryDogs);
    return paginateDogs(dogQueryCondition, queryDogs);
  }

  private void sortDogs(DogQueryCondition dogQueryCondition, List<Dog> dogs) {
    if (Objects.nonNull(dogQueryCondition.getSortCondition())) {
      switch (dogQueryCondition.getSortCondition()) {
        case "name":
          dogs.sort(Dog.nameComparator);
          break;
        case "age":
          dogs.sort(Dog.ageComparator);
          break;
        default:
          break;
      }
    }
  }

  private  List<Dog> filteringDogs(DogQueryCondition dogQueryCondition, List<Dog> queryDogs) {
    List<Dog> listedDogs = new ArrayList<>(queryDogs);
    if (Objects.nonNull(dogQueryCondition.getDogNameBreed())) {
      listedDogs = queryDogs.stream().filter( dog ->
        dogQueryCondition.getDogNameBreed().equals(dog.getBreed().getName())).collect(Collectors.toList());
    }
    return listedDogs;
  }

  private List<Dog> searchDog(DogQueryCondition dogQueryCondition, List<Dog> dogs) {
    List<Dog> searchDogs = new ArrayList<>(dogs);
    if (Objects.nonNull(dogQueryCondition.getDogName())) {
      searchDogs = dogs.stream().filter(dog ->
        dogQueryCondition.getDogName().equals(dog.getName())).collect(Collectors.toList());
    }
    return searchDogs;
  }

  private List<Dog> paginateDogs(DogQueryCondition dogQueryCondition, List<Dog> dogs) {
    List<Dog> paginateDogs = new ArrayList<>(dogs);
    if (dogQueryCondition.getEndPage() > 0) {
      paginateDogs = dogs.subList(dogQueryCondition.getIniPage(), dogQueryCondition.getEndPage());
    }
    return paginateDogs;
  }

  @Override
  public List<Dog> createDog(Dog newDog) {
    return petRepository.insertDog(newDog);
  }

  @Override
  public List<Dog> deleteDog(String dogUuid) {
    return petRepository.removeDog(dogUuid);
  }

  @Override
  public Dog updateDog(String uuid, Dog dog) {
    return petRepository.updateFullDog(uuid, dog);
  }

  @Override
  public Dog partialUpdateDog(String uuid, DogBreed dogBreed) {
    return petRepository.updatePartialDogInfo(uuid, dogBreed);
  }
}
