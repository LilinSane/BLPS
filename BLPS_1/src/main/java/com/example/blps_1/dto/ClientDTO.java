package com.example.blps_1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientDTO {

    private String name;
    private String login;
    private String password;
}
