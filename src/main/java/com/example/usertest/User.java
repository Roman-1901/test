package com.example.usertest;

import lombok.*;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

@Data
@NoArgsConstructor
class User {
    private String login;
    private String email;

    public User(String login, String email) {
        if (Objects.equals(email, login)) {
            throw new RuntimeException("Логин и email совпадают");
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalArgumentException("Введен некорректный email");
        }
        this.login = login;
        this.email = email;
    }

}


