package com.hexagonal.hexagonalarchitecture.infraestructure.config;

import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@Mapper
@AllArgsConstructor
public class MapStructClassMapper {

    private ModelMapper mapper;

    public <T, D> D mapperClass(T entity, Class<D> DClass) {
        return mapper.map(entity, DClass);
    }

}
