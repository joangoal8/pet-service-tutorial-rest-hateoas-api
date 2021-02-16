package com.pets.model;

import java.util.Comparator;

public class Dog {

  public static Comparator<Dog> nameComparator = Comparator.comparing(Dog::getName);
  public static Comparator<Dog> ageComparator = Comparator.comparingInt(Dog::getAge);

  private String id;
  private String name;
  private int age;
  private DogBreed breed;

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

  public DogBreed getBreed() {
    return breed;
  }

  public void setBreed(DogBreed breed) {
    this.breed = breed;
  }
}
