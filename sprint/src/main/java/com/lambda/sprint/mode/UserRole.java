package com.lambda.sprint.mode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "userroles")
public class UserRole {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userRole","hibernateLazyInitializer"})
    @JoinColumn(name = "userid")
    private User user;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userRole","hibernateLazyInitializer"})
    @JoinColumn(name = "roleid")
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
