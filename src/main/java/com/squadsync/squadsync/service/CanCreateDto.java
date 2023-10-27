package com.squadsync.squadsync.service;

import com.squadsync.squadsync.enums.CanCreateDtoExcludeEnum;

import java.util.List;
import java.util.stream.Collectors;

public interface CanCreateDto<DTO, ENTITY> {

    DTO createDto(ENTITY entity, CanCreateDtoExcludeEnum... canCreateDtoExcludeEnums);

    default List<DTO> createDtoList(List<ENTITY> entityList, CanCreateDtoExcludeEnum... canCreateDtoExcludeEnums) {
        return entityList
                .stream()
                .map(entity -> createDto(entity, canCreateDtoExcludeEnums))
                .collect(Collectors.toList());
    }
}
