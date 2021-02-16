package com.pets.web.mapper;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.model.DogQueryCondition;
import com.pets.web.request.DogBreedRequest;
import com.pets.web.request.DogRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetServiceMapper {

    Dog mapDog(DogRequest dogRequest);

    DogBreed mapDogBreed(DogBreedRequest dogBreedRequest);

    @Mapping(target = "sortCondition", source = "sortCondition")
    @Mapping(target = "dogNameBreed", source = "dogNameBreed")
    @Mapping(target = "dogName", source = "dogName")
    @Mapping(target = "iniPage", source = "iniPage")
    @Mapping(target = "endPage", source = "endPage")
    DogQueryCondition map(String sortCondition, String dogNameBreed,
                          String dogName, Integer iniPage, Integer endPage);
}
