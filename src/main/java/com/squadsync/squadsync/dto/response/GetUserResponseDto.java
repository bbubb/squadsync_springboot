package com.squadsync.squadsync.dto.response;

import com.squadsync.squadsync.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetUserResponseDto {
    private List<UserDto> userDtoList;
}
