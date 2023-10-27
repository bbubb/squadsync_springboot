package com.squadsync.squadsync.service;

import com.squadsync.squadsync.dto.UserDto;
import com.squadsync.squadsync.entity.UserEntity;
import com.squadsync.squadsync.enums.CanCreateDtoExcludeEnum;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDtoService implements CanCreateDto<UserDto, UserEntity> {

    @Autowired
    public UserDtoService() {
    }
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
