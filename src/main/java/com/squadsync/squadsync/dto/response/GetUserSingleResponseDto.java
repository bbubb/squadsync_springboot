package com.squadsync.squadsync.dto.response;

import com.squadsync.squadsync.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class GetUserSingleResponseDto {
    private UserDto userDto;
}
