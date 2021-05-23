package com.pets.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Owner extends RepresentationModel<Owner> {

  private final String id;
  private final String name;
  private final List<Dog> dogs;

  private Owner(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.dogs = builder.dogs;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Dog> getDogs() {
    return dogs;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String id;
    private String name;
    private List<Dog> dogs;

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setDogs(List<Dog> dogs) {
      this.dogs = dogs;
      return this;
    }

    public Owner build() {
      return new Owner(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Owner owner = (Owner) o;
    return Objects.equals(id, owner.id) &&
      Objects.equals(name, owner.name) &&
      Objects.equals(dogs, owner.dogs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, name, dogs);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Owner.class.getSimpleName() + "[", "]")
      .add("id='" + id + "'")
      .add("name='" + name + "'")
      .add("dogs=" + dogs)
      .toString();
  }
}
