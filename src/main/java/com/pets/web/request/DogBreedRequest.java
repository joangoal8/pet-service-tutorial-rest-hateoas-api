package com.pets.web.request;

import java.io.Serializable;

public class DogBreedRequest implements Serializable {

  private String name;
  private String features;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }
}
