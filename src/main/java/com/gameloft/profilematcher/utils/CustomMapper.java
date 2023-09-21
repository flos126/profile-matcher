package com.gameloft.profilematcher.utils;

import jakarta.annotation.PostConstruct;
import org.modelmapper.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CustomMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    Provider<LocalDateTime> localDateProvider = new AbstractProvider<>() {
        @Override
        public LocalDateTime get() {
            return LocalDateTime.now();
        }
    };

    Converter<String, LocalDateTime> toStringDate = new AbstractConverter<>() {
        @Override
        protected LocalDateTime convert(String source) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.DATABASE_DATE_FORMAT);
            return LocalDateTime.parse(source, format);
        }
    };

    @PostConstruct
    protected void setModelMapper(){
        modelMapper.createTypeMap(String.class, LocalDateTime.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class, LocalDateTime.class).setProvider(localDateProvider);

    }

    public <E, R> R convertToType(E source, Class<R> resultClass) {
        return modelMapper.map(source, resultClass);
    }
}
