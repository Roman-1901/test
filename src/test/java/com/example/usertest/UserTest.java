package com.example.usertest;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;


class UserTest {
    User user = new User("Roman", "roman@mail.ru");
    public static final String EMAIL_MESSAGE = "Email введен корректно";
    public static final String EMAIL_LOGIN_NOT_EQUALS = "Логин и email не совпадают";


    @Test
    void showUser() {
        Assertions.assertNotNull(user.getLogin());
        Assertions.assertNotNull(user.getEmail());
        Assertions.assertEquals("Roman", user.getLogin());
        Assertions.assertEquals("roman@mail.ru", user.getEmail());
    }

    @Test
    void showUserNoParameters() {
        User user = new User();
        Assertions.assertNull(user.getLogin());
        Assertions.assertNull(user.getEmail());
    }


    @Test
    void emailTest() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, user::checkEmail, EMAIL_MESSAGE);
        Assertions.assertEquals(EMAIL_MESSAGE, thrown.getMessage());
    }


    @Test
    void equalsLoginEmail() {
   //     User user = new User("roman@mail.ru", "roman@mail.ru");
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, user::equalsLoginEmail, EMAIL_LOGIN_NOT_EQUALS);
        Assertions.assertEquals(EMAIL_LOGIN_NOT_EQUALS, thrown.getMessage());
    }
}