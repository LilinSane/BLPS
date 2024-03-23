package com.example.blps_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientDTO {
    @NotBlank(message = "Имя пользователя не должно состоять только из пробельных символов")
    @NotEmpty(message = "Имя пользователя не должно быть пустым")
    private String name;
    @NotBlank(message = "Логин пользователя не должно состоять только из пробельных символов")
    @NotEmpty(message = "Логин пользователя не должно быть пустым")
    @Size(max = 20, message = "Логин должен состоять максимум из 20 символов")
    private String login;
    @NotBlank(message = "Пароль пользователя не должно состоять только из пробельных символов")
    @NotEmpty(message = "Пароль пользователя не должно быть пустым")
    @Size(min=8, message = "Пароль должен состоять минимум из 8 символов")
    private String password;
}
