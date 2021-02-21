package com.pets.web.request;

import java.io.Serializable;

public class DogRequest implements Serializable {

  private String id;
  private String name;
  private int age;
  private DogBreedRequest breed;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public DogBreedRequest getBreed() {
    return breed;
  }

  public void setBreed(DogBreedRequest breed) {
    this.breed = breed;
  }
}
