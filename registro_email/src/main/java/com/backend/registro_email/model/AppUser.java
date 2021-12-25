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
    private String fistName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private boolean locked;
    private boolean enabled;

    public AppUser(AppUser user){
        this.id=user.getId();
        this.fistName=user.getFistName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.appUserRole=user.getAppUserRole();
        this.locked=user.isLocked();
        this.enabled=user.isEnabled();
    }
   public AppUser(String fistname, String lastName, String email,String passowrd,AppUserRole role){
        this.fistName=fistname;
        this.lastName=lastName;
        this.email=email;
        this.password=passowrd;
        this.appUserRole=role;

   }
    public AppUser(String fistName, String lastName, String email, String password, AppUserRole appUserRole, boolean locked, boolean enabled) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
}
