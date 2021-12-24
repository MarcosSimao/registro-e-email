package com.backend.registro_email.model.request;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@EqualsAndHashCode
@ToString
public class RegistroRequest {

    private final String fistName;
    private final String lastName;
    private final String email;
    private final String password;


}
