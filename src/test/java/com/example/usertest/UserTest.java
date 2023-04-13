package com.example.usertest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {
    User user = new User("Roman", "roman@mail.ru");

    @Test
    void showUser() {
        Assertions.assertNotNull(user.getLogin());
        Assertions.assertNotNull(user.getEmail());
    }

    @Test
    void showUserNoParameters() {
        User user = new User();
        Assertions.assertNull(user.getLogin());
        Assertions.assertNull(user.getEmail());
    }



    @Test
    void emailTest() {
        Assertions.assertTrue(user.getEmail().contains("@"));
        Assertions.assertTrue(user.getEmail().contains("."));
    }

    @Test
    void equalsLoginEmail() {
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }
}