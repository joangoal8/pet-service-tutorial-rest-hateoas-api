package com.pets.web.mapper;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.web.request.DogBreedRequest;
import com.pets.web.request.DogRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetServiceMapper {

    Dog mapDog(DogRequest dogRequest);

    DogBreed mapDogBreed(DogBreedRequest dogBreedRequest);
}
