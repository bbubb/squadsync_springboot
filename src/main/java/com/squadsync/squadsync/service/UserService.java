package com.squadsync.squadsync.service;

import com.squadsync.squadsync.advice.UserNotFoundException;
import com.squadsync.squadsync.dto.UserDto;
import com.squadsync.squadsync.entity.UserEntity;
import com.squadsync.squadsync.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoService userDtoService;

    @Autowired
    public UserService(@NonNull UserRepository userRepository,
                       @NonNull UserDtoService userDtoService) {

        this.userRepository = userRepository;
        this.userDtoService = userDtoService;
    }

    public List<UserDto> getAllUsers() {
        return this.userRepository
                .findAll()
                .stream()
                .map(this.userDtoService::createDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserSingleByUuid(@NonNull String uuid) {
        Optional<UserEntity> userEntity = this.userRepository.findByUuid(uuid);

        if (userEntity.isPresent()) {
            return this.userDtoService.createDto(userEntity.get());
        } else {
            throw new UserNotFoundException("User can not be found or does not exist with provided uuid.");
        }
    }

    public UserDto getUserByEmail(String email) {
        String emailUpperCase = email.toUpperCase();
        Optional<UserEntity> userEntity = this.userRepository.findByEmailUpperCase(emailUpperCase);

        if (userEntity.isPresent()) {
            return this.userDtoService.createDto(userEntity.get());
        } else {
            throw new UserNotFoundException("User can not be found or does not exist with " + email + " email.");
        }
    }
}
