package com.pets.model;

import java.util.Objects;
import java.util.StringJoiner;

public class DogBreed {

  private final String name;
  private final String features;

  private DogBreed(Builder builder) {
    this.name = builder.name;
    this.features = builder.features;
  }

  public String getName() {
    return name;
  }

  public String getFeatures() {
    return features;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String name;
    private String features;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setFeatures(String features) {
      this.features = features;
      return this;
    }

    public DogBreed build() {
      return new DogBreed(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DogBreed dogBreed = (DogBreed) o;
    return Objects.equals(name, dogBreed.name) &&
      Objects.equals(features, dogBreed.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, features);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DogBreed.class.getSimpleName() + "[", "]")
      .add("name='" + name + "'")
      .add("features='" + features + "'")
      .toString();
  }
}
