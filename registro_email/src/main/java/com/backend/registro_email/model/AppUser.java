package com.backend.registro_email.model;

import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class AppUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private  Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private boolean locked;
    private boolean enabled;

    public AppUser(AppUser user){
        this.id=user.getId();
        this.name=user.getName();
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.appUserRole=user.getAppUserRole();
        this.locked=user.isLocked();
        this.enabled=user.isEnabled();
    }

    public AppUser(String name, String username, String email, String password, AppUserRole appUserRole, boolean locked, boolean enabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
}
