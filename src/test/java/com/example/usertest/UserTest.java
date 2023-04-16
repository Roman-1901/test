package com.example.usertest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User(login, email);

    public static String login = "Roman";
    public static String email = "roman@mail.ru";
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
        email = "@default.mail";
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(login, email), EMAIL_MESSAGE);
        Assertions.assertEquals(EMAIL_MESSAGE, thrown.getMessage());
    }

    @Test
    void equalsLoginEmail() {
        login = "default@mail.ru";
        email = "default@mail.ru";
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> new User(login, email), EMAIL_LOGIN_NOT_EQUALS);
        Assertions.assertEquals(EMAIL_LOGIN_NOT_EQUALS, thrown.getMessage());
    }
}