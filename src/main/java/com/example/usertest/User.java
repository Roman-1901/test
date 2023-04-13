package com.example.usertest;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public record User(String login, String email) {
}

