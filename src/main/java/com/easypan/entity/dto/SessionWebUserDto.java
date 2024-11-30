package com.easypan.entity.dto;

import lombok.Data;

@Data
public class SessionWebUserDto {
    private String userId;
    private String nickname;
    private Boolean admin;
    private String avatar;
}
