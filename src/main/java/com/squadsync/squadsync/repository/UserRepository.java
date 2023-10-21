package com.squadsync.squadsync.repository;

import com.squadsync.squadsync.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUuid(@NonNull final String uuid);

    Optional<UserEntity> findByEmailUpperCase(String emailUpperCase);

    Optional<UserEntity> findByLastNameAndFirstName(String lastName, String firstName);
}
