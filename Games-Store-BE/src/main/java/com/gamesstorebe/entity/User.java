package com.gamesstorebe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class User implements UserDetails {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Column(name = "day_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date DOB;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private boolean status;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name="username")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> userRole;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userRole;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }
}
