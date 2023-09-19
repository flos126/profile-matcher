package com.gameloft.profilematcher.utils;

import org.modelmapper.ModelMapper;

public class CustomMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public <E, R> R convertToType(E source, Class<R> resultClass) {
        return modelMapper.map(source, resultClass);
    }
}
