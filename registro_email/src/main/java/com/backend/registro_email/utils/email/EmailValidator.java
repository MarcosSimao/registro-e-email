package com.backend.registro_email.utils.email;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }
}
