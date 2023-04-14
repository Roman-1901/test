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
            this.login = login;
            this.email = email;
        }
        public void equalsLoginEmail() {
            if (getEmail().equals(getLogin())) {
                throw new RuntimeException("Логин и email совпадают");
            }
        }
        public void checkEmail() {
          boolean check = EmailValidator.getInstance().isValid(getEmail());
          if (!check) {
              throw new RuntimeException("Введен некорректный email");
          }
        }
    }


