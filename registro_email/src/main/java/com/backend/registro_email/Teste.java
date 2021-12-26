package com.backend.registro_email;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args)
    {
        // Parses the first date
        LocalDate dt1 = LocalDate.parse("2018-11-27");
        // Parses the second date
        LocalDate dt2 = LocalDate.parse("2018-11-28");

        // Checks
        System.out.println(dt1.isBefore(dt2));
    }
}
