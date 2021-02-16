package com.pets.model;

public class DogQueryCondition {

  private String sortCondition;
  private String dogNameBreed;
  private String dogName;
  private int iniPage;
  private int endPage;

  public String getSortCondition() {
    return sortCondition;
  }

  public void setSortCondition(String sortCondition) {
    this.sortCondition = sortCondition;
  }

  public String getDogNameBreed() {
    return dogNameBreed;
  }

  public void setDogNameBreed(String dogNameBreed) {
    this.dogNameBreed = dogNameBreed;
  }

  public String getDogName() {
    return dogName;
  }

  public void setDogName(String dogName) {
    this.dogName = dogName;
  }

  public int getIniPage() {
    return iniPage;
  }

  public void setIniPage(int iniPage) {
    this.iniPage = iniPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public void setEndPage(int endPage) {
    this.endPage = endPage;
  }
}
