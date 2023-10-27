package com.squadsync.squadsync.entity;

import com.squadsync.squadsync.dto.UserDto;
import com.squadsync.squadsync.enums.RoleEnum;
import com.squadsync.squadsync.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS",
        uniqueConstraints = {
                @UniqueConstraint(name = "uuid_user_uc", columnNames = "uuid"),
                @UniqueConstraint(name = "email_user_uc", columnNames = "email")
        })
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    public UserEntity(UserDto userDto) {
        this.setUuid(userDto.getUuid());
        this.setEmail(userDto.getEmail());
        this.setEmailUpperCase(userDto.getEmailUpperCase());
        this.setFirstName(userDto.getFirstName());
        this.setLastName(userDto.getLastName());
        this.setUserStatusEnum(UserStatusEnum.valueOf(userDto.getUserStatus()));
        this.setRoleEnum(RoleEnum.valueOf(userDto.getRole()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "uuid", nullable = false, updatable = false)
    private String uuid;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "email_upper_case", nullable = false)
    private String emailUpperCase;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_status", nullable = false)
    private UserStatusEnum userStatusEnum;

    @Column(name = "role")
    private RoleEnum roleEnum;
}
