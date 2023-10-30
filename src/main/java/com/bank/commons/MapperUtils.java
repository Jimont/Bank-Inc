package com.bank.commons;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {

    private final ModelMapper modelMapper;

    public MapperUtils(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public <S, T> S map(final T source, Class<S> targetClas) {
        return modelMapper.map(source, targetClas);
    }
}
