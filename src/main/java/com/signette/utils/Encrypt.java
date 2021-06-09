package com.signette.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {
    public static BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
