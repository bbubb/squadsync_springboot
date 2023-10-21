package com.squadsync.squadsync.service;

import com.squadsync.squadsync.dto.UserDto;
import com.squadsync.squadsync.entity.UserEntity;
import com.squadsync.squadsync.enums.CanCreateDtoExcludeEnum;
import lombok.NonNull;

public class UserDtoService implements CanCreateDto<UserDto, UserEntity> {

    @Override
    public UserDto createDto(
            @NonNull UserEntity userEntity,
            CanCreateDtoExcludeEnum... canCreateDtoExcludeEnums) {

        UserDto userDto = new UserDto();
        userDto.setUuid(userEntity.getUuid());
        userDto.setEmail(userEntity.getEmail());
        userDto.setEmailUpperCase(userEntity.getEmailUpperCase());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        if (userEntity.getRoleEnum() != null) {
            userDto.setRole(userEntity.getRoleEnum().name());
        }
        if (userEntity.getUserStatusEnum() != null) {
            userDto.setUserStatus(userEntity.getUserStatusEnum().name());
        }
        return userDto;
    }
}
